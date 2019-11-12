package me.ilvc.all.novel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author iLvc
 * @since 2019-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class NovelInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "novel_id", type = IdType.AUTO)
    private Integer novelId;

    private String novelName;

    private String novelCode;

    private String novelUrl;

    private String novelAuthor;

    private String novelCategory;

    private String novelImg;

    private String novelBrief;

    private String novelState;

    private String newUpdateChapter;

    private String newUpdateChapterTime;

    private String newUpdateChapterTimeOld;

    private String newUpdateChapterUrl;

    private LocalDateTime fisrtAddTime;

    private Integer smId;

    private Integer weight;


}
