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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link de.htwsaar.pimswks.rest.model.entities.UserEntity}
 */
public class UserDto implements Serializable {

    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    private long id;

    @JsonProperty(value = "created", access = JsonProperty.Access.READ_ONLY)
    private Date created;

    @JsonProperty(value = "updated", access = JsonProperty.Access.READ_ONLY)
    private Date updated;

    @Pattern(regexp = "^[a-zA-Z0-9]{3,64}$")
    @JsonProperty(value = "username")
    private String username;

    @Email
    @JsonProperty(value = "email")
    private String email;

    public UserDto() {
    }

    public UserDto(long id, Date created, Date updated, String username, String email) {
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.username = username;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(@Min(1) long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(@Pattern(regexp = "^[a-zA-Z0-9]{3,64}$") String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, updated, username, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
            Objects.equals(this.created, entity.created) &&
            Objects.equals(this.updated, entity.updated) &&
            Objects.equals(this.username, entity.username) &&
            Objects.equals(this.email, entity.email);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
            "id = " + id + ", " +
            "created = " + created + ", " +
            "updated = " + updated + ", " +
            "username = " + username + ", " +
            "email = " + email + ")";
    }
}
