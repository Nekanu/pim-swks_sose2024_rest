/*
 * Copyright (c) 2024. 
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.htwsaar.pimswks.rest.repositories;

import de.htwsaar.pimswks.rest.model.entities.UserEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Stateless
public class UserRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<UserEntity> findById(long userId) {
        LOGGER.info("Finding user by ID: {}", userId);
        return Optional.ofNullable(entityManager.find(UserEntity.class, userId));
    }

    public UserEntity create(UserEntity user) {
        LOGGER.info("Creating user: {}", user.username);
        entityManager.persist(user);
        return user;
    }

    public UserEntity read(long userId) {
        LOGGER.info("Reading user: {}", userId);
        return entityManager.find(UserEntity.class, userId);
    }

    public List<UserEntity> readAll(int offset, int limit) {
        LOGGER.info("Reading all users");
        return entityManager.createQuery("SELECT u FROM UserEntity u", UserEntity.class).getResultList();
    }

    public UserEntity update(UserEntity user) {
        LOGGER.info("Updating user: {}", user.username);
        return entityManager.merge(user);
    }

    public void delete(long userId) {
        LOGGER.info("Deleting user: {}", userId);
        UserEntity user = entityManager.find(UserEntity.class, userId);
        entityManager.remove(user);
    }
}
