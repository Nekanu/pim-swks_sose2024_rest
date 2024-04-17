package de.htwsaar.pimswks.rest.repositories;

import de.htwsaar.pimswks.rest.model.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;
import java.util.logging.Logger;

@Stateless
public class UserRepository {
    private static final Logger LOGGER = Logger.getLogger(UserRepository.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<User> findById(long userId) {
        LOGGER.info("Finding user by ID: " + userId);
        return Optional.ofNullable(entityManager.find(User.class, userId));
    }

    public User create(User user) {
        LOGGER.info("Creating user: " + user.username);
        entityManager.persist(user);
        return user;
    }

    public User read(long userId) {
        LOGGER.info("Reading user: " + userId);
        return entityManager.find(User.class, userId);
    }

    public User update(User user) {
        LOGGER.info("Updating user: " + user.username);
        return entityManager.merge(user);
    }

    public void delete(long userId) {
        LOGGER.info("Deleting user: " + userId);
        User user = entityManager.find(User.class, userId);
        entityManager.remove(user);
    }
}
