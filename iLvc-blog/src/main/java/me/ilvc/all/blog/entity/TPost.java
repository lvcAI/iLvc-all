package me.ilvc.all.blog.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class TPost implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    /**
     * 作者
     */
    private Integer userId;

    /**
     * 归档id
     */
    private Integer archiveId;

    /**
     * 标题
     */
    private String title;

    /**
     * markdown内容
     */
    private String markdown;

    /**
     * html内容
     */
    private String html;

    /**
     * 创建时间
     */
    @TableField("createDate")
    private LocalDateTime createDate;

    /**
     * 最后一次修改时间
     */
    @TableField("lastEditDate")
    private LocalDateTime lastEditDate;

    /**
     * 文档状态 0：编辑状态，不显示在页面上，显示在后台列表 1：发布 2：删除，不显示在前台和后台列表，显示在后台垃圾箱
     */
    private Integer state;

    /**
     * 点击量，长整，不要显示在页面上，显示在后台
     */
    private Long rate;

    /**
     * 文章配图
     */
    private String postImg;


}
