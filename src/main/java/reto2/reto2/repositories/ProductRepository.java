package reto2.reto2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import reto2.reto2.models.ProductModel;

public interface ProductRepository extends MongoRepository<ProductModel, String> {
    
}
