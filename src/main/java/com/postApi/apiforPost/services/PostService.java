package com.postApi.apiforPost.services;


import com.postApi.apiforPost.payload.PostDTO;
import com.postApi.apiforPost.payload.PostResponse;

public interface PostService {


    PostDTO savesPost (PostDTO postDTO);

//    List <PostDTO> getAllPosts (int pageNo , int pageSize , String sortBy , String sortDir);

     PostResponse getAllPosts (int pageNo , int pageSize , String sortBy , String sortDir);

    PostDTO getOneData (int id);

    PostDTO updateOneData (int id,PostDTO postDTO);
//
    void deleteOne (int id);
//
    void deleteAll (PostDTO postDTO);


//    PostResponse getAllPosts (int pageNo , int pageSize , String sortBy , String sortDir);
}
