package me.ilvc.all.novel.service;

import me.ilvc.all.common.model.Result;
import me.ilvc.all.common.model.novel.Subscribe;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author iLvc
 * @since 2019-11-12
 */
public interface ISubscribeService extends IService<Subscribe> {

    Result<Subscribe> addSubcriber(int novelId, String email);

}
