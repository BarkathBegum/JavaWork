package rest.application.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rest.application.demo.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    List<Product> findByProductNameAndProductVendor(String productName, String productVendor);
    Product findByProductVendor(String productVendor);
}
