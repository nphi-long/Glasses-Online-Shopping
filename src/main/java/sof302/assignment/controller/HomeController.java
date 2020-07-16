package sof302.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import sof302.assignment.entities.Product;
import sof302.assignment.service.IProductService;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    IProductService proService;

    @GetMapping(value = {"", "/", "/home"})
    public String returnIndexPage(ModelMap model) {
        List<Product> products = proService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping(value = {"/admin"})
    public String returnAdminPage(ModelMap model) {
        List<Product> productList = proService.findAll();
        model.addAttribute("productList", productList);
        return "Admin/AdminIndex";
    }

    @GetMapping(value = {"/notfound"})
    public String returnNotFoundPage() {
        return "NotFound";
    }




}
