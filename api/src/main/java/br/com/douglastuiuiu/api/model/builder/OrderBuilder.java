package br.com.douglastuiuiu.api.model.builder;

import br.com.douglastuiuiu.api.model.document.Client;
import br.com.douglastuiuiu.api.model.document.Order;
import br.com.douglastuiuiu.api.model.document.Product;
import br.com.douglastuiuiu.api.model.dto.ClientDTO;
import br.com.douglastuiuiu.api.model.dto.ProductDTO;

import java.time.LocalDateTime;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class OrderBuilder {

    private Order order;

    private OrderBuilder() {
        order = new Order();
    }

    public static OrderBuilder newInstance() {
        return new OrderBuilder();
    }

    public OrderBuilder withId(String id) {
        order.setId(id);
        return this;
    }

    public OrderBuilder withCreateAt(LocalDateTime date) {
        order.setCreateAt(date);
        return this;
    }

    public OrderBuilder withUpdateAt(LocalDateTime date) {
        order.setUpdateAt(date);
        return this;
    }

    public OrderBuilder withClient(ClientDTO clientDTO) {
        order.setClient(Client.parseClient(clientDTO));
        return this;
    }

    public OrderBuilder withDescription(String description) {
        order.setDescription(description);
        return this;
    }

    public OrderBuilder withProduct(ProductDTO productDTO) {
        order.setProduct(Product.parseProduct(productDTO));
        return this;
    }

    public OrderBuilder withFinished(Boolean finished) {
        order.setFinished(finished);
        return this;
    }

    public Order build() {
        return order;
    }

}
