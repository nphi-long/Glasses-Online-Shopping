package sof302.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sof302.assignment.entities.Bill;
import sof302.assignment.entities.Billdetails;
import sof302.assignment.entities.Product;
import sof302.assignment.entities.User;
import sof302.assignment.model.Cart;
import sof302.assignment.service.IBillDetailsService;
import sof302.assignment.service.IBillService;
import sof302.assignment.service.IProductService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    IProductService productSv;
    @Autowired
    IBillService billSv;
    @Autowired
    IBillDetailsService billDetailsSv;

    // Add to cart
    @GetMapping("/cart")
    public String returnCartPage(HttpSession session, ModelMap model) {
        List<Cart> cartList = (List<Cart>) session.getAttribute("cart");
        double tongTien = 0;
        if (cartList != null) {
            for (Cart cart1 : cartList) {
                tongTien += cart1.getProduct().getPrice() * cart1.getQuantity();
            }
        }
        model.addAttribute("tongTien", tongTien);
        return "Cart";
    }

    @GetMapping("/addtocart/{id}")
    public String AddToCartProduct(@PathVariable("id") Integer id, HttpSession session, ModelMap model) {
        User user = (User) session.getAttribute("user"); // Get Current User
        if (user == null) // If user is not logged in
            return "redirect:/login"; // => Redirect "/login"
        else { // If user is already logged in
            List<Cart> cartList = (List<Cart>) session.getAttribute("cart");
            Product currentProduct = productSv.findById(id);
            Cart cart = new Cart();
            if (cartList == null) {
                cartList = new ArrayList<Cart>();
                cart.setProduct(currentProduct);
                cart.setQuantity(1);
                cartList.add(cart);
            } else {
                boolean check = true;
                for (Cart cart1 : cartList) {
                    if (cart1.getProduct().getPid() == currentProduct.getPid()) {
                        cart1.setQuantity(cart1.getQuantity() + 1);
                        check = false;
                    }
                }
                if (check) {
                    cart.setProduct(currentProduct);
                    cart.setQuantity(1);
                    cartList.add(cart);
                }
            }
            session.setAttribute("cart", cartList);
            return "redirect:/home";
        }
    }
    // /Add To Cart

    // Remove product form Cart
    @GetMapping("/removecart/{id}")
    public String removeProductFromCart(@PathVariable("id") Integer id, HttpSession session, ModelMap model) {
        List<Cart> cartList = (List<Cart>) session.getAttribute("cart");
        Cart cartConcurrentModification = null;
        for (Cart cart : cartList) {
            if (cart.getProduct().getPid() == id) {
                if (cart.getQuantity() > 1) {
                    cart.setQuantity(cart.getQuantity() - 1);
                } else { // Xóa luôn thì sẽ bị ConcurrentModification Exception
                    cartConcurrentModification = cart;
                }
            }
        }
        if (cartConcurrentModification != null) {
            cartList.remove(cartConcurrentModification);
            if (cartList == null)
                session.removeAttribute("cart");
        }
        session.setAttribute("cart", cartList);
        double tongTien = 0;
        for (Cart cart : cartList) {
            tongTien += cart.getProduct().getPrice() * cart.getQuantity();
        }
        model.addAttribute("tongTien", tongTien);
        return "Cart";
    }
}
