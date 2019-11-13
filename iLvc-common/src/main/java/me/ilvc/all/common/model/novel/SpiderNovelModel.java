package me.ilvc.all.common.model.novel;

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
public class SpiderNovelModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sm_id", type = IdType.AUTO)
    private Integer smId;

    private String smSiteName;

    private String smSiteDomain;

    private String novelUrl;

    private String smNovelUrlRex;

    private String smNovelUrlRegxRange;

    private String novelNamme;

    private String novelAuthor;

    private String novelCategory;

    private String novelImg;

    private String novelBrief;

    private String novelState;

    private String newUpdateChapter;

    private String newUpdateChapterTime;

    private String newUpdateChapterUrl;

    private String chapterName;

    private String chapterNovelName;

    private String chapterContent;

    private String chapterUrl;

    private String preChapterUrl;

    private String nextChpterUrl;

    private LocalDateTime addTime;


}
