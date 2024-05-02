using Microsoft.AspNetCore.Authentication;

namespace Rest.AspNet.Authentication;

public class ApiKeyAuthenticationSchemeOptions : AuthenticationSchemeOptions {
    internal string ApiKey { get; set; }
    
    public static string LoadApiKey() {
        string? apiKey = Environment.GetEnvironmentVariable("API_KEY");
        
        if (apiKey is null) {
            apiKey = Guid.NewGuid().ToString();
            Console.Error.WriteLine("No API key found in environment, using random key: {0}", apiKey);
        }
        
        return apiKey;
    }
}
