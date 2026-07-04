package com.austin.productcatalog.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseClass {
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}
