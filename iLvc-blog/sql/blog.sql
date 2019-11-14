CREATE TABLE `t_blog`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `title`       varchar(50) NOT NULL COMMENT '标题',
    `content`     text        NOT NULL COMMENT '内容',
    `views`       int(11)     NOT NULL DEFAULT '0' COMMENT '阅读量',
    `likes`       int(11)     NOT NULL DEFAULT '0' COMMENT '点赞数',
    `tag_ids`     varchar(50)          DEFAULT NULL COMMENT '标签ID（多个用英文逗号分隔）',
    `status`      tinyint(4)  NOT NULL DEFAULT '1' COMMENT '状态（0：删除；1：正常；2：草稿；3：锁定）',
    `is_original` tinyint(4)  NOT NULL COMMENT '是否原创',
    `category_id` int(11)              DEFAULT NULL COMMENT '分类ID',
    `user_id`     int(11)     NOT NULL COMMENT '用户ID',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;