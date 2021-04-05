package rest.application.demo.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.application.demo.DTO.ProductDTO;
import rest.application.demo.model.Product;
import rest.application.demo.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {
    @Autowired
    private ProductRepository productRepository;

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
