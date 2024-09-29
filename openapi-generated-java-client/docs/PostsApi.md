# PostsApi

All URIs are relative to *http://localhost:18080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createPost**](PostsApi.md#createPost) | **POST** /posts | Create a new post |
| [**deletePostById**](PostsApi.md#deletePostById) | **DELETE** /posts/{id} | Delete a post by ID |
| [**getPostById**](PostsApi.md#getPostById) | **GET** /posts/{id} | Returns a post by ID |
| [**getPosts**](PostsApi.md#getPosts) | **GET** /posts | Returns all posts |
| [**getPostsForUser**](PostsApi.md#getPostsForUser) | **GET** /users/{id}/posts | Returns all posts authored by this user |
| [**updatePostById**](PostsApi.md#updatePostById) | **PUT** /posts/{id} | Update a post by ID |


<a name="createPost"></a>
# **createPost**
> Post createPost(post)

Create a new post

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PostsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");
    
    // Configure API key authorization: apikeyAuth
    ApiKeyAuth apikeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apikeyAuth");
    apikeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apikeyAuth.setApiKeyPrefix("Token");

    PostsApi apiInstance = new PostsApi(defaultClient);
    Post post = new Post(); // Post | 
    try {
      Post result = apiInstance.createPost(post);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PostsApi#createPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **post** | [**Post**](Post.md)|  | |

### Return type

[**Post**](Post.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **401** | Unauthorized |  * WWW-Authenticate - The authentication method that should be used <br>  |
| **403** | Forbidden |  -  |

<a name="deletePostById"></a>
# **deletePostById**
> Post deletePostById(id)

Delete a post by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PostsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");
    
    // Configure API key authorization: apikeyAuth
    ApiKeyAuth apikeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apikeyAuth");
    apikeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apikeyAuth.setApiKeyPrefix("Token");

    PostsApi apiInstance = new PostsApi(defaultClient);
    Long id = 56L; // Long | ID of the post to delete
    try {
      Post result = apiInstance.deletePostById(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PostsApi#deletePostById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the post to delete | |

### Return type

[**Post**](Post.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  * WWW-Authenticate - The authentication method that should be used <br>  |
| **403** | Forbidden |  -  |
| **404** | If the post does not exist |  -  |

<a name="getPostById"></a>
# **getPostById**
> Post getPostById(id)

Returns a post by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PostsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");

    PostsApi apiInstance = new PostsApi(defaultClient);
    Long id = 56L; // Long | ID of the post to return
    try {
      Post result = apiInstance.getPostById(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PostsApi#getPostById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the post to return | |

### Return type

[**Post**](Post.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **404** | If the post does not exist |  -  |

<a name="getPosts"></a>
# **getPosts**
> List&lt;Post&gt; getPosts()

Returns all posts

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PostsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");

    PostsApi apiInstance = new PostsApi(defaultClient);
    try {
      List<Post> result = apiInstance.getPosts();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PostsApi#getPosts");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Post&gt;**](Post.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getPostsForUser"></a>
# **getPostsForUser**
> List&lt;Post&gt; getPostsForUser(id)

Returns all posts authored by this user

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PostsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");

    PostsApi apiInstance = new PostsApi(defaultClient);
    Long id = 56L; // Long | ID of the user to return posts for
    try {
      List<Post> result = apiInstance.getPostsForUser(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PostsApi#getPostsForUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the user to return posts for | |

### Return type

[**List&lt;Post&gt;**](Post.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **404** | If the user does not exist |  -  |

<a name="updatePostById"></a>
# **updatePostById**
> Post updatePostById(id, post)

Update a post by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PostsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");
    
    // Configure API key authorization: apikeyAuth
    ApiKeyAuth apikeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apikeyAuth");
    apikeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apikeyAuth.setApiKeyPrefix("Token");

    PostsApi apiInstance = new PostsApi(defaultClient);
    Long id = 56L; // Long | ID of the post to update
    Post post = new Post(); // Post | 
    try {
      Post result = apiInstance.updatePostById(id, post);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PostsApi#updatePostById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the post to update | |
| **post** | [**Post**](Post.md)|  | |

### Return type

[**Post**](Post.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  * WWW-Authenticate - The authentication method that should be used <br>  |
| **403** | Forbidden |  -  |
| **404** | If the post does not exist |  -  |

