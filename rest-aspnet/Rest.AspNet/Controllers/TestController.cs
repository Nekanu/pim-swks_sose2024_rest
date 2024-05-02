using Microsoft.AspNetCore.Mvc;

namespace Rest.AspNet.Controllers;

[ApiController]
[Route("test")]
public class TestController {
    
    [HttpGet]
    public string Get() {
        return "Hello, World!";
    }
}
