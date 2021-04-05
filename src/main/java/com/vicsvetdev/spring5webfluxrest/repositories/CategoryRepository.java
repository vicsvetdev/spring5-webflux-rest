package com.vicsvetdev.spring5webfluxrest.repositories;

import com.vicsvetdev.spring5webfluxrest.model.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
