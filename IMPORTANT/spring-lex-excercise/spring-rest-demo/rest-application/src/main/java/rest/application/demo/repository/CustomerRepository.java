package rest.application.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rest.application.demo.model.Product;

public interface CustomerRepository extends MongoRepository<Product, Long> {
}
