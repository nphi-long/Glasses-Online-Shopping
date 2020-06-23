package sof302.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sof302.assignment.entities.Bill;
import sof302.assignment.entities.Product;
import sof302.assignment.entities.User;
import sof302.assignment.service.IProductService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    IProductService productSV;
    // Add to cart
    @GetMapping("/addtocart/{id}")
    public String returnCartPage(@PathVariable("id") Integer id, HttpSession session){
        Product currentProduct = productSV.findById(id);
        Bill bill = (Bill) session.getAttribute("bill");
        User user = (User) session.getAttribute("user");
        if(bill == null){
            if(user == null){

            }
            List<Product> products = new ArrayList<Product>();
        }
        return "Cart";
    }
}
