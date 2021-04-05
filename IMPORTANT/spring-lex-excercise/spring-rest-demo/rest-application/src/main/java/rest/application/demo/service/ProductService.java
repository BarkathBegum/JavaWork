package rest.application.demo.service;

import org.springframework.stereotype.Service;
import rest.application.demo.DTO.ProductDTO;

import java.util.List;

@Service
public interface ProductService {
    String addProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
}
