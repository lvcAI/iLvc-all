package me.ilvc.all.novel.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import me.ilvc.all.common.model.Result;
import me.ilvc.all.common.model.novel.NovelInfo;
import me.ilvc.all.common.model.novel.Subscribe;
import me.ilvc.all.common.model.novel.User;
import me.ilvc.all.novel.feign.NovelUserFeignClient;
import me.ilvc.all.novel.mapper.NovelInfoMapper;
import me.ilvc.all.novel.mapper.SubscribeMapper;
import me.ilvc.all.novel.service.ISubscribeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author iLvc
 * @since 2019-11-12
 */
@Service
@Slf4j
public class SubscribeServiceImpl extends ServiceImpl<SubscribeMapper, Subscribe> implements ISubscribeService {


    @Autowired
    private SubscribeMapper subscribeMapper;

    @Autowired
    private NovelUserFeignClient novelUserFeignClient;

    @Autowired
    private NovelInfoMapper novelInfoMapper;

    /**
     * novel 和 user 是否存在？
     * 1.是否已经订阅
     * 2.
     *
     * @param novelId
     * @param email
     * @return
     */
    public Result<Subscribe> addSubcriber(int novelId, String email) {
        log.info("{} running in {}  start ....", getClass().getName(), "addSubcriber()");
        Result<Subscribe> result = new Result<>();
        Subscribe subscribe = null;
        NovelInfo novelInfo = null;
        User user = null;
        //
        novelInfo = novelInfoMapper.selectById(novelId);

        if (novelInfo == null) {
            result.setCode(1000);
            result.setMsg("该小说不存在！");
            return result;
        }
        Result<User> novel_user_result = novelUserFeignClient.getUserByEmail(email);
        log.info("用户信息：{}",novel_user_result);
        user = novel_user_result.getData();
        if (user == null) {
            result.setCode(1000);
            result.setMsg("内部错误！");
            return result;
        } else {
            // 是否重复订阅
            // 防止重复订阅

            subscribe = subscribeMapper.selectOne(Wrappers.query( Subscribe.builder().build()).eq("novel_id", novelId).eq("uid", email));
            log.info("已存在的订阅 ：{} ",subscribe);
            if (subscribe == null) {
                subscribe = Subscribe.builder()
                        .novelId(Integer.valueOf(novelId))
                        .uid(user.getUid())
                        .build();
                subscribeMapper.insert(subscribe);
                result.setCode(200);
                result.setMsg("订阅成功！");
            } else {
                result.setCode(200);
                result.setMsg("您已经订阅成功，无需重复订阅！");
            }
            result.setData(subscribe);
        }
        log.info("{} running in {}  end ....", getClass().getName(), "addSubcriber()");
        return result;
    }


}
