package br.com.douglastuiuiu.api.model.document;

import br.com.douglastuiuiu.api.model.builder.OrderBuilder;
import br.com.douglastuiuiu.api.model.dto.OrderDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
@Document(collection = "order")
public class Order implements Serializable {

    private static final long serialVersionUID = 4905272200896982432L;

    @Id
    private String id;
    @Field
    private Product product;
    @Field
    private Client client;
    @Field
    private String description;
    @Field
    private LocalDateTime createAt;
    @Field
    private LocalDateTime updateAt;
    @Field
    private Boolean finished;

    public Order() {
    }

    public static Order parseOrder(OrderDTO orderDTO) {
        Order order = OrderBuilder.newInstance()
                .withClient(orderDTO.getClient())
                .withCreateAt(orderDTO.getCreateAt())
                .withUpdateAt(orderDTO.getUpdateAt())
                .withDescription(orderDTO.getDescription())
                .withFinished(orderDTO.getFinished())
                .withProduct(orderDTO.getProduct())
                .build();
        return order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
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
