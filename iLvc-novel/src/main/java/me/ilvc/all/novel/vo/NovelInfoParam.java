package me.ilvc.all.novel.vo;

import lombok.Data;

/**
 * @author Lvc
 * @create 2019/11/16 03:48
 */
@Data
public class NovelInfoParam {

    private Integer novelId;

    private String novelName;

    private String novelAuthor;

    private String novelCategory;

    private String novelImg;

    private String novelBrief;

    private String novelState;

    private String newUpdateChapter;

    private String newUpdateChapterTime;

}
