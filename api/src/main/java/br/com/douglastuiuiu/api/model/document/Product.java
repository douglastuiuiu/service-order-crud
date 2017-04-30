package br.com.douglastuiuiu.api.model.document;

import br.com.douglastuiuiu.api.model.builder.ProductBuilder;
import br.com.douglastuiuiu.api.model.dto.ProductDTO;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
//@Document(collection = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1925718781010620301L;

    @Field
    private String type;
    @Field
    private String manufacturer;
    @Field
    private String description;

    public Product() {
    }

    public static Product parseProduct(ProductDTO productDTO) {
        return ProductBuilder.newInstance()
                .withDescription(productDTO.getDescription())
                .withManufacturer(productDTO.getManufacturer())
                .withType(productDTO.getType())
                .build();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{type='" + type + '\'' + ", manufacturer='" + manufacturer + '\'' + '}';
    }
}
