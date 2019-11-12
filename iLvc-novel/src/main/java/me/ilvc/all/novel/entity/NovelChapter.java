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
public class NovelChapter implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "chapte_id", type = IdType.AUTO)
    private Integer chapteId;

    private String novelName;

    private String chapterName;

    private String chapterContent;

    private String chapterCode;

    private String chapterUrl;

    private String novelCode;

    private Integer novelId;

    private LocalDateTime adddTime;

    private String preChapterUrl;

    private String nextChpterUrl;

    private Integer smId;

    private String chapterUpdateTime;


}
