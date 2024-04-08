package org.sst.productservicesst.Controllers;

import org.springframework.web.bind.annotation.*;
import org.sst.productservicesst.Models.Product;
import org.sst.productservicesst.Services.FakeStoreProductService;
import org.sst.productservicesst.Services.ProductService;

import java.util.List;


// Controllers are like the waiter in the restaurant which provides the connection between the consumer to the chef.
@RestController// This help in hosting the HTTP API's.
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private FakeStoreProductService fakeStoreProductService;

    ProductController(FakeStoreProductService fakeStoreProductService, ProductService productService){
        this.fakeStoreProductService = fakeStoreProductService;
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable("id") Long id){
        return fakeStoreProductService.getProductByID(id);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){

        return fakeStoreProductService.getAllProducts();

    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
//        System.out.println("product recieved");
        return productService.createProduct(product);
    }
}
