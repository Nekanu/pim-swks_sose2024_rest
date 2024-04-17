using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Rest_AspNet.Data;
using Rest_AspNet.Models;

namespace Rest_AspNet.Controllers;

[ApiController]
[Route("users")]
public class UserController(BlogContext context) : ControllerBase {
    
    [HttpGet]
    public async Task<ActionResult<IEnumerable<User>>> GetUsers() {
        return await context.Users.ToListAsync();
    }
    
    [HttpGet("{userId}")]
    public async Task<ActionResult<User>> GetUser(string userId) {
        User? user = await context.Users.FindAsync(userId);
        if (user == null) {
            return NotFound();
        }
        return user;
    }
    
    [HttpPost]
    public async Task<ActionResult<User>> CreateUser([FromBody] User user) {
        context.Users.Add(user);
        await context.SaveChangesAsync();
        return CreatedAtAction(nameof(GetUser), new { id = user.Id }, user);
    }
    
    [Authorize]
    [HttpPut("{userId}")]
    public async Task<ActionResult<User>> UpdateUser(string userId, [FromBody] User user) {

        User? existingUser = await context.Users.FindAsync(userId);
        if (existingUser == null) {
            return NotFound();
        }
        
        existingUser.Username = user.Username;
        existingUser.Email = user.Email;
        
        await context.SaveChangesAsync();
        return NoContent();
    }
}
