package me.ilvc.all.blog.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_blog")
public class Blog {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 阅读量
     */
    @TableField(value = "views")
    private Integer views;

    /**
     * 点赞数
     */
    @TableField(value = "likes")
    private Integer likes;

    /**
     * 标签ID（多个用英文逗号分隔）
     */
    @TableField(value = "tag_ids")
    private String tagIds;

    /**
     * 状态（0：删除；1：正常；2：草稿；3：锁定）
     */
    @TableField(value = "status")
    @TableLogic
    private Byte status;

    /**
     * 是否原创
     */
    @TableField(value = "is_original")
    private Byte isOriginal;

    /**
     * 分类ID
     */
    @TableField(value = "category_id")
    private Integer categoryId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    public static final String COL_ID = "id";

    public static final String COL_TITLE = "title";

    public static final String COL_CONTENT = "content";

    public static final String COL_VIEWS = "views";

    public static final String COL_LIKES = "likes";

    public static final String COL_TAG_IDS = "tag_ids";

    public static final String COL_STATUS = "status";

    public static final String COL_IS_ORIGINAL = "is_original";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}