package config;

import controller.RegisterController;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    public RegisterController registerController() {
        return new RegisterController();
    }
}