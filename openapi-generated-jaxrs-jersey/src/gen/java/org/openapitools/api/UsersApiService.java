package org.openapitools.api;

import org.openapitools.api.*;
import org.openapitools.model.*;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;

import org.openapitools.model.Comment;
import org.openapitools.model.Post;
import org.openapitools.model.User;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2024-09-13T19:36:51.133516779+02:00[Europe/Berlin]")
public abstract class UsersApiService {
    public abstract Response createUser(User user,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteUserById(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCommentsForUser(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPostsForUser(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUserById(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUsers(SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateUserById(Long id,User user,SecurityContext securityContext) throws NotFoundException;
}
