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
    
    public required ulong AuthorId { get; init; }
    public User Author { get; init; }
}
