package com.austin.productcatalog.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResponseDTO {
    private List<ProductDTO> productDTOList;
    private int pageSize;
    private int pageNumber;
}
