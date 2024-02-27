package com.postApi.apiforPost.payload;

import lombok.Data;

import java.util.List;


@Data
public class PostResponse {

    public List <PostDTO> content;

    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private Boolean Last;
}
