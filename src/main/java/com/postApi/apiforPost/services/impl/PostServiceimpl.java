package com.postApi.apiforPost.services.impl;

import com.postApi.apiforPost.entities.Post;
import com.postApi.apiforPost.exception.ResourceNotFoundException;
import com.postApi.apiforPost.payload.PostDTO;
import com.postApi.apiforPost.payload.PostResponse;
import com.postApi.apiforPost.repository.PostRepository;
import com.postApi.apiforPost.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceimpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PostDTO savesPost (PostDTO postDTO) {

        Post posted = mapToEntity (postDTO);

        postRepository.save (posted);

        PostDTO dto = backToDto (posted);

        return dto;
    }

    // fetching the data to return the object in the postDTO class
//    @Override
//    public List <PostDTO> getAllPosts (int pageNo , int pageSize , String sortBy , String sortDir) {
//
//        Sort sort = sortDir.equalsIgnoreCase (Sort.Direction.ASC.name ()) ? Sort.by (sortBy).ascending ()
//                : Sort.by (sortBy).descending ();
//
//        Pageable pageable = PageRequest.of (pageNo , pageSize , Sort.by (sortBy));
//
//        Page <Post> posts = postRepository.findAll (pageable);
//
//        List <Post> found = posts.getContent ();
//
//        List <PostDTO> collect = found.stream ().map (post -> backToDto (post)).collect (Collectors.toList ());
//
//   return collect;
//
//    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

// create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> posts = postRepository.findAll(pageable);

// get content for page object
        List<Post> content = posts.getContent();

        List <PostDTO> allContents = content.stream ().map (post -> backToDto (post)).collect (Collectors.toList ());

        PostResponse postResponse = new PostResponse();

        postResponse.setContent (allContents);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;
    }

    @Override
    public PostDTO getOneData (int id) {

        Post post = postRepository.findById (id).orElseThrow (() -> new ResourceNotFoundException ("Post" , "id" , id));

            return backToDto (post);

    }
    @Override
    public PostDTO updateOneData ( int id, PostDTO postDTO){

        Post post = postRepository.findById (id).orElseThrow (() -> new ResourceNotFoundException ("data" , "id" , id));

        post.setName (postDTO.getName ());
        post.setContent (postDTO.getContent ());
        post.setPlatform (postDTO.getPlatform ());

        Post save = postRepository.save (post);

        PostDTO dto = backToDto (save);

        return dto;

    }

    @Override
    public void deleteOne (int id) {
        Post post = postRepository.findById (id).orElseThrow (() -> new ResourceNotFoundException ("check" , "id" , id));

        postRepository.delete (post);

    }

    @Override
    public void deleteAll (PostDTO postDTO) {

        postRepository.deleteAll ();
    }


    public Post mapToEntity(PostDTO postDTO){

        Post post = modelMapper.map (postDTO , Post.class);

        return post;

    }

    public PostDTO backToDto(Post post){

        PostDTO map = modelMapper.map (post , PostDTO.class);

        return map;
    }


//
//        PostResponse postResponse = new PostResponse ();
//
//        postResponse.setContent (found);
//        postResponse.setPageNo (posts.getNumber ());
//        postResponse.setPageSize (posts.getSize ());
//        postResponse.setTotalElements (posts.getTotalElements ());
//        postResponse.setTotalPages (posts.getTotalPages ());
//        postResponse.setLast (posts.isLast ());
//
//        return postResponse;
//    }

//    @Override
//    public List <PostDTO> getAllPosts () {
//
//        List <Post> posts = postRepository.findAll ();
//
//        List <PostDTO> collect = posts.stream ().map (data -> backToDto (data)).collect (Collectors.toList ());
//
//         return collect;
//    }




//        List <PostDTO> objects = new ArrayList <> ();
//
//
//
//        for (Post checks : listOfPosts) {
//
//            PostDTO dto = new PostDTO ();
//
//            dto.setId (checks.getId ());
//            dto.setName (checks.getName ());
//            dto.setPlatform (checks.getPlatform ());
//            dto.setContent (checks.getContent ());
//
//            objects.add (dto);
//
//            }


//        return objects;


//        @Override
//        public PostDTO getOneData (int id){
//
//
//
//
//        }



}