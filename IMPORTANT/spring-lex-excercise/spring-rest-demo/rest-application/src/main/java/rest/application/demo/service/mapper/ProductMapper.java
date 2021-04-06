package rest.application.demo.service.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.application.demo.DTO.ProductDTO;
import rest.application.demo.controller.ProductController;
import rest.application.demo.model.Product;
import rest.application.demo.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    private static Logger logger = LoggerFactory.getLogger(ProductMapper.class);

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getProductsByNameAndVendor(String productName, String productVendor) {
        //logger.info("products by name ",productRepository.findByProductName(productName));
        return (productRepository
                .findByProductNameAndProductVendor(productName, productVendor))
                .stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }
    public List<ProductDTO> getByVendors(List<String> productVendors) {
        List<Product> products = new ArrayList<>();

        for (String productVendor : productVendors) {
            Product product = (Product) productRepository.findByProductVendor(productVendor);
            products.add(product);
        }
        return products.stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getAllProducts() {
        return (productRepository
                .findAll())
                .stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductCode(product.getProductCode());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setProductVendor(product.getProductVendor());
        productDTO.setProductInStock(product.getProductInStock());
        return productDTO;
    }
    public Product convertToProductEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductCode(productDTO.getProductCode());
        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductVendor(productDTO.getProductVendor());
        product.setProductInStock(productDTO.getProductInStock());
        return product;
    }
}
