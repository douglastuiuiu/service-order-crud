package br.com.douglastuiuiu.api.model.document;

import br.com.douglastuiuiu.api.model.builder.ClientBuilder;
import br.com.douglastuiuiu.api.model.dto.ClientDTO;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
//@Document(collection = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 7496044973670216958L;

    @Field
    private String name;
    @Field
    private String email;
    @Field
    private String phone;
    @Field
    private String address;

    public Client() {
    }

    public static Client parseClient(ClientDTO clientDTO) {
        return ClientBuilder.newInstance()
                .withAddress(clientDTO.getAddress())
                .withPhone(clientDTO.getPhone())
                .withEmail(clientDTO.getEmail())
                .withName(clientDTO.getName())
                .build();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{name='" + name + '\'' + '}';
    }
}
