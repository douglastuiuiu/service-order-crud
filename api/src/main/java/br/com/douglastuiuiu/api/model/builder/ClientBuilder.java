package br.com.douglastuiuiu.api.model.builder;

import br.com.douglastuiuiu.api.model.document.Client;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class ClientBuilder {

    private Client client;

    private ClientBuilder() {
        client = new Client();
    }

    public static ClientBuilder newInstance() {
        return new ClientBuilder();
    }

    public ClientBuilder withName(String name) {
        client.setName(name);
        return this;
    }

    public ClientBuilder withAddress(String address) {
        client.setAddress(address);
        return this;
    }

    public ClientBuilder withEmail(String email) {
        client.setEmail(email);
        return this;
    }

    public ClientBuilder withPhone(String phone) {
        client.setPhone(phone);
        return this;
    }

    public Client build() {
        return client;
    }

}
