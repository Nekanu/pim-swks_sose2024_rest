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
> Comment createCommentForPost(id, Comment)

Create a new comment for a post

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the post to create a comment for | [default to null] |
| **Comment** | [**Comment**](../Models/Comment.md)|  | |

### Return type

[**Comment**](../Models/Comment.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="deleteCommentForPostById"></a>
# **deleteCommentForPostById**
> Comment deleteCommentForPostById(postId, commentId)

Delete a comment by ID for a post

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **postId** | **Long**| ID of the post to delete a comment for | [default to null] |
| **commentId** | **Long**| ID of the comment to delete | [default to null] |

### Return type

[**Comment**](../Models/Comment.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getCommentForPostById"></a>
# **getCommentForPostById**
> Comment getCommentForPostById(postId, commentId)

Returns a comment by ID for a post

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **postId** | **Long**| ID of the post to return a comment for | [default to null] |
| **commentId** | **Long**| ID of the comment to return | [default to null] |

### Return type

[**Comment**](../Models/Comment.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getCommentsForPost"></a>
# **getCommentsForPost**
> List getCommentsForPost(id, limit)

Returns all comments for a post

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the post to return comments for | [default to null] |
| **limit** | **Integer**| Maximum number of comments to return | [optional] [default to 50] |

### Return type

[**List**](../Models/Comment.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getCommentsForUser"></a>
# **getCommentsForUser**
> List getCommentsForUser(id)

Returns all comments authored by this user

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the user to return comments for | [default to null] |

### Return type

[**List**](../Models/Comment.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="updateCommentForPostById"></a>
# **updateCommentForPostById**
> Comment updateCommentForPostById(postId, commentId, Comment)

Update a comment by ID for a post

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **postId** | **Long**| ID of the post to update a comment for | [default to null] |
| **commentId** | **Long**| ID of the comment to update | [default to null] |
| **Comment** | [**Comment**](../Models/Comment.md)|  | |

### Return type

[**Comment**](../Models/Comment.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

