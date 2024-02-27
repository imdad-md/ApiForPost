package com.postApi.apiforPost.payload;


import com.postApi.apiforPost.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private int id;
    private String name;
    private String email;

}
