package me.ilvc.all.user.club.entity;

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
public class UserQq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String qOpenid;

    private String qNickname;

    private String qGender;

    private String qAvatar;

    private Integer uid;

    private LocalDateTime addTime;

    private Integer isBinding;


}
