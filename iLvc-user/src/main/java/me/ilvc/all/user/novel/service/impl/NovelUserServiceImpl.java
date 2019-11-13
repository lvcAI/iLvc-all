package me.ilvc.all.user.novel.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import me.ilvc.all.common.model.novel.User;
import me.ilvc.all.user.novel.mapper.NovelUserMapper;
import me.ilvc.all.user.novel.service.IUserService;
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
@DS("novel")
public class NovelUserServiceImpl extends ServiceImpl<NovelUserMapper, User> implements IUserService {

}
