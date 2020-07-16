package sof302.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sof302.assignment.service.IProductService;

@Controller
public class AdminController {
    @Autowired
    IProductService productService;

    @GetMapping("/admin/remove/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        productService.deleteProductById(id);
        return "redirect:/admin";
    }
}
