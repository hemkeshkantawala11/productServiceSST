package org.sst.productservicesst.Services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.sst.productservicesst.Models.Category;
import org.sst.productservicesst.Models.Product;
import org.sst.productservicesst.exceptions.ProductNotFoundException;
import org.sst.productservicesst.repositeries.CategoryRepository;
import org.sst.productservicesst.repositeries.ProductRepository;

import java.util.*;

@Service("SelfProductService")
@Primary
public class SelfProductService implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductByID(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException(id, "Product Not Found");
        }
        else{
            return productOptional.get();
        }


    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product)
    {
        System.out.println("product: "+product.toString());
        Category category = product.getCategory();
        Category savedCategory = null;

        if(category.getId() != null) {
            savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }
        return productRepository.save(product);
    }
}
