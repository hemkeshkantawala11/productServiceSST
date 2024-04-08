package org.sst.productservicesst.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private double price;
    @ManyToOne
    private Category category;
    private String imageUrl;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    // print the product
//    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price + " \n\n" +
                ", category=" + category.toString()+ " \n\n" +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
