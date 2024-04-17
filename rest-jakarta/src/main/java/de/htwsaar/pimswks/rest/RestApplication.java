package de.htwsaar.pimswks.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("/")
public class RestApplication extends Application {

    public RestApplication() {


    }

    @ApplicationScoped
    public EntityManagerFactory entityManagerFactory() {
        Map<String, String> env = System.getenv();
        Map<String, Object> configOverrides = new HashMap<>();

        String dbHost = "localhost";
        String dbPort = "3306";
        String dbName = "blog";


        for (String envName : env.keySet()) {
            switch (envName) {
                case "DATABASE_HOST":
                    dbHost = env.get(envName);
                    break;
                case "DATABASE_PORT":
                    dbPort = env.get(envName);
                    break;
                case "DATABASE_NAME":
                    dbName = env.get(envName);
                    break;
                case "DATABASE_USER":
                    configOverrides.put("javax.persistence.jdbc.user", env.get(envName));
                    break;
                case "DATABASE_PASSWORD":
                    configOverrides.put("javax.persistence.jdbc.password", env.get(envName));
                    break;
            }
        }

        configOverrides.put("javax.persistence.jdbc.url", "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName);

        return jakarta.persistence.Persistence.createEntityManagerFactory("default", configOverrides);
    }
}
