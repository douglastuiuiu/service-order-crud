package br.com.douglastuiuiu.api.model.builder;

import br.com.douglastuiuiu.api.model.document.Client;
import br.com.douglastuiuiu.api.model.document.Product;
import br.com.douglastuiuiu.api.model.dto.ClientDTO;
import br.com.douglastuiuiu.api.model.dto.OrderDTO;
import br.com.douglastuiuiu.api.model.dto.ProductDTO;

import java.time.LocalDateTime;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class OrderDTOBuilder {

    private OrderDTO orderDTO;

    private OrderDTOBuilder() {
        orderDTO = new OrderDTO();
    }

    public static OrderDTOBuilder newInstance() {
        return new OrderDTOBuilder();
    }

    public OrderDTOBuilder withId(String id) {
        orderDTO.setId(id);
        return this;
    }

    public OrderDTOBuilder withCreateAt(LocalDateTime date) {
        orderDTO.setCreateAt(date);
        return this;
    }

    public OrderDTOBuilder withUpdateAt(LocalDateTime date) {
        orderDTO.setUpdateAt(date);
        return this;
    }

    public OrderDTOBuilder withClient(Client client) {
        orderDTO.setClient(ClientDTO.parseClientDTO(client));
        return this;
    }

    public OrderDTOBuilder withDescription(String description) {
        orderDTO.setDescription(description);
        return this;
    }

    public OrderDTOBuilder withProduct(Product product) {
        orderDTO.setProduct(ProductDTO.parseProductDTO(product));
        return this;
    }

    public OrderDTOBuilder withFinished(Boolean finished) {
        orderDTO.setFinished(finished);
        return this;
    }

    public OrderDTO build() {
        return orderDTO;
    }

}
