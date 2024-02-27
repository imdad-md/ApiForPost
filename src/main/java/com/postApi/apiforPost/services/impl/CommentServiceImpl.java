package com.postApi.apiforPost.services.impl;

import com.postApi.apiforPost.entities.Comment;
import com.postApi.apiforPost.entities.Post;
import com.postApi.apiforPost.exception.BlogAPIException;
import com.postApi.apiforPost.exception.ResourceNotFoundException;
import com.postApi.apiforPost.payload.CommentDTO;
import com.postApi.apiforPost.repository.CommentRepository;
import com.postApi.apiforPost.repository.PostRepository;
import com.postApi.apiforPost.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;

    @Override
    public CommentDTO createOneComment (int postId , CommentDTO commentDTO) {

        Comment comment = mapToEntity (commentDTO);

        Post post = postRepository.findById (postId).get ();

        comment.setPost (post);

        Comment save = commentRepository.save (comment);

        CommentDTO commentDTO1 = backToDto (save);

        return commentDTO;
    }

    @Override
    public List <CommentDTO> getCommentsByPostId (int postId) {

        List <Comment> list = commentRepository.findCommentByPostId (postId);

        List <CommentDTO> collect = list.stream ().map (comment -> backToDto (comment)).collect (Collectors.toList ());
        return collect;
    }

    @Override
    public CommentDTO getCommentById (int postId , int commentId) {

        Post post = postRepository.findById (postId).orElseThrow (() -> new ResourceNotFoundException ("Post" , "id" , postId));

        Comment comment = commentRepository.findById (commentId).orElseThrow (() -> new ResourceNotFoundException ("Comment" , "id" , commentId));

        if (comment.getPost ().getId () != post.getId ()) {

            throw new BlogAPIException (HttpStatus.BAD_REQUEST , "Comment does not belong to post");


        }

        CommentDTO dto = backToDto (comment);


        return dto;

    }

    @Override
    public CommentDTO updateComment (int postId , int commentId , CommentDTO commentDTO) {
        Post post = postRepository.findById (postId).get ();
        Comment comment = commentRepository.findById (commentId).get ();

        if (comment.getPost ().getId () != post.getId ()) {

//
            comment.setName (commentDTO.getName ());
            comment.setEmail (commentDTO.getEmail ());

            Comment saved = commentRepository.save (comment);
        }
        CommentDTO dto1 = backToDto (comment);


        return dto1;

    }

    @Override
    public void deleteComment (int postId , int commentId) {
        Post post = postRepository.findById (postId).get ();

        Comment comment = commentRepository.findById (commentId).get ();

        if (comment.getPost ().getId () == (post.getId ())) {
            commentRepository.delete (comment);
        }


    }


//    @Override
//    public List <CommentDto> getCommentsByPostId (int postId) {
//
//        List <Comment> list = commentRepository.findByPostId (postId);
//
//        return list.stream ().map (comment -> backToDto (comment)).collect (Collectors.toList ());
//
////        CommentDTO dto = backToDto (comment);
////
////        return collect;
//
//    }


    ////    @Override
////    public CommentDTO createData (CommentDTO commentDTO) {
////
////        Comment comment = mapToEntity (commentDTO);
////
////        Comment save = commentRepository.save (comment);
////
////        CommentDTO commentDTO1 = backToDto (save);
////
////        return commentDTO;
////
////    }
//
//    @Override
//    public CommentDTO crateOne (CommentDTO commentDTO) {
//
//        Comment comment = mapToEntity (commentDTO);
//
//        commentRepository.save (comment);
//
//        CommentDTO commentDTO1 = backToDto (comment);
//        return commentDTO1;
//    }
//
//    @Override
//    public List <CommentDTO> getAll () {
//
//        List <Comment> all = commentRepository.findAll ();
//
//        List <CommentDTO> list = new ArrayList <> ();
//
//        for (Comment check : all) {
//
//            CommentDTO comment = new CommentDTO ();
//            comment.setId (check.getId ());
//            comment.setName (check.getName ());
//            comment.setEmail (check.getEmail ());
//
//            list.add (comment);
//
//        }
//
//        return list;
//
//    }
//
//    @Override
//    public CommentDTO findOne (int id) {
//
//        Comment comment = commentRepository.findById (id).get ();
//
//        CommentDTO commentDTO = backToDto (comment);
//
//        return commentDTO;
//    }
//
//    @Override
//    public CommentDTO updateOne (int id , CommentDTO commentDTO) {
//
//        Comment comment = commentRepository.findById (id).get ();
//
//        comment.setName (commentDTO.getName ());
//        comment.setEmail (commentDTO.getEmail ());
//
//        commentRepository.save (comment);
//
//        CommentDTO commentDTO1 = backToDto (comment);
//        return commentDTO1;
//    }
//
//    @Override
//    public CommentDTO deletOne (int id) {
//        commentRepository.deleteById (id);
//        return null;
//    }
//
//    @Override
//    public CommentDTO deletAlls () {
//
//        commentRepository.deleteAll ();
//        return null;
//    }


    //
//
    public Comment mapToEntity (CommentDTO commentDTO) {

//        Comment comment = new Comment ();
//        comment.setId (commentDTO.getId ());
//         comment.setName (commentDTO.getName ());
//        comment.setEmail (commentDTO.getEmail ());
//
//            return comment;
        Comment map = modelMapper.map (commentDTO , Comment.class);

        return map;

    }

    public CommentDTO backToDto (Comment comment) {

//        CommentDTO commentDTO = new CommentDTO ();
//
//        commentDTO.setId (comment.getId ());
//        commentDTO.setName (comment.getName ());
//        commentDTO.setEmail (comment.getEmail ());
//
//        return commentDTO;

        CommentDTO map = modelMapper.map (comment , CommentDTO.class);

        return map;
    }
}
