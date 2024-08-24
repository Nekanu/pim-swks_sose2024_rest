using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Rest.AspNet.Data;
using Rest.AspNet.Models;

namespace Rest.AspNet.Controllers;

[ApiController]
[Route("posts")]
public class PostController(BlogContext context) : ControllerBase {
    
    [AllowAnonymous]
    [HttpGet]
    public async Task<ActionResult<IEnumerable<Post>>> GetPosts() {
        return await context.Posts.ToListAsync();
    }
    
    [HttpPost]
    public async Task<ActionResult<Post>> CreatePost([FromBody] Post post) {
        context.Posts.Add(post);
        await context.SaveChangesAsync();
        return CreatedAtAction(nameof(CreatePost), new { id = post.Id }, post);
    }
    
    [AllowAnonymous]
    [HttpGet("{postId}")]
    public async Task<ActionResult<Post>> GetPostById(ulong postId) {
        Post? existingPost = await context.Posts.FindAsync(postId);
        if (existingPost == null) {
            return NotFound();
        }
        
        return existingPost;
    }
    
    [HttpPut("{postId}")]
    public async Task<ActionResult<Post>> UpdatePost(ulong postId, [FromBody] Post post) {

        Post? existingPost = await context.Posts.FindAsync(postId);
        if (existingPost == null) {
            return NotFound();
        }
        
        existingPost.Title = post.Title;
        existingPost.Content = post.Content;
        
        await context.SaveChangesAsync();
        return NoContent();
    }
    
    [HttpDelete("{postId}")]
    public async Task<ActionResult<Post>> DeletePost(ulong postId) {
        
        Post? existingPost = await context.Posts.FindAsync( postId );
        if (existingPost == null) {
            return NotFound();
        }
        
        return context.Posts.Remove(existingPost).Entity;
    }
}
