package br.com.douglastuiuiu.api.model.dto;

import br.com.douglastuiuiu.api.model.builder.ProductDTOBuilder;
import br.com.douglastuiuiu.api.model.document.Product;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
@Document(collection = "product")
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -4357922876301852740L;

    private String id;
    @NotBlank
    private String type;
    @NotBlank
    private String manufacturer;
    @NotBlank
    private String description;

    public ProductDTO() {
    }

    public static ProductDTO parseProductDTO(Product product) {
        return ProductDTOBuilder.newInstance()
                .withDescription(product.getDescription())
                .withManufacturer(product.getManufacturer())
                .withType(product.getType())
                .build();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Product{id='" + id + '\'' + '\'' + ", type='" + type + '\'' + ", manufacturer='" + manufacturer + '\'' + '}';
    }
}
