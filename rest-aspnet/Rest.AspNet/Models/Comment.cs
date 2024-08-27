using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace Rest.AspNet.Models;

public class Comment {
    
    [ReadOnly(true)]
    [JsonPropertyName("id")]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public ulong Id { get; init; }
    
    [Required]
    [MaxLength(int.MaxValue)]
    public required string Content { get; set; }
    
    [Required]
    [JsonPropertyName("authorId")]
    public required ulong AuthorId { get; init; }
    [JsonIgnore] public User? Author { get; init; }
    
    [JsonPropertyName("postId")]
    public ulong PostId { get; set; }
    [JsonIgnore] public Post? Post { get; set; }
}
