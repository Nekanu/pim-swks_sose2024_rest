package org.openapitools.api;

import org.openapitools.api.*;
import org.openapitools.model.*;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;

import org.openapitools.model.Comment;
import org.openapitools.model.Post;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2024-09-13T19:36:51.133516779+02:00[Europe/Berlin]")
public abstract class PostsApiService {
    public abstract Response createCommentForPost(Long id,Comment comment,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createPost(Post post,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCommentForPostById(Long postId,Long commentId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deletePostById(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCommentForPostById(Long postId,Long commentId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCommentsForPost(Long id, @Min(1) @Max(100)Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPostById(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPosts(SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCommentForPostById(Long postId,Long commentId,Comment comment,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updatePostById(Long id,Post post,SecurityContext securityContext) throws NotFoundException;
}
