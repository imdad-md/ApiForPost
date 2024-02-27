package com.postApi.apiforPost.controller;

import com.postApi.apiforPost.payload.CommentDTO;
import com.postApi.apiforPost.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//
//
//import com.postApi.apiforPost.payload.CommentDTO;
//import com.postApi.apiforPost.services.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
@RestController
@RequestMapping("/api")
public class CommentController {


    private CommentService commentService;

    public CommentController (CommentService commentService) {

        this.commentService = commentService;
    }

//    @GetMapping("/{postId}/{commentId}")
//    public <CommentDto> getCommentById (@PathVariable("postId") int postId ,
//                                        @PathVariable(value = "id") Long commentId) {

//    @GetMapping("/{postid}/{commentId}")
//    public <CommentDTO> getCommentById (@PathVariable("postId") int postId , @PathVariable("commentId") int commentId) {
//
//        com.postApi.apiforPost.payload.CommentDTO commentById = commentService.getCommentById (postId , commentId);
//    }

//
//
//    @PostMapping
//    public CommentDTO create(@RequestBody CommentDTO  commentDTO){
//
//        CommentDTO data = commentService.createOneComment (commentDTO);
//
//        return data;
//    }
//
//
//}

    @PostMapping("/{postId}/comment")
    public CommentDTO createComment (@PathVariable("postId") int postId , @RequestBody CommentDTO commentDTO) {

        CommentDTO dto = commentService.createOneComment (postId , commentDTO);

        return dto;
    }

    @GetMapping("/{postId}/comment")
    public List <CommentDTO> getCommentsByPostId (@PathVariable("postId") int postId) {
        List <CommentDTO> commentsByPostId = commentService.getCommentsByPostId (postId);
        return commentsByPostId;
    }
//
//    @GetMapping("/{postId}/comments/{commentId}")
//    public CommentDTO getCommentById (
//            @PathVariable("postId") int postId , @PathVariable("commentId") int commentId) {
//        CommentDTO commentById = commentService.getCommentById (postId , commentId);
//
//        return commentById;
//    }
//
//    @PutMapping("/posts/{postId}/comments/{commentId}")
//    public CommentDTO updateComment (@PathVariable("postId") int postId ,
//                                     @PathVariable("commentId") int commentId ,
//                                     @RequestBody CommentDTO commentDto) {
//        CommentDTO dto = commentService.updateComment (postId , commentId , commentDto);
//
//        return dto;
//    }
//
//
//    @DeleteMapping("/posts/{postId}/comments/{commentId}")
//    public void deleteComment(@PathVariable("postId") int postId,
//                                                @PathVariable("id") int commentId){
//        commentService.deleteComment(postId, commentId);
//    }

}