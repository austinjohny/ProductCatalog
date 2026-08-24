package com.austin.productcatalog.models;

import com.austin.productcatalog.dtos.CategoryDTO;
import com.austin.productcatalog.dtos.FakeStoreProductDTO;
import com.austin.productcatalog.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseClass {
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private double price;
    private String image;
    // Without cascade when we save a product,
    // it will not automatically save the associated category.
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    public ProductDTO toProductDTO(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.getId());
        productDTO.setName(this.name);
        productDTO.setDescription(this.description);
        productDTO.setPrice(this.price);
        productDTO.setImage(this.image);
        if(this.getCategory() != null){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(this.category.getId());
            categoryDTO.setName(this.category.getName());
            categoryDTO.setDesp(this.category.getDescription());
            productDTO.setCategory(categoryDTO);
        }
        return productDTO;
    }

    public FakeStoreProductDTO toFakestoreDTO() {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId((int) this.getId());
        fakeStoreProductDTO.setTitle(this.name);
        fakeStoreProductDTO.setDescription(this.description);
        fakeStoreProductDTO.setPrice((float) this.price);
        if (this.category != null) {
            fakeStoreProductDTO.setCategory(this.category.getName());
        }
        fakeStoreProductDTO.setImage(this.image);
        return fakeStoreProductDTO;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", category=" + (category != null ? category.getName() : null) +
                '}';
    }
}
