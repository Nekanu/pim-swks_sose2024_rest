package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.PostsApiService;
import org.openapitools.api.factories.PostsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import org.openapitools.model.Comment;
import org.openapitools.model.Post;

import java.util.Map;
import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/posts")


@io.swagger.annotations.Api(description = "the posts API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2024-09-13T19:36:51.133516779+02:00[Europe/Berlin]")
public class PostsApi  {
   private final PostsApiService delegate;

   public PostsApi(@Context ServletConfig servletContext) {
      PostsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("PostsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (PostsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         }
      }

      if (delegate == null) {
         delegate = PostsApiServiceFactory.getPostsApi();
      }

      this.delegate = delegate;
   }

    @javax.ws.rs.POST
    @Path("/{id}/comments")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create a new comment for a post", notes = "", response = Comment.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apikeyAuth")
    }, tags={ "comments", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created", response = Comment.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the post does not exist", response = Void.class)
    })
    public Response createCommentForPost(@ApiParam(value = "ID of the post to create a comment for", required = true) @PathParam("id") @NotNull  Long id,@ApiParam(value = "", required = true) @NotNull @Valid  Comment comment,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createCommentForPost(id, comment, securityContext);
    }
    @javax.ws.rs.POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create a new post", notes = "", response = Post.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apikeyAuth")
    }, tags={ "posts", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created", response = Post.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class)
    })
    public Response createPost(@ApiParam(value = "", required = true) @NotNull @Valid  Post post,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createPost(post, securityContext);
    }
    @javax.ws.rs.DELETE
    @Path("/{postId}/comments/{commentId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a comment by ID for a post", notes = "", response = Comment.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apikeyAuth")
    }, tags={ "comments", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Comment.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the post or comment does not exist", response = Void.class)
    })
    public Response deleteCommentForPostById(@ApiParam(value = "ID of the post to delete a comment for", required = true) @PathParam("postId") @NotNull  Long postId,@ApiParam(value = "ID of the comment to delete", required = true) @PathParam("commentId") @NotNull  Long commentId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteCommentForPostById(postId, commentId, securityContext);
    }
    @javax.ws.rs.DELETE
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a post by ID", notes = "", response = Post.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apikeyAuth")
    }, tags={ "posts", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Post.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the post does not exist", response = Void.class)
    })
    public Response deletePostById(@ApiParam(value = "ID of the post to delete", required = true) @PathParam("id") @NotNull  Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deletePostById(id, securityContext);
    }
    @javax.ws.rs.GET
    @Path("/{postId}/comments/{commentId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a comment by ID for a post", notes = "", response = Comment.class, tags={ "comments", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Comment.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the post or comment does not exist", response = Void.class)
    })
    public Response getCommentForPostById(@ApiParam(value = "ID of the post to return a comment for", required = true) @PathParam("postId") @NotNull  Long postId,@ApiParam(value = "ID of the comment to return", required = true) @PathParam("commentId") @NotNull  Long commentId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getCommentForPostById(postId, commentId, securityContext);
    }
    @javax.ws.rs.GET
    @Path("/{id}/comments")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns all comments for a post", notes = "", response = Comment.class, responseContainer = "List", tags={ "comments", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Comment.class, responseContainer = "List"),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the post does not exist", response = Void.class)
    })
    public Response getCommentsForPost(@ApiParam(value = "ID of the post to return comments for", required = true) @PathParam("id") @NotNull  Long id,@ApiParam(value = "Maximum number of comments to return", defaultValue = "50") @DefaultValue("50") @QueryParam("limit")  @Min(1) @Max(100) Integer limit,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getCommentsForPost(id, limit, securityContext);
    }
    @javax.ws.rs.GET
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a post by ID", notes = "", response = Post.class, tags={ "posts", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Post.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the post does not exist", response = Void.class)
    })
    public Response getPostById(@ApiParam(value = "ID of the post to return", required = true) @PathParam("id") @NotNull  Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPostById(id, securityContext);
    }
    @javax.ws.rs.GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns all posts", notes = "", response = Post.class, responseContainer = "List", tags={ "posts", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Post.class, responseContainer = "List")
    })
    public Response getPosts(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPosts(securityContext);
    }
    @javax.ws.rs.PUT
    @Path("/{postId}/comments/{commentId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a comment by ID for a post", notes = "", response = Comment.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apikeyAuth")
    }, tags={ "comments", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Comment.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the post or comment does not exist", response = Void.class)
    })
    public Response updateCommentForPostById(@ApiParam(value = "ID of the post to update a comment for", required = true) @PathParam("postId") @NotNull  Long postId,@ApiParam(value = "ID of the comment to update", required = true) @PathParam("commentId") @NotNull  Long commentId,@ApiParam(value = "", required = true) @NotNull @Valid  Comment comment,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateCommentForPostById(postId, commentId, comment, securityContext);
    }
    @javax.ws.rs.PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a post by ID", notes = "", response = Post.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apikeyAuth")
    }, tags={ "posts", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Post.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the post does not exist", response = Void.class)
    })
    public Response updatePostById(@ApiParam(value = "ID of the post to update", required = true) @PathParam("id") @NotNull  Long id,@ApiParam(value = "", required = true) @NotNull @Valid  Post post,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updatePostById(id, post, securityContext);
    }
}
