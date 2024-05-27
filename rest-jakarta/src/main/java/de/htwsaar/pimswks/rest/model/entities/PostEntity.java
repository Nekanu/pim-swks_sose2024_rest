/*
 * Copyright (c) 2024. 
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.htwsaar.pimswks.rest.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.htwsaar.pimswks.rest.model.PostDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long postId;

    @Length(min = 3, max = 512, message = "Title must be between 3 and 512 characters long")
    @Column(name = "title", nullable = false, columnDefinition = "VARCHAR(512)")
    @NotBlank
    public String title;

    @Column(name = "content", columnDefinition = "LONGTEXT", nullable = false)
    @NotBlank
    public String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    public UserEntity author;

    @Column(name = "created")
    @JsonProperty("created")
    @CreationTimestamp
    public Date created;

    @Column(name = "updated")
    @JsonProperty("updated")
    @UpdateTimestamp
    public Date updated;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("created DESC")
    private List<CommentEntity> comments = new ArrayList<>();

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public @Length(min = 3, max = 512, message = "Title must be between 3 and 512 characters long") @NotBlank String getTitle() {
        return title;
    }

    public void setTitle(@Length(min = 3, max = 512, message = "Title must be between 3 and 512 characters long") @NotBlank String title) {
        this.title = title;
    }

    public @NotBlank String getContent() {
        return content;
    }

    public void setContent(@NotBlank String content) {
        this.content = content;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public PostDto convertToDto() {
        return new PostDto(postId, author.getUserId(), created, updated, title, content);
    }

    @Override
    public String toString() {
        return "PostEntity{" +
            "updated=" + updated +
            ", created=" + created +
            ", author=" + author.toString() +
            ", content='" + content + '\'' +
            ", title='" + title + '\'' +
            ", postId=" + postId +
            '}';
    }
}
