/*
 * Copyright (c) 2024. 
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.htwsaar.pimswks.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("/")
public class RestApplication extends Application {

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
