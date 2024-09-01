using Microsoft.EntityFrameworkCore;
using Rest.AspNet.Models;

namespace Rest.AspNet.Data;

public class BlogContext(DbContextOptions<BlogContext> options) : DbContext(options)
{
    public DbSet<User> Users { get; init; }
    public DbSet<Post> Posts { get; init; }
    public DbSet<Comment> Comments { get; init; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        // optionsBuilder.UseMySQL(BuildConnectionStringFromEnvironment(), 
        //    builder => builder.EnableRetryOnFailure());
        optionsBuilder.UseInMemoryDatabase("blog").LogTo(Console.WriteLine, LogLevel.Warning);
    }

    private static string BuildConnectionStringFromEnvironment()
    {
        string host = Environment.GetEnvironmentVariable("DATABASE_HOST") 
                      ?? throw new Exception("DATABASE_HOST environment variable not set");
        string port = Environment.GetEnvironmentVariable("DATABASE_PORT") 
                      ?? throw new Exception("DATABASE_PORT environment variable not set");
        string user = Environment.GetEnvironmentVariable("DATABASE_USER") 
                      ?? throw new Exception("DATABASE_USER environment variable not set");
        string name = Environment.GetEnvironmentVariable("DATABASE_NAME") 
                      ?? throw new Exception("DATABASE_NAME environment variable not set");
        string password = Environment.GetEnvironmentVariable("DATABASE_PASSWORD") 
                          ?? throw new Exception("DATABASE_PASSWORD environment variable not set");

        return $"Server={host};Port={port};Database={name};User Id={user};Password={password};";
    }
}
