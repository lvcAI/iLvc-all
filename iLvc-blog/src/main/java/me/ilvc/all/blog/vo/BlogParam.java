package me.ilvc.all.blog.vo;

import lombok.Data;

@Data
public class BlogParam {

    private String title;
    private String content;
    private String tagIds;
    private Integer categoryId;
    private Byte isOriginal;
}
