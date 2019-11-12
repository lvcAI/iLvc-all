package me.ilvc.all.user.blog.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import me.ilvc.all.user.blog.entity.TUser;
import me.ilvc.all.user.blog.mapper.TUserMapper;
import me.ilvc.all.user.blog.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author iLvc
 * @since 2019-11-12
 */
@Service
@DS("blog")
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
