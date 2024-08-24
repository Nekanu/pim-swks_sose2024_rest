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
> Post createPost(Post)

Create a new post

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Post** | [**Post**](../Models/Post.md)|  | |

### Return type

[**Post**](../Models/Post.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="deletePostById"></a>
# **deletePostById**
> Post deletePostById(id)

Delete a post by ID

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the post to delete | [default to null] |

### Return type

[**Post**](../Models/Post.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getPostById"></a>
# **getPostById**
> Post getPostById(id)

Returns a post by ID

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the post to return | [default to null] |

### Return type

[**Post**](../Models/Post.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getPosts"></a>
# **getPosts**
> List getPosts()

Returns all posts

### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/Post.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getPostsForUser"></a>
# **getPostsForUser**
> List getPostsForUser(id)

Returns all posts authored by this user

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the user to return posts for | [default to null] |

### Return type

[**List**](../Models/Post.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="updatePostById"></a>
# **updatePostById**
> Post updatePostById(id, Post)

Update a post by ID

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the post to update | [default to null] |
| **Post** | [**Post**](../Models/Post.md)|  | |

### Return type

[**Post**](../Models/Post.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

