/*
 * Copyright (c) 2024. 
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.htwsaar.pimswks.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link de.htwsaar.pimswks.rest.model.entities.CommentEntity}
 */
public class CommentDto implements Serializable {

    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    private final Long id;

    @JsonProperty(value = "created", access = JsonProperty.Access.READ_ONLY)
    private final Date created;

    @JsonProperty(value = "updated", access = JsonProperty.Access.READ_ONLY)
    private final Date updated;

    @JsonProperty(value = "postId", access = JsonProperty.Access.READ_ONLY)
    private final long postId;

    @JsonProperty(value = "authorId")
    private final long authorId;

    @NotBlank
    @JsonProperty(value = "content")
    private final String content;

    public CommentDto(Date created, Date updated, Long id, long postId, long authorId, String content) {
        this.created = created;
        this.updated = updated;
        this.id = id;
        this.postId = postId;
        this.authorId = authorId;
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public Long getId() {
        return id;
    }

    public long getPostId() {
        return postId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getContent() {
        return content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(created, updated, id, postId, authorId, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto entity = (CommentDto) o;
        return Objects.equals(this.created, entity.created) &&
            Objects.equals(this.updated, entity.updated) &&
            Objects.equals(this.id, entity.id) &&
            Objects.equals(this.postId, entity.postId) &&
            Objects.equals(this.authorId, entity.authorId) &&
            Objects.equals(this.content, entity.content);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
            "created = " + created + ", " +
            "updated = " + updated + ", " +
            "id = " + id + ", " +
            "postPostId = " + postId + ", " +
            "authorAuthorId = " + authorId + ", " +
            "content = " + content + ")";
    }
}
