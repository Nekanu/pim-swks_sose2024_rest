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

import de.htwsaar.pimswks.rest.model.entities.CommentEntity;
import de.htwsaar.pimswks.rest.model.entities.PostEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Stateless
public class PostRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<PostEntity> findById(long postId) {
        LOGGER.info("Finding post by ID: {}", postId);
        return Optional.ofNullable(entityManager.find(PostEntity.class, postId));
    }

    public PostEntity create(PostEntity post) {
        LOGGER.info("Creating post: {}", post.title);
        entityManager.persist(post);
        return post;
    }

    public List<PostEntity> readAll(int offset, int limit) {
        LOGGER.info("Reading all posts");
        return entityManager.createQuery("SELECT p FROM PostEntity p", PostEntity.class)
            .setFirstResult(offset)
            .setMaxResults(limit)
            .getResultList();
    }

    public PostEntity update(PostEntity post) {
        LOGGER.info("Updating post: {}", post.title);
        return entityManager.merge(post);
    }

    public Optional<PostEntity> delete(long postId) {
        LOGGER.info("Deleting post: {}", postId);
        PostEntity post = entityManager.find(PostEntity.class, postId);

        if (post == null) {
            LOGGER.warn("Post with ID {} could not be deleted: Not found", postId);
            return Optional.empty();
        }

        entityManager.remove(post);
        return Optional.of(post);
    }

    public List<PostEntity> filterByUserId(long userId) {
        LOGGER.info("Filtering posts by user ID: {}", userId);
        return entityManager.createQuery("SELECT c FROM PostEntity c WHERE c.author.id = :userId", PostEntity.class)
            .setParameter("userId", userId)
            .getResultList();
    }
}
