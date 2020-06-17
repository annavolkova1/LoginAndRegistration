package com.anna;

import com.anna.connection.ConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        System.out.println(connectionManager.getConnection());
        SpringApplication.run(App.class, args);
    }
}
