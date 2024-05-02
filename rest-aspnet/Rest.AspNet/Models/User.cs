using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace Rest.AspNet.Models;

public class User {
    
    [ReadOnly(true)]
    [JsonPropertyName("id")]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public ulong Id { get; set; }
    
    [Required]
    [JsonPropertyName("username")]
    [RegularExpression("^[a-zA-Z0-9_]{3,}$")]
    public string Username { get; set; }
    
    [Required]
    [JsonPropertyName("email")]
    [EmailAddress]
    public string Email { get; set; }
    
    [ReadOnly(true)]
    [Timestamp]
    public DateTime Created { get; set; }
    
    [ReadOnly(true)]
    [Timestamp]
    public DateTime Updated { get; set; }
}
