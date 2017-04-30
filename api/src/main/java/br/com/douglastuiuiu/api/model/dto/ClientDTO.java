package br.com.douglastuiuiu.api.model.dto;

import br.com.douglastuiuiu.api.model.builder.ClientDTOBuilder;
import br.com.douglastuiuiu.api.model.document.Client;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class ClientDTO implements Serializable {

    private static final long serialVersionUID = -8625732230697438538L;

    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;

    public ClientDTO() {
    }

    public static ClientDTO parseClientDTO(Client client) {
        return ClientDTOBuilder.newInstance()
                .withAddress(client.getAddress())
                .withEmail(client.getEmail())
                .withName(client.getName())
                .withPhone(client.getPhone())
                .build();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Client{id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}
