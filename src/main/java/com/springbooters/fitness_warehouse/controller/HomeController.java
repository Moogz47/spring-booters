package com.springbooters.fitness_warehouse.controller;

import com.springbooters.fitness_warehouse.model.Product;
import com.springbooters.fitness_warehouse.repository.ProductRepository;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/products")
    public String products(
        @RequestParam(defaultValue = "") String brand,
        @RequestParam(defaultValue = "") String category,
        @RequestParam(defaultValue = "name") String sortField,
        @RequestParam(defaultValue = "asc") String sortDir,
        @RequestParam(defaultValue = "0") int page,
        Model model) {

        Sort sort = sortDir.equalsIgnoreCase("desc")
            ? Sort.by(sortField).descending()
            : Sort.by(sortField).ascending();

        Page<Product> productPage = productRepository
            .findByBrandContainingIgnoreCaseAndCategoryContainingIgnoreCase(
                    brand,
                    category,
                    PageRequest.of(page, 5, sort)
            );

        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("brand", brand);
        model.addAttribute("category", category);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);

        return "products";
    }

    @GetMapping("/products/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("brands", new String[]{"Nike", "Adidas", "Puma", "Under Armour"});
        model.addAttribute("categories", new String[]{"Equipment", "Clothing", "Supplements"});
        return "product-form";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        model.addAttribute("product", product);
        model.addAttribute("brands", new String[]{"Nike", "Adidas", "Puma", "Under Armour"});
        model.addAttribute("categories", new String[]{"Equipment", "Clothing", "Supplements"});

        return "product-form";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }

    @PostMapping("/products")
    public String saveProduct(@Valid @ModelAttribute Product product,
                          BindingResult bindingResult,
                          Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("brands", new String[]{"Nike", "Adidas", "Puma", "Under Armour"});
            model.addAttribute("categories", new String[]{"Equipment", "Clothing", "Supplements"});
            return "product-form";
        }

        productRepository.save(product);
        return "redirect:/products";
    }
}