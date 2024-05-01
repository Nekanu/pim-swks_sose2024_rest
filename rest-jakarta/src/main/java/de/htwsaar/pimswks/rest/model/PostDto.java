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
import de.htwsaar.pimswks.rest.model.entities.PostEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link PostEntity}
 */
public class PostDto implements Serializable {

    @JsonProperty("author")
    @Min(value = 1, message = "Author ID must be greater than 0")
    private final long author;

    @JsonProperty("created")
    private final Date created;
    @JsonProperty("updated")
    private final Date updated;

    @JsonProperty("title")
    @NotBlank
    @Length(message = "Title must be between 3 and 512 characters long", min = 3, max = 512)
    private final String title;

    @JsonProperty("content")
    @NotBlank
    private final String content;

    public PostDto(long author, Date created, Date updated, String title, String content) {
        this.author = author;
        this.created = created;
        this.updated = updated;
        this.title = title;
        this.content = content;
    }

    public long getAuthor() {
        return author;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, created, updated, title, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDto entity = (PostDto) o;
        return Objects.equals(this.author, entity.author) &&
            Objects.equals(this.created, entity.created) &&
            Objects.equals(this.updated, entity.updated) &&
            Objects.equals(this.title, entity.title) &&
            Objects.equals(this.content, entity.content);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
            "authorUserId = " + author + ", " +
            "created = " + created + ", " +
            "updated = " + updated + ", " +
            "title = " + title + ", " +
            "content = " + content + ")";
    }
}
