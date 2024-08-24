using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Rest.AspNet.Data;
using Rest.AspNet.Models;

namespace Rest.AspNet.Controllers;

[ApiController]
[Route("comments")]
public class CommentController(BlogContext context) : ControllerBase {
    
    [AllowAnonymous]
    [HttpGet]
    public async Task<ActionResult<IEnumerable<Comment>>> GetComments() {
        return await context.Comments.ToListAsync();
    }
    
    [HttpPost]
    public async Task<ActionResult<Comment>> CreateComment([FromBody] Comment comment) {
        context.Comments.Add(comment);
        await context.SaveChangesAsync();
        return CreatedAtAction(nameof(CreateComment), new { id = comment.Id }, comment);
    }
    
    [AllowAnonymous]
    [HttpGet("{commentId}")]
    public async Task<ActionResult<Comment>> GetCommentById(ulong commentId) {
        Comment? existingComment = await context.Comments.FindAsync(commentId);
        if (existingComment == null) {
            return NotFound();
        }
        
        return existingComment;
    }
    
    [HttpPut("{commentId}")]
    public async Task<ActionResult<Comment>> UpdateComment(ulong commentId, [FromBody] Comment comment) {

        Comment? existingComment = await context.Comments.FindAsync(commentId);
        if (existingComment == null) {
            return NotFound();
        }
        
        existingComment.Content = comment.Content;
        
        await context.SaveChangesAsync();
        return NoContent();
    }
    
    [HttpDelete("{commentId}")]
    public async Task<ActionResult<Comment>> DeleteComment(ulong commentId) {
        
        Comment? existingComment = await context.Comments.FindAsync( commentId );
        if (existingComment == null) {
            return NotFound();
        }
        
        return context.Comments.Remove(existingComment).Entity;
    }
}
