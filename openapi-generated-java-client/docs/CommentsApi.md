# CommentsApi

All URIs are relative to *http://localhost:18080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createCommentForPost**](CommentsApi.md#createCommentForPost) | **POST** /posts/{id}/comments | Create a new comment for a post |
| [**deleteCommentForPostById**](CommentsApi.md#deleteCommentForPostById) | **DELETE** /posts/{postId}/comments/{commentId} | Delete a comment by ID for a post |
| [**getCommentForPostById**](CommentsApi.md#getCommentForPostById) | **GET** /posts/{postId}/comments/{commentId} | Returns a comment by ID for a post |
| [**getCommentsForPost**](CommentsApi.md#getCommentsForPost) | **GET** /posts/{id}/comments | Returns all comments for a post |
| [**getCommentsForUser**](CommentsApi.md#getCommentsForUser) | **GET** /users/{id}/comments | Returns all comments authored by this user |
| [**updateCommentForPostById**](CommentsApi.md#updateCommentForPostById) | **PUT** /posts/{postId}/comments/{commentId} | Update a comment by ID for a post |


<a name="createCommentForPost"></a>
# **createCommentForPost**
> Comment createCommentForPost(id, comment)

Create a new comment for a post

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CommentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");
    
    // Configure API key authorization: apikeyAuth
    ApiKeyAuth apikeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apikeyAuth");
    apikeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apikeyAuth.setApiKeyPrefix("Token");

    CommentsApi apiInstance = new CommentsApi(defaultClient);
    Long id = 56L; // Long | ID of the post to create a comment for
    Comment comment = new Comment(); // Comment | 
    try {
      Comment result = apiInstance.createCommentForPost(id, comment);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CommentsApi#createCommentForPost");
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
| **id** | **Long**| ID of the post to create a comment for | |
| **comment** | [**Comment**](Comment.md)|  | |

### Return type

[**Comment**](Comment.md)

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
| **404** | If the post does not exist |  -  |

<a name="deleteCommentForPostById"></a>
# **deleteCommentForPostById**
> Comment deleteCommentForPostById(postId, commentId)

Delete a comment by ID for a post

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CommentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");
    
    // Configure API key authorization: apikeyAuth
    ApiKeyAuth apikeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apikeyAuth");
    apikeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apikeyAuth.setApiKeyPrefix("Token");

    CommentsApi apiInstance = new CommentsApi(defaultClient);
    Long postId = 56L; // Long | ID of the post to delete a comment for
    Long commentId = 56L; // Long | ID of the comment to delete
    try {
      Comment result = apiInstance.deleteCommentForPostById(postId, commentId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CommentsApi#deleteCommentForPostById");
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
| **postId** | **Long**| ID of the post to delete a comment for | |
| **commentId** | **Long**| ID of the comment to delete | |

### Return type

[**Comment**](Comment.md)

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
| **404** | If the post or comment does not exist |  -  |

<a name="getCommentForPostById"></a>
# **getCommentForPostById**
> Comment getCommentForPostById(postId, commentId)

Returns a comment by ID for a post

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CommentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");

    CommentsApi apiInstance = new CommentsApi(defaultClient);
    Long postId = 56L; // Long | ID of the post to return a comment for
    Long commentId = 56L; // Long | ID of the comment to return
    try {
      Comment result = apiInstance.getCommentForPostById(postId, commentId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CommentsApi#getCommentForPostById");
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
| **postId** | **Long**| ID of the post to return a comment for | |
| **commentId** | **Long**| ID of the comment to return | |

### Return type

[**Comment**](Comment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **404** | If the post or comment does not exist |  -  |

<a name="getCommentsForPost"></a>
# **getCommentsForPost**
> List&lt;Comment&gt; getCommentsForPost(id, limit)

Returns all comments for a post

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CommentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");

    CommentsApi apiInstance = new CommentsApi(defaultClient);
    Long id = 56L; // Long | ID of the post to return comments for
    Integer limit = 50; // Integer | Maximum number of comments to return
    try {
      List<Comment> result = apiInstance.getCommentsForPost(id, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CommentsApi#getCommentsForPost");
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
| **id** | **Long**| ID of the post to return comments for | |
| **limit** | **Integer**| Maximum number of comments to return | [optional] [default to 50] |

### Return type

[**List&lt;Comment&gt;**](Comment.md)

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

<a name="getCommentsForUser"></a>
# **getCommentsForUser**
> List&lt;Comment&gt; getCommentsForUser(id)

Returns all comments authored by this user

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CommentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");

    CommentsApi apiInstance = new CommentsApi(defaultClient);
    Long id = 56L; // Long | ID of the user to return comments for
    try {
      List<Comment> result = apiInstance.getCommentsForUser(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CommentsApi#getCommentsForUser");
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
| **id** | **Long**| ID of the user to return comments for | |

### Return type

[**List&lt;Comment&gt;**](Comment.md)

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

<a name="updateCommentForPostById"></a>
# **updateCommentForPostById**
> Comment updateCommentForPostById(postId, commentId, comment)

Update a comment by ID for a post

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CommentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:18080");
    
    // Configure API key authorization: apikeyAuth
    ApiKeyAuth apikeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apikeyAuth");
    apikeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apikeyAuth.setApiKeyPrefix("Token");

    CommentsApi apiInstance = new CommentsApi(defaultClient);
    Long postId = 56L; // Long | ID of the post to update a comment for
    Long commentId = 56L; // Long | ID of the comment to update
    Comment comment = new Comment(); // Comment | 
    try {
      Comment result = apiInstance.updateCommentForPostById(postId, commentId, comment);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CommentsApi#updateCommentForPostById");
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
| **postId** | **Long**| ID of the post to update a comment for | |
| **commentId** | **Long**| ID of the comment to update | |
| **comment** | [**Comment**](Comment.md)|  | |

### Return type

[**Comment**](Comment.md)

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
| **404** | If the post or comment does not exist |  -  |

