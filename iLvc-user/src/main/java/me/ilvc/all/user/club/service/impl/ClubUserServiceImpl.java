package me.ilvc.all.user.club.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import me.ilvc.all.user.club.entity.User;
import me.ilvc.all.user.club.mapper.ClubUserMapper;
import me.ilvc.all.user.club.service.IUserService;
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
@DS("club")
public class ClubUserServiceImpl extends ServiceImpl<ClubUserMapper, User> implements IUserService {

}
