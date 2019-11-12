package me.ilvc.all.user.blog.mapper;

import me.ilvc.all.user.blog.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author iLvc
 * @since 2019-11-12
 */
@Repository
public interface TUserMapper extends BaseMapper<TUser> {

}
