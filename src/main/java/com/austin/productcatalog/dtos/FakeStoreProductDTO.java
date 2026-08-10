package com.austin.productcatalog.dtos;


import com.austin.productcatalog.models.Category;
import com.austin.productcatalog.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Integer id;
    private String title;
    private String description;
    private Float price;
    private String category;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setName(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.image);
        Category categoryObj = new Category();
        categoryObj.setName(this.category);
        product.setCategory(categoryObj);
        return product;
    }
}
