package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import spring.Client2;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Client2 client = ctx.getBean(Client2.class);
        client.send();

        ctx.close();
    }
}
