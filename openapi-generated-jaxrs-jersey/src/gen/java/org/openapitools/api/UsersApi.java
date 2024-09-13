package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.UsersApiService;
import org.openapitools.api.factories.UsersApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import org.openapitools.model.Comment;
import org.openapitools.model.Post;
import org.openapitools.model.User;

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

@Path("/users")


@io.swagger.annotations.Api(description = "the users API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2024-09-13T19:36:51.133516779+02:00[Europe/Berlin]")
public class UsersApi  {
   private final UsersApiService delegate;

   public UsersApi(@Context ServletConfig servletContext) {
      UsersApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("UsersApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (UsersApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         }
      }

      if (delegate == null) {
         delegate = UsersApiServiceFactory.getUsersApi();
      }

      this.delegate = delegate;
   }

    @javax.ws.rs.POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create a new user", notes = "", response = User.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apikeyAuth")
    }, tags={ "users", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created", response = User.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class)
    })
    public Response createUser(@ApiParam(value = "", required = true) @NotNull @Valid  User user,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createUser(user, securityContext);
    }
    @javax.ws.rs.DELETE
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a user by ID", notes = "", response = User.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apikeyAuth")
    }, tags={ "users", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = User.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the user does not exist", response = Void.class)
    })
    public Response deleteUserById(@ApiParam(value = "ID of the user to delete", required = true) @PathParam("id") @NotNull  Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteUserById(id, securityContext);
    }
    @javax.ws.rs.GET
    @Path("/{id}/comments")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns all comments authored by this user", notes = "", response = Comment.class, responseContainer = "List", tags={ "comments","users", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Comment.class, responseContainer = "List"),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the user does not exist", response = Void.class)
    })
    public Response getCommentsForUser(@ApiParam(value = "ID of the user to return comments for", required = true) @PathParam("id") @NotNull  Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getCommentsForUser(id, securityContext);
    }
    @javax.ws.rs.GET
    @Path("/{id}/posts")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns all posts authored by this user", notes = "", response = Post.class, responseContainer = "List", tags={ "posts","users", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Post.class, responseContainer = "List"),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the user does not exist", response = Void.class)
    })
    public Response getPostsForUser(@ApiParam(value = "ID of the user to return posts for", required = true) @PathParam("id") @NotNull  Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPostsForUser(id, securityContext);
    }
    @javax.ws.rs.GET
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a user by ID", notes = "", response = User.class, tags={ "users", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = User.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the user does not exist", response = Void.class)
    })
    public Response getUserById(@ApiParam(value = "ID of the user to return", required = true) @PathParam("id") @NotNull  Long id,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getUserById(id, securityContext);
    }
    @javax.ws.rs.GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns all users", notes = "", response = User.class, responseContainer = "List", tags={ "users", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = User.class, responseContainer = "List")
    })
    public Response getUsers(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getUsers(securityContext);
    }
    @javax.ws.rs.PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a user by ID", notes = "", response = User.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "apikeyAuth")
    }, tags={ "users", })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = User.class),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 404, message = "If the user does not exist", response = Void.class)
    })
    public Response updateUserById(@ApiParam(value = "ID of the user to update", required = true) @PathParam("id") @NotNull  Long id,@ApiParam(value = "", required = true) @NotNull @Valid  User user,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateUserById(id, user, securityContext);
    }
}
