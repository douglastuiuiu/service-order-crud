package br.com.douglastuiuiu.api.model.builder;

import br.com.douglastuiuiu.api.model.dto.ClientDTO;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class ClientDTOBuilder {

    private ClientDTO clientDTO;

    private ClientDTOBuilder() {
        clientDTO = new ClientDTO();
    }

    public static ClientDTOBuilder newInstance() {
        return new ClientDTOBuilder();
    }

    public ClientDTOBuilder withName(String name) {
        clientDTO.setName(name);
        return this;
    }

    public ClientDTOBuilder withAddress(String address) {
        clientDTO.setAddress(address);
        return this;
    }

    public ClientDTOBuilder withEmail(String email) {
        clientDTO.setEmail(email);
        return this;
    }

    public ClientDTOBuilder withPhone(String phone) {
        clientDTO.setPhone(phone);
        return this;
    }

    public ClientDTO build() {
        return clientDTO;
    }

}
