package sof302.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sof302.assignment.consts.BillStatus;
import sof302.assignment.entities.Bill;
import sof302.assignment.entities.Billdetails;
import sof302.assignment.entities.Product;
import sof302.assignment.entities.User;
import sof302.assignment.service.IBillDetailsService;
import sof302.assignment.service.IBillService;
import sof302.assignment.service.IProductService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
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
    @GetMapping("/addtocart")
    public String returnCartPage(HttpSession session, ModelMap model) {
        Bill bill = (Bill) session.getAttribute("bill");
        model.addAttribute("bill", bill);
        return "Cart";
    }

    @GetMapping("/addtocart/{id}")
    public String AddToCartProduct(@PathVariable("id") Integer id, HttpSession session) {
        User user = (User) session.getAttribute("User"); // Get Current User
        if (user == null) // If user is not logged in
            return "redirect:/login"; // => Redirect "/login"
        else { // If user is already logged in
            Bill bill = billSv.findUserBillUnpaid(user.getUid(), BillStatus.UNPAID); // Get bill that user has not paid yet
            if (bill != null) { // If user have bill that has not paid yet
                boolean check = true;
                for (Product p : bill.getProducts()) { //Option 1: Product that user add to cart is present
                    if (p.getPid() == id) {
                        Billdetails.Pk pk = new Billdetails.Pk();
                        pk.setBid(bill.getBid());
                        pk.setPid(id);
                        Billdetails billdetails = billDetailsSv.findById(pk);
                        billdetails.setQuantity(billdetails.getQuantity()+1); // Set Quantity +1
                        check = false;
                    }
                }
                if(check){ // Option 2: Product isn't present
                    Product p = productSv.findById(id);
                    List<Product> products = (ArrayList<Product>) bill.getProducts();
                    products.add(p);
                    bill.setProducts(products); // Add Product to bill
                }
            }

            else{ // If user DON'T have bill that has not unpaid yet

            }
            return "redirect:/home";
        }
    }
}
