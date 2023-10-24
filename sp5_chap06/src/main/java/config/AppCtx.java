package config;

import org.springframework.context.annotation.Configuration;
import spring.Client;

@Configuration
public class AppCtx {

    public Client client() {
        Client client = new Client();
        client.setHost("host");
        return client;
    }
}
