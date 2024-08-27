# Documentation for PIM-SWKS SoSe2024 REST API

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://localhost:18080*

| Class | Method | HTTP request | Description |
|------------ | ------------- | ------------- | -------------|
| *CommentsApi* | [**createCommentForPost**](Apis/CommentsApi.md#createcommentforpost) | **POST** /posts/{id}/comments | Create a new comment for a post |
*CommentsApi* | [**deleteCommentForPostById**](Apis/CommentsApi.md#deletecommentforpostbyid) | **DELETE** /posts/{postId}/comments/{commentId} | Delete a comment by ID for a post |
*CommentsApi* | [**getCommentForPostById**](Apis/CommentsApi.md#getcommentforpostbyid) | **GET** /posts/{postId}/comments/{commentId} | Returns a comment by ID for a post |
*CommentsApi* | [**getCommentsForPost**](Apis/CommentsApi.md#getcommentsforpost) | **GET** /posts/{id}/comments | Returns all comments for a post |
*CommentsApi* | [**getCommentsForUser**](Apis/CommentsApi.md#getcommentsforuser) | **GET** /users/{id}/comments | Returns all comments authored by this user |
*CommentsApi* | [**updateCommentForPostById**](Apis/CommentsApi.md#updatecommentforpostbyid) | **PUT** /posts/{postId}/comments/{commentId} | Update a comment by ID for a post |
| *PostsApi* | [**createPost**](Apis/PostsApi.md#createpost) | **POST** /posts | Create a new post |
*PostsApi* | [**deletePostById**](Apis/PostsApi.md#deletepostbyid) | **DELETE** /posts/{id} | Delete a post by ID |
*PostsApi* | [**getPostById**](Apis/PostsApi.md#getpostbyid) | **GET** /posts/{id} | Returns a post by ID |
*PostsApi* | [**getPosts**](Apis/PostsApi.md#getposts) | **GET** /posts | Returns all posts |
*PostsApi* | [**getPostsForUser**](Apis/PostsApi.md#getpostsforuser) | **GET** /users/{id}/posts | Returns all posts authored by this user |
*PostsApi* | [**updatePostById**](Apis/PostsApi.md#updatepostbyid) | **PUT** /posts/{id} | Update a post by ID |
| *UsersApi* | [**createUser**](Apis/UsersApi.md#createuser) | **POST** /users | Create a new user |
*UsersApi* | [**deleteUserById**](Apis/UsersApi.md#deleteuserbyid) | **DELETE** /users/{id} | Delete a user by ID |
*UsersApi* | [**getCommentsForUser**](Apis/UsersApi.md#getcommentsforuser) | **GET** /users/{id}/comments | Returns all comments authored by this user |
*UsersApi* | [**getPostsForUser**](Apis/UsersApi.md#getpostsforuser) | **GET** /users/{id}/posts | Returns all posts authored by this user |
*UsersApi* | [**getUserById**](Apis/UsersApi.md#getuserbyid) | **GET** /users/{id} | Returns a user by ID |
*UsersApi* | [**getUsers**](Apis/UsersApi.md#getusers) | **GET** /users | Returns all users |
*UsersApi* | [**updateUserById**](Apis/UsersApi.md#updateuserbyid) | **PUT** /users/{id} | Update a user by ID |


<a name="documentation-for-models"></a>
## Documentation for Models

 - [Comment](./Models/Comment.md)
 - [Post](./Models/Post.md)
 - [User](./Models/User.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apikeyAuth"></a>
### apikeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

