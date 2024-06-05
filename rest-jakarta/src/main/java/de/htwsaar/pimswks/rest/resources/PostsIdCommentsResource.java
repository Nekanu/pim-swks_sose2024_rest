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

import de.htwsaar.pimswks.rest.model.CommentDto;
import de.htwsaar.pimswks.rest.model.entities.CommentEntity;
import de.htwsaar.pimswks.rest.repositories.CommentRepository;
import de.htwsaar.pimswks.rest.repositories.PostRepository;
import de.htwsaar.pimswks.rest.repositories.UserRepository;
import de.htwsaar.pimswks.rest.security.Secured;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path(PostsIdCommentsResource.PATH)
public class PostsIdCommentsResource {

    public static final String PATH = "/posts/{postId}/comments";
    private static final String COMMENT_NOT_FOUND_MESSAGE_TEMPLATE = "Comment with ID %d not found";
    private static final String USER_NOT_FOUND_MESSAGE_TEMPLATE = "User with ID %d not found";

    @Inject
    private PostRepository postRepository;
    @Inject
    private UserRepository userRepository;
    @Inject
    private CommentRepository commentRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CommentDto> getComments(@PathParam("postId") long postId,
                                        @DefaultValue("100") @QueryParam("limit") int limit,
                                        @QueryParam("offset") int offset) {
        return commentRepository.readAll(postId, offset, limit).stream()
            .map(CommentEntity::convertToDto)
            .toList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Secured
    public Response createComment(@PathParam("postId") long postId,
                                  @Valid final CommentDto comment) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setPost(postRepository.findById(postId)
            .orElseThrow(() -> new NotFoundException(String.format("No post with ID %d found", postId))));
        commentEntity.setAuthor(userRepository.findById(comment.getAuthorId())
            .orElseThrow(() -> new NotFoundException(String.format(USER_NOT_FOUND_MESSAGE_TEMPLATE, comment.getAuthorId()))));
        commentEntity.setContent(comment.getContent());

        CommentEntity createdComment = commentRepository.create(commentEntity);
        return Response.status(201)
            .header("Location", PATH.replace("{postId}", String.valueOf(postId)) + "/" + createdComment.getCommentId())
            .entity(createdComment.convertToDto())
            .build();
    }

    @GET
    @Path("{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public CommentDto getComment(@PathParam("commentId") long commentId) {
        return commentRepository.findById(commentId)
            .map(CommentEntity::convertToDto)
            .orElseThrow(() -> new NotFoundException(String.format(COMMENT_NOT_FOUND_MESSAGE_TEMPLATE, commentId)));
    }

    @PUT
    @Path("{commentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Secured
    public CommentDto updateComment(@PathParam("commentId") long commentId,
                                    @Valid final CommentDto comment) {
        CommentEntity commentEntity = commentRepository.findById(commentId)
            .orElseThrow(() -> new NotFoundException(String.format(COMMENT_NOT_FOUND_MESSAGE_TEMPLATE, commentId)));
        commentEntity.setContent(comment.getContent());

        return commentRepository.update(commentEntity).convertToDto();
    }

    @DELETE
    @Path("{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured
    public CommentDto deleteComment(@PathParam("commentId") long commentId) {
        return commentRepository.delete(commentId)
            .map(CommentEntity::convertToDto)
            .orElseThrow(() -> new NotFoundException(String.format(COMMENT_NOT_FOUND_MESSAGE_TEMPLATE, commentId)));
    }

    @GET
    @Path("{userId}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CommentDto> getUserComments(@PathParam("userId") long userId) {
        userRepository.findById(userId)
            .orElseThrow(() -> new NotFoundException(String.format(USER_NOT_FOUND_MESSAGE_TEMPLATE, userId)));
        
        return commentRepository.filterByUserId(userId).stream().map(CommentEntity::convertToDto).toList();
    }
}
