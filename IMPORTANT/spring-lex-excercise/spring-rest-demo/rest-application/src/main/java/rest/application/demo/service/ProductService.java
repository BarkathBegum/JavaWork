package rest.application.demo.service;

import org.springframework.stereotype.Service;
import rest.application.demo.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    String addProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductsByNameAndVendor(String productName, String productVendor);
    List<ProductDTO> getProductsByVendor(List<String> productVendor);
}
