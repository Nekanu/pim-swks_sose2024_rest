using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace Rest.AspNet.Models;

public class Post {
    
    [ReadOnly(true)]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    [JsonPropertyName("id")]
    public ulong Id { get; set; }
    
    [Required]
    [MaxLength(512)]
    public string Title { get; set; }
    
    [Required]
    [MaxLength(int.MaxValue)]
    public string Content { get; set; }
    
    public ulong AuthorId { get; set; }
    
    public virtual User Author { get; set; }
    
}
