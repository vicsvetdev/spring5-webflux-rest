package com.vicsvetdev.spring5webfluxrest.repositories;

import com.vicsvetdev.spring5webfluxrest.model.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
}
