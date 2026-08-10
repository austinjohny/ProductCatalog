package com.austin.productcatalog.models;

import com.austin.productcatalog.dtos.CategoryDTO;
import com.austin.productcatalog.dtos.ProductDTO;
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

    public ProductDTO toProductDTO(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.getId());
        productDTO.setName(this.name);
        productDTO.setDescription(this.description);
        productDTO.setPrice(this.price);
        productDTO.setImageUrl(this.imageUrl);
        if(this.getCategory() != null){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(this.category.getId());
            categoryDTO.setName(this.category.getName());
            categoryDTO.setDescription(this.category.getDescription());
            productDTO.setCategory(categoryDTO);
        }
        return productDTO;
    }
}
