package org.sst.productservicesst.Services;

import org.sst.productservicesst.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductByID(long id);
    List<Product> getAllProducts();
}
