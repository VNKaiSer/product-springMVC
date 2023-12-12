package com.example.VoTanDat.frontend.controllers;

import com.example.VoTanDat.backend.models.Product;
import com.example.VoTanDat.backend.services.CategoryService;
import com.example.VoTanDat.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@ComponentScan(basePackages = "com.example.VoTanDat")
public class PageController {
    @Autowired private  ProductService productService;
    @Autowired private CategoryService categoryService;
    @GetMapping("/")
    public String index() {
        productService.getAllProduct().forEach(System.out::println);
        return "index";
    }
    // show page products

    @GetMapping("/products")
    public String products(
            @Param("categoryId") long categoryId,
            Model model) {

        model.addAttribute("products", productService.getProductByCategory(categoryId));
        return "products/index";

    }

    // show page category
    @GetMapping("/categories")
    public String categories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "category/index";
    }

    // Show page create product
    @GetMapping("/products/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "products/create";
    }

    // Post form create product
    @PostMapping("/products/create")
    public String create(Product product) {
        productService.addProduct(product);
        return "redirect:/products?categoryId=" + product.getCategory().getId();
    }

    @GetMapping("/products/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.getProductById(id).get() != null ? productService.getProductById(id).get() : new Product());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "products/edit";
    }

    @PostMapping("/products/edit")
    public String edit(Product product) {
        productService.updateProduct(product);
        return "redirect:/products?categoryId=" + product.getCategory().getId();
    }

    @GetMapping("/products/delete/{id}")
    public String delete( @PathVariable int id) {
        Product product = productService.getProductById(id).get();
        productService.deleteProduct(product);
        return "redirect:/products?categoryId=" + product.getCategory().getId();
    }


}
