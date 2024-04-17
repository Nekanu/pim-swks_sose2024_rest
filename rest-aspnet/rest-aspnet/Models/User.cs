using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Rest_AspNet.Models;

public class User {
    
    [ReadOnly(true)]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public ulong Id { get; set; }
    
    [Required]
    [RegularExpression("^[a-zA-Z0-9_]{3,}$")]
    public string Username { get; set; }
    
    [Required]
    [EmailAddress]
    public string Email { get; set; }
}
