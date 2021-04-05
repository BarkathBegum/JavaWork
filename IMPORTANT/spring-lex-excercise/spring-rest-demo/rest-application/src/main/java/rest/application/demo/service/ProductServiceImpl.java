package rest.application.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.application.demo.DTO.ProductDTO;
import rest.application.demo.model.Product;
import rest.application.demo.repository.ProductRepository;
import rest.application.demo.service.mapper.ProductMapper;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    @Override
    public String addProduct(ProductDTO productDTO) {
        Product product = productMapper.convertToProductEntity(productDTO);
        productRepository.save(product);
        return "Product added successfully";
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productMapper.getAllProducts();
    }
}
