package rest.application.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.application.demo.DTO.ProductDTO;
import rest.application.demo.RestAppDemo;
import rest.application.demo.service.ProductService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/grocery-shop")
public class GreetingController {

    private static Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    ProductService productService;

    @GetMapping(value = "/greeting")
    public String greet(){
        return "Welcome to "+ LocalDate.now().getDayOfWeek()+" sale!";
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