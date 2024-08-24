using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace Rest.AspNet.Models;

public class User {
    
    [ReadOnly(true)]
    [JsonPropertyName("id")]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public ulong Id { get; init; }
    
    [Required]
    [MaxLength(255)]
    [JsonPropertyName("username")]
    [RegularExpression("^[a-zA-Z0-9_]{3,255}$")]
    public required string Username { get; set; }
    
    [Required]
    [MaxLength(255)]
    [JsonPropertyName("email")]
    [EmailAddress]
    public required string Email { get; set; }
    
    [ReadOnly(true)]
    [Timestamp]
    public DateTime Created { get; init; }
    
    [ReadOnly(true)]
    [Timestamp]
    public DateTime Updated { get; init; }
}
