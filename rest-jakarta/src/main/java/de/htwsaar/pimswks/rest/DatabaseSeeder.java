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

import de.htwsaar.pimswks.rest.model.entities.UserEntity;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Date;

@Singleton
@Startup
public class DatabaseSeeder {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSeeder.class);

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    @Transactional
    public void trySeedDatabase() {
        LOGGER.info("Seeding database");
        try {
            addDefaultUsers();
        } catch (Exception e) {
            LOGGER.error("Error seeding database", e);
            System.exit(1);
        }
    }

    public void addDefaultUsers() {

        final UserEntity deletedUser = new UserEntity(1, "DeletedUser", "", Date.from(Instant.MIN), Date.from(Instant.MIN));
        checkIfUserExistsAndUpdate(deletedUser);
    }

    public void checkIfUserExistsAndUpdate(UserEntity user) {
        if (entityManager.find(UserEntity.class, user.userId) == null) {
            LOGGER.warn("User does not exist, creating user: {}", user.username);
            entityManager.persist(user);
        } else {
            LOGGER.debug("User already exists, updating user: {}", user.username);
            entityManager.merge(user);
        }
    }
}
