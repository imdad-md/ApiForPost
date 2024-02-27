package com.postApi.apiforPost.controller;


import com.postApi.apiforPost.payload.PostDTO;
import com.postApi.apiforPost.payload.PostResponse;
import com.postApi.apiforPost.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts/api")
public class    PostController {

    @Autowired
    private PostService postService;


    //   http://localhost:8080/posts/api/post

    //  @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/post")
    public PostDTO savePost (@RequestBody PostDTO postDTO) {
        PostDTO dto = postService.savesPost (postDTO);
        return dto;
    }


    // above we have post persisted the data in the database using postmapping
    // first way was returning the object of the postDTO class and the second
    // method uses ResponseEntity to show the response status of the data persisted.

//@GetMapping("/get")
//    public List<PostDTO> getAll() {
//
//        List <PostDTO> allPosts = postService.getAllPosts ();
//
//        return allPosts;
//    }


    // http://localhost:8080/posts/api/get
//    @GetMapping("/get")
//    public ResponseEntity <List<PostDTO> >getAll() {
//
//        List <PostDTO> allPosts = postService.getAllPosts ();
//
//        return  ResponseEntity.status (HttpStatus.FOUND).body (allPosts);
//
//    }

    // http://localhost:8080/posts/api/get?pageNo=1&pageSize=4&sortDir=ascending&sortBy=content
//    @GetMapping("/get")
//    public List <PostDTO> getAllDatas (@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo ,
//                                       @RequestParam(value = "pageSize", defaultValue = "3", required = false) int pageSize ,
//                                       @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy ,
//                                       @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
//
//
//        List <PostDTO> allPosts = postService.getAllPosts (pageNo , pageSize , sortBy , sortDir);
//
//        return allPosts;
//
//    }


    // http://localhost:8080/posts/api/get?pageNo=1&pageSize=4&sortDir=ascending&sortBy=content
    @GetMapping("/get")
    public PostResponse getAllDatas (@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo ,
                                            @RequestParam(value = "pageSize", defaultValue = "3", required = false) int pageSize ,
                                            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy ,
                                            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {

        PostResponse allPosts = postService.getAllPosts (pageNo , pageSize , sortBy , sortDir);
        return  allPosts;

    }


    // above we have fetched the data using normal way as well as using the PostResponse
    // class where we have implemented the pagination and sorting as well.
    // we have also fetched the data using and showing the status using ResponseEntity class




    // http://localhost:8080/posts/api/2


    @GetMapping("/{id}")
    public ResponseEntity <PostDTO> getOne (@PathVariable("id") int id) {

        PostDTO oneData = postService.getOneData (id);

        return ResponseEntity.status (HttpStatus.FOUND).body (oneData);

    }

    //    http://localhost:8080/posts/api/3
//@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity <PostDTO> updateOne (@PathVariable("id") int id , @RequestBody PostDTO postDTO) {

        PostDTO dto = postService.updateOneData (id , postDTO);

        return ResponseEntity.status (HttpStatus.ACCEPTED).body (dto);

    }

    //    http://localhost:8080/posts/api/3
//@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity <PostDTO> deleteOne (@PathVariable("id") int id) {
        postService.deleteOne (id);

        return ResponseEntity.status (HttpStatus.GONE).build ();
    }

    @DeleteMapping
    public ResponseEntity <PostDTO> deleteAll (PostDTO postDTO) {

        postService.deleteAll (postDTO);
        return ResponseEntity.status (HttpStatus.FORBIDDEN).build ();

    }
}