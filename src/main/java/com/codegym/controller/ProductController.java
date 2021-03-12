package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.category.CategoryService;
import com.codegym.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @ModelAttribute("categoryList")
    public List<Category> allCategory() {
        return categoryService.getAll();
    }

    @GetMapping("/index")
    public ModelAndView showListProduct() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("list", productService.getAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createProduct(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products/index");
        productService.addProduct(product);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/{id}/edit")
    public ModelAndView editProduct(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView("redirect:/products/index");
        productService.editProduct(product);
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView viewProduct(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/view");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delProduct(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/products/index");
        productService.delProduct(id);
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView findByCategory(@ModelAttribute Category category){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("list", productService.findAllByCategory(category));
        return modelAndView;
    }

    @PostMapping("/searchtop5")
    public ModelAndView findTop5ByPrice(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("list", productService.findTop5ByOrderByPriceDesc());
        return modelAndView;
    }

    @PostMapping("/searchtop5bydate")
    public ModelAndView findTop5ByDate(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("list", productService.findTop5ByOrderByDateDesc());
        return modelAndView;
    }

    @PostMapping("/sum")
    public ModelAndView sumPrice(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("result", productService.getSumPrice());
        return modelAndView;
    }

}
