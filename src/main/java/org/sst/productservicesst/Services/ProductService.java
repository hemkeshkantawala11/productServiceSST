package org.sst.productservicesst.Services;

import org.sst.productservicesst.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductByID(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
}
