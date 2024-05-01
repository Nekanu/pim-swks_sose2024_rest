/*
 * Copyright (c) 2024. 
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.htwsaar.pimswks.rest.resources;

import de.htwsaar.pimswks.rest.model.PostDto;
import de.htwsaar.pimswks.rest.model.entities.PostEntity;
import de.htwsaar.pimswks.rest.repositories.PostRepository;
import de.htwsaar.pimswks.rest.repositories.UserRepository;
import de.htwsaar.pimswks.rest.security.Secured;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path(PostsResource.PATH)
public class PostsResource {

    public static final String PATH = "/posts";
    private static final String POST_NOT_FOUND_MESSAGE_TEMPLATE = "Post with ID \"%d\" not found";

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Inject
    public PostsResource(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PostDto> getPosts(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return postRepository.readAll(offset, limit).stream()
            .map(PostEntity::convertToDto)
            .toList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Secured
    public Response createPost(final PostDto post) {
        return userRepository.findById(post.getAuthor())
            .map(userEntity -> {
                PostEntity postEntity = new PostEntity();
                postEntity.setTitle(post.getTitle());
                postEntity.setContent(post.getContent());
                postEntity.setAuthor(userEntity);
                postRepository.create(postEntity);
                return Response.ok(postEntity.convertToDto()).build();
            })
            .orElseThrow(() -> new NotFoundException(String.format("User with ID \"%d\" not found", post.getAuthor())));
    }

    @GET
    @Path("{postId}")
    @Produces(MediaType.APPLICATION_JSON)
    public PostDto getPost(@PathParam("postId") long postId) {
        return postRepository.findById(postId)
            .map(PostEntity::convertToDto)
            .orElseThrow(() -> new NotFoundException(String.format(POST_NOT_FOUND_MESSAGE_TEMPLATE, postId)));
    }

    @PUT
    @Path("{postId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Secured
    public PostDto updatePost(@PathParam("postId") long postId, final PostDto post) {
        return postRepository.findById(postId)
            .map(postEntity -> {
                postEntity.setTitle(post.getTitle());
                postEntity.setContent(post.getContent());
                return postRepository.update(postEntity);
            })
            .map(PostEntity::convertToDto)
            .orElseThrow(() -> new NotFoundException(String.format(POST_NOT_FOUND_MESSAGE_TEMPLATE, postId)));
    }

    @DELETE
    @Path("{postId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured
    public PostDto deletePost(@PathParam("postId") long postId) {
        return postRepository.delete(postId)
            .map(postEntity -> {
                postRepository.delete(postId);
                return postEntity.convertToDto();
            })
            .orElseThrow(() -> new NotFoundException(String.format(POST_NOT_FOUND_MESSAGE_TEMPLATE, postId)));
    }
}
