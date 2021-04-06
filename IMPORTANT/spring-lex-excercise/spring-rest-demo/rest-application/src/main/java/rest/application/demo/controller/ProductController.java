package rest.application.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.application.demo.DTO.ProductDTO;
import rest.application.demo.model.EntityList;
import rest.application.demo.service.ProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/grocery-shop")
public class ProductController {

    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping(value = "/greeting")
    public String greet(){
        return "Welcome to "+ LocalDate.now().getDayOfWeek()+" sale!";
    }

    @GetMapping(value = "/view")
    public List<ProductDTO> getProductsByNameAndVendor(@RequestParam("productName") String productName, @RequestParam("productVendor") String productVendor){
        List<ProductDTO> productDTOList = productService.getProductsByNameAndVendor(productName, productVendor);

        logger.info("product by name and vendor list are");
        return productDTOList;
    }
    @GetMapping(value = "/view/{query}", produces = { "application/xml", "application/json"} )
    public EntityList<ProductDTO> getProductsByVendor(@MatrixVariable(pathVar = "query") Map<String, List<String>> map) {
        Set<String> keysLocalRates = map.keySet();
        List vendorList = new ArrayList();
        for (String key : keysLocalRates) {
            for (int i = 0; i < map.get(key).size(); i++) {
                vendorList.add(map.get(key).get(i));
            }
        }
        EntityList<ProductDTO> productDTOList = new EntityList<>(productService.getProductsByVendor(vendorList));

        logger.info("product using matrix values are");
        return productDTOList;
    }
    @GetMapping(value = "/viewAll")
    public List<ProductDTO> getAllProducts(){
        List<ProductDTO> productDTOList = productService.getAllProducts();

        logger.info("product list are");
        return productDTOList;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO){
        String response = productService.addProduct(productDTO);
        return ResponseEntity.ok(response);
    }
}