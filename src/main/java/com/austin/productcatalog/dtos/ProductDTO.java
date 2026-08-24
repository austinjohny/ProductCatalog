package com.austin.productcatalog.dtos;

import com.austin.productcatalog.models.Category;
import com.austin.productcatalog.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String image;
    private CategoryDTO category;

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImage(this.image);
        if (this.category != null) {
            Category categoryObj = new Category();
            categoryObj.setId(this.category.getId());
            categoryObj.setName(this.category.getName());
            categoryObj.setDescription(this.category.getDesp());
            product.setCategory(categoryObj);
        }
        return product;
    }
}
