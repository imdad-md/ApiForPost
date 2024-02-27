package com.postApi.apiforPost.payload;


import com.postApi.apiforPost.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {


    private int id;
    private String name;
    private String content;
    private String platform;



}
