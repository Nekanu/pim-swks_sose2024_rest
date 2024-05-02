using System.Security.Claims;
using System.Text.Encodings.Web;
using Microsoft.AspNetCore.Authentication;
using Microsoft.Extensions.Options;
using Microsoft.Extensions.Primitives;

namespace Rest.AspNet.Authentication;

public class ApiKeyAuthenticationHandler(
    IOptionsMonitor<ApiKeyAuthenticationSchemeOptions> options,
    ILoggerFactory logger,
    UrlEncoder encoder)
    : AuthenticationHandler<ApiKeyAuthenticationSchemeOptions>(options, logger, encoder) {
    private const string ApiKeyHeader = "X-API-KEY";
    
    private readonly IOptionsMonitor<ApiKeyAuthenticationSchemeOptions> _options = options;
    
    protected override Task<AuthenticateResult> HandleAuthenticateAsync() {
        StringValues providedApiKey = Context.Request.Headers[ApiKeyHeader];
        
        if (providedApiKey != _options.CurrentValue.ApiKey)
            return Task.FromResult(AuthenticateResult.Fail("Api-Key invalid"));
        
        // This API-Key allows global access -> hence named "global"
        Claim[] claims = [new Claim(ClaimTypes.Name, "global")];
        ClaimsIdentity identity = new(claims, Scheme.Name);
        ClaimsPrincipal principal = new(identity);
        AuthenticationTicket ticket = new(principal, Scheme.Name);
        
        return Task.FromResult(AuthenticateResult.Success(ticket));
    }
}
