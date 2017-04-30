package br.com.douglastuiuiu.api.model.builder;

import br.com.douglastuiuiu.api.model.dto.ProductDTO;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class ProductDTOBuilder {

    private ProductDTO productDTO;

    private ProductDTOBuilder() {
        productDTO = new ProductDTO();
    }

    public static ProductDTOBuilder newInstance() {
        return new ProductDTOBuilder();
    }

    public ProductDTOBuilder withDescription(String description) {
        productDTO.setDescription(description);
        return this;
    }

    public ProductDTOBuilder withManufacturer(String manufacturer) {
        productDTO.setManufacturer(manufacturer);
        return this;
    }

    public ProductDTOBuilder withType(String type) {
        productDTO.setType(type);
        return this;
    }

    public ProductDTO build() {
        return productDTO;
    }

}
