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
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Stateless
public class CommentRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<CommentEntity> findById(long commentId) {
        LOGGER.info("Finding comment by ID: {}", commentId);
        return Optional.ofNullable(entityManager.find(CommentEntity.class, commentId));
    }

    public List<CommentEntity> readAll(long postId, int offset, int limit) {
        LOGGER.info("Reading all comments for post: {}", postId);
        return entityManager.createQuery("SELECT c FROM CommentEntity c WHERE c.post.id = :postId", CommentEntity.class)
            .setParameter("postId", postId)
            .setFirstResult(offset)
            .setMaxResults(limit)
            .getResultList();
    }

    public CommentEntity create(final CommentEntity comment) {
        LOGGER.info("Creating new comment");
        entityManager.persist(comment);
        return comment;
    }

    public CommentEntity update(final CommentEntity comment) {
        LOGGER.info("Updating comment: {}", comment.getCommentId());
        return entityManager.merge(comment);
    }

    public Optional<CommentEntity> delete(long commentId) {
        LOGGER.info("Deleting comment: {}", commentId);
        CommentEntity comment = entityManager.find(CommentEntity.class, commentId);

        if (comment == null) {
            LOGGER.warn("Comment with ID {} could not be deleted: Not found", commentId);
            return Optional.empty();
        }
        entityManager.remove(comment);
        return Optional.of(comment);
    }
    
    public List<CommentEntity> filterByUserId(long userId) {
        LOGGER.info("Filtering comments by user ID: {}", userId);
        return entityManager.createQuery("SELECT c FROM CommentEntity c WHERE c.author.id = :userId", CommentEntity.class)
            .setParameter("userId", userId)
            .getResultList();
    }
}
