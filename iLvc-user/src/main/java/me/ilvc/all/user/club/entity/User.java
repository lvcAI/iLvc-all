package me.ilvc.all.user.club.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    private String username;

    private String password;

    private String email;

    /**
     * 0男；1女
     */
    private Integer sex;

    private String city;

    private String birthday;

    private String signature;

    private String avatar;

    private LocalDateTime joinTime;

    @TableField("last_loginTIme")
    private LocalDateTime lastLogintime;

    private LocalDateTime onlineTime;

    private String joinIp;

    private String lastIp;

    private String renzheng;

    /**
     * 0
     */
    private Integer uIsActivate;

    /**
     * 角色Id
     */
    private Integer roleId;

    private String roleName;

    private Integer isBindingQq;


}
