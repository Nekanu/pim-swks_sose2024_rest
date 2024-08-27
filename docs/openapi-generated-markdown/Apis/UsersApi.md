# UsersApi

All URIs are relative to *http://localhost:18080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createUser**](UsersApi.md#createUser) | **POST** /users | Create a new user |
| [**deleteUserById**](UsersApi.md#deleteUserById) | **DELETE** /users/{id} | Delete a user by ID |
| [**getCommentsForUser**](UsersApi.md#getCommentsForUser) | **GET** /users/{id}/comments | Returns all comments authored by this user |
| [**getPostsForUser**](UsersApi.md#getPostsForUser) | **GET** /users/{id}/posts | Returns all posts authored by this user |
| [**getUserById**](UsersApi.md#getUserById) | **GET** /users/{id} | Returns a user by ID |
| [**getUsers**](UsersApi.md#getUsers) | **GET** /users | Returns all users |
| [**updateUserById**](UsersApi.md#updateUserById) | **PUT** /users/{id} | Update a user by ID |


<a name="createUser"></a>
# **createUser**
> User createUser(User)

Create a new user

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **User** | [**User**](../Models/User.md)|  | |

### Return type

[**User**](../Models/User.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="deleteUserById"></a>
# **deleteUserById**
> User deleteUserById(id)

Delete a user by ID

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the user to delete | [default to null] |

### Return type

[**User**](../Models/User.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

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

<a name="getUserById"></a>
# **getUserById**
> User getUserById(id)

Returns a user by ID

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the user to return | [default to null] |

### Return type

[**User**](../Models/User.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getUsers"></a>
# **getUsers**
> List getUsers()

Returns all users

### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/User.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="updateUserById"></a>
# **updateUserById**
> User updateUserById(id, User)

Update a user by ID

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| ID of the user to update | [default to null] |
| **User** | [**User**](../Models/User.md)|  | |

### Return type

[**User**](../Models/User.md)

### Authorization

[apikeyAuth](../README.md#apikeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

