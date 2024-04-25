package org.sst.productservicesst.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.sst.productservicesst.Models.Category;

@Getter
@Setter
public class FakeStoreProductDTO {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

}
