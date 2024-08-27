using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace Rest.AspNet.Models;

public class Post {
    
    [ReadOnly(true)]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    [JsonPropertyName("id")]
    public ulong Id { get; init; }
    
    [Required]
    [MaxLength(512)]
    public required string Title { get; set; }
    
    [Required]
    [MaxLength(int.MaxValue)]
    public required string Content { get; set; }
    
    public required ulong AuthorId { get; init; }
    [JsonIgnore] public User? Author { get; init; }
}
