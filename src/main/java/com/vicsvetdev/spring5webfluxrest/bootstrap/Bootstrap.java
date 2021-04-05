package com.vicsvetdev.spring5webfluxrest.bootstrap;

import com.vicsvetdev.spring5webfluxrest.model.Category;
import com.vicsvetdev.spring5webfluxrest.model.Vendor;
import com.vicsvetdev.spring5webfluxrest.repositories.CategoryRepository;
import com.vicsvetdev.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count().block() == 0) {
            //load data
            System.out.println("###### LOADING CATEGORIES ON BOOTSTRAP ######");

            categoryRepository.save(Category.builder()
                    .description("Fruits").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Nuts").build());

            categoryRepository.save(Category.builder()
                    .description("Breads").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Meats").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Eggs").build()).block();

            System.out.println("Loaded Categories: " + categoryRepository.count().block());
        }

        if(vendorRepository.count().block() == 0) {
            System.out.println("###### LOADING VENDORS ON BOOTSTRAP ######");

            vendorRepository.save(Vendor.builder()
                    .firstName("Michael").lastName("Scott").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Jim").lastName("Halpert").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Pam").lastName("Beasly").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Robert").lastName("California").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Stanley").lastName("Hudson").build()).block();

            System.out.println("Loaded Vendors: " + vendorRepository.count().block());
        }

    }
}

