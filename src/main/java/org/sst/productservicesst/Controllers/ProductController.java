package org.sst.productservicesst.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sst.productservicesst.DTOs.ExceptionDTO;
import org.sst.productservicesst.DTOs.FakeStoreProductDTO;
import org.sst.productservicesst.Models.Product;
import org.sst.productservicesst.Services.FakeStoreProductService;
import org.sst.productservicesst.Services.ProductService;
import org.sst.productservicesst.Services.ProductServices;

import java.util.List;


// Controllers are like the waiter in the restaurant which provides the connection between the consumer to the chef.
@RestController// This help in hosting the HTTP API's.
@RequestMapping("/products")
public class ProductController {
    private final ProductServices productServices;
    private FakeStoreProductService fakeStoreProductService;

    ProductController(FakeStoreProductService fakeStoreProductService, ProductServices productServices){
        this.fakeStoreProductService = fakeStoreProductService;
        this.productServices = productServices;
    }

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable("id") long id){
//        Product product = null;
//        ResponseEntity responseEntity = null;
//        try{
//            product = fakeStoreProductService.getProductByID(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//            return responseEntity;
//        }
//        catch (RuntimeException e){
//            ResponseEntity<ExceptionDTO> responseEntity2 = null;
//            ExceptionDTO exceptionDTO = new ExceptionDTO();
//            exceptionDTO.setMessage("Write Correct ID!!");
//            exceptionDTO.setResolution("Set id between 1-20");
//            responseEntity2 = new ResponseEntity<>(exceptionDTO,HttpStatus.NOT_FOUND);
//            return responseEntity2;
//        }
        return fakeStoreProductService.getProductByID(id);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){

        return fakeStoreProductService.getAllProducts();

    }
}
