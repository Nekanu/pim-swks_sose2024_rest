using AspNetCore.Authentication.ApiKey;
using Microsoft.AspNetCore.Authorization;
using Rest.AspNet.Data;

WebApplicationBuilder builder = WebApplication.CreateBuilder(args);

// Add services to the container.
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

string apiKey = Environment.GetEnvironmentVariable("API_KEY") ?? throw new ApplicationException("API_KEY is missing");

Func<ApiKeyValidateKeyContext, Task> apiKeyValidateKey = context =>
{
    if (context.ApiKey != apiKey)
    {
        context.Fail("Invalid API Key");
        return Task.CompletedTask;
    }

    context.ValidationSucceeded();
    return Task.CompletedTask;
};

builder.Services.AddAuthentication(ApiKeyDefaults.AuthenticationScheme).AddApiKeyInHeader(options =>
{
    options.KeyName = "X-API-KEY";
    options.SuppressWWWAuthenticateHeader = true;
    options.Events.OnValidateKey = apiKeyValidateKey;
});

builder.Services.AddAuthorizationBuilder()
    .SetFallbackPolicy(new AuthorizationPolicyBuilder().RequireAuthenticatedUser().Build());

builder.Services.AddDbContext<BlogContext>();

builder.Services.AddControllers();


WebApplication app = builder.Build();

using (IServiceScope scope = app.Services.CreateScope())
{
    IServiceProvider services = scope.ServiceProvider;
    BlogContext context = services.GetRequiredService<BlogContext>();
    context.Database.EnsureDeleted();
    context.Database.EnsureCreated();
}

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment()) {
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();
app.UseAuthentication();
app.UseAuthorization();
app.MapControllers();


app.Run();
