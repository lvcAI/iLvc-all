package me.ilvc.all.common.model.novel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Builder;
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
@Builder
public class Subscribe implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sb_id", type = IdType.AUTO)
    private Integer sbId;
    @TableField(value = "uid")
    private Integer uid;
    @TableField(value = "novel_id")
    private Integer novelId;

    private LocalDateTime subsTime;
    @TableLogic
    private Integer sbState;


}
