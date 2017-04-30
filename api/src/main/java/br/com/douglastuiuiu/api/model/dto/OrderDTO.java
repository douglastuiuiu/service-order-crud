package br.com.douglastuiuiu.api.model.dto;

import br.com.douglastuiuiu.api.model.builder.OrderDTOBuilder;
import br.com.douglastuiuiu.api.model.document.Order;
import br.com.douglastuiuiu.api.serializer.LocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = -1974888252658319130L;

    private String id;
    @NotNull
    private ProductDTO product;
    @Valid
    @NotNull
    private ClientDTO client;
    @NotBlank
    private String description;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createAt;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updateAt;
    private Boolean finished;

    public OrderDTO() {
    }

    public static OrderDTO parseOrderDTO(Order order) {
        return OrderDTOBuilder.newInstance()
                .withId(order.getId())
                .withClient(order.getClient())
                .withCreateAt(order.getCreateAt())
                .withDescription(order.getDescription())
                .withFinished(order.getFinished())
                .withProduct(order.getProduct())
                .withUpdateAt(order.getUpdateAt())
                .build();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Order{id='" + id + '\'' + ", client='" + client.getName() + '\'' + '}';
    }
}
