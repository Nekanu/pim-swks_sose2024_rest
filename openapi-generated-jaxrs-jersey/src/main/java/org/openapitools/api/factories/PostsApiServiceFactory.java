package org.openapitools.api.factories;

import org.openapitools.api.PostsApiService;
import org.openapitools.api.impl.PostsApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2024-09-13T19:36:51.133516779+02:00[Europe/Berlin]")
public class PostsApiServiceFactory {
    private static final PostsApiService service = new PostsApiServiceImpl();

    public static PostsApiService getPostsApi() {
        return service;
    }
}
