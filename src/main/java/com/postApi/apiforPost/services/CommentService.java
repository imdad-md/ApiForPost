package com.postApi.apiforPost.services;

import com.postApi.apiforPost.payload.CommentDTO;

import java.util.List;

public interface CommentService {


  CommentDTO createOneComment (int postId,CommentDTO commentDTO);

  List<CommentDTO> getCommentsByPostId (int postId);

  CommentDTO getCommentById (int postId,int commentId);

  CommentDTO updateComment (int postId, int commentId, CommentDTO commentDTO);

  void deleteComment (int postId , int commentId);


//   List<CommentDTO> getCommentsByPostId(int postId);
}


////    CommentDTO createData (CommentDTO commentDTO);
//
//    CommentDTO crateOne (CommentDTO commentDTO);
//
//  public List <CommentDTO> getAll ();
//
//    CommentDTO findOne (int id);
//
//    CommentDTO updateOne (int id , CommentDTO commentDTO);
//
//    CommentDTO deletOne (int id);
//
//    CommentDTO deletAlls ();
//}
