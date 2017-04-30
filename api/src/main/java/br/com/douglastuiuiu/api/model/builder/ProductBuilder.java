package br.com.douglastuiuiu.api.model.builder;

import br.com.douglastuiuiu.api.model.document.Product;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class ProductBuilder {

    private Product product;

    private ProductBuilder() {
        product = new Product();
    }

    public static ProductBuilder newInstance() {
        return new ProductBuilder();
    }

    public ProductBuilder withDescription(String description) {
        product.setDescription(description);
        return this;
    }

    public ProductBuilder withManufacturer(String manufacturer) {
        product.setManufacturer(manufacturer);
        return this;
    }

    public ProductBuilder withType(String type) {
        product.setType(type);
        return this;
    }

    public Product build() {
        return product;
    }

}
