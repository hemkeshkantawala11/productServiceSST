package org.sst.productservicesst.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.sst.productservicesst.DTOs.FakeStoreProductDTO;
import org.sst.productservicesst.Models.Category;
import org.sst.productservicesst.Models.Product;
import org.sst.productservicesst.exceptions.ProductNotFoundException;

import java.util.*;


@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductByID(Long id) {

        RestTemplate restTemplate = new RestTemplate();

        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);

        if(fakeStoreProductDTO == null){
            throw new ProductNotFoundException(id, "Enter Valid ID");
        }
        return convertProductDTOtoProduct(fakeStoreProductDTO);
    }

    public List<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();

        FakeStoreProductDTO[] list = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
        List<Product> list1 = new ArrayList<>();
        for(int i = 0 ; i < list.length ; i++){
            list1.add(convertProductDTOtoProduct(list[i]));
        }

        return list1;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private Product convertProductDTOtoProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();

        product.setId(fakeStoreProductDTO.getId());
        product.setCategory(new Category());
        product.getCategory().setId(1L);
        product.getCategory().setDescription("Hemkesh");
        product.getCategory().setTitle("Hemkesh");

        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImageUrl(fakeStoreProductDTO.getImage());

        return product;

    }
}
