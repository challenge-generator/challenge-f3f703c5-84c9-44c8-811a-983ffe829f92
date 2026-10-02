package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

@SpringBootApplication
@EnableWebMvc
@EnableTransactionManagement
@EnableAsync
public class Application {

    private final Environment environment;

    public Application(Environment environment) {
        this.environment = environment;
        validateActiveProfiles();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        logApplicationStartup();
    }

    private void validateActiveProfiles() {
        String[] activeProfiles = environment.getActiveProfiles();
        if (activeProfiles.length == 0) {
            throw new IllegalStateException("No active Spring profile set. Please configure at least one profile (e.g., 'dev', 'prod').");
        }
    }

    private void logApplicationStartup() {
        String protocol = environment.getProperty("server.ssl.key-store") != null ? "https" : "http";
        String serverPort = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path", "/");
        String hostAddress = "localhost";

        System.out.println("\n----------------------------------------------------------");
        System.out.println("Application '" + environment.getProperty("spring.application.name") + "' is running!");
        System.out.println("Access URLs:");
        System.out.println("Local:      " + protocol + "://" + hostAddress + ":" + serverPort + contextPath);
        System.out.println("Profiles:   " + Arrays.toString(environment.getActiveProfiles()));
        System.out.println("----------------------------------------------------------\n");
    }
}