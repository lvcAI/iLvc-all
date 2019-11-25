package me.ilvc.all.novel.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author iLvc
 * @contact http://iLvc.me
 * @Since 2019/11/25 11:10:04
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovelChapterParam {

    private Integer chapteId;

    private String novelName;

    private String chapterName;

    private String chapterContent;

    private Integer novelId;
    private String chapterUpdateTime;
}
