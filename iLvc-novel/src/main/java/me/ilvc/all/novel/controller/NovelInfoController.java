package me.ilvc.all.novel.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import me.ilvc.all.common.model.Result;
import me.ilvc.all.common.model.Results;
import me.ilvc.all.common.model.novel.NovelChapter;
import me.ilvc.all.common.model.novel.NovelInfo;
import me.ilvc.all.novel.service.INovelChapterService;
import me.ilvc.all.novel.service.INovelInfoService;
import me.ilvc.all.novel.vo.NovelChapterParam;
import me.ilvc.all.novel.vo.NovelInfoParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author iLvc
 * @since 2019-11-12
 */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class NovelInfoController {


    @Autowired
    private INovelInfoService novelInfoService;

    @Autowired
    private INovelChapterService chapterService;

    @GetMapping(path = {"/novels/{id}","/novels/{id}/"})
    public Result<NovelInfoParam> getById(@PathVariable("id")Integer id){
        NovelInfoParam novelInfoParam = new NovelInfoParam();
        BeanUtils.copyProperties(novelInfoService.getById(id),novelInfoParam);

        List<NovelChapterParam> chapters = new ArrayList<>();
        for (NovelChapter c : chapterService.list(Wrappers.query(new NovelChapter()).eq("novel_name", novelInfoParam.getNovelName()).orderByDesc("chapter_name"))
        ) {
            NovelChapterParam param = new NovelChapterParam();
            BeanUtils.copyProperties(c, param);
            param.setChapterContent("");
            chapters.add(param);
        }
        log.info("{} 的章节数为 {} ", novelInfoParam.getNovelName(), chapters.size());
        return Result.okWithDataAndExtra(novelInfoParam, MapUtil.of("chapters",chapters));
    }

    @GetMapping(path = {"/novels/v1/{id}","//novels{id}/"})
    public Result<NovelInfo> getById2(@PathVariable("id")Integer id){
        return Result.okWithData(novelInfoService.getById(id));
    }

//    @GetMapping(path = {"/novels/"})
    public  Results<NovelInfoParam> getNovels(int pageNo , int pageSize){
        // 注意分页
        List<NovelInfo> novelInfos = novelInfoService.page(new Page<NovelInfo>(pageNo, pageSize)).getRecords();

        return Results.okWithData(novelInfos);
    }

    @GetMapping(path = {"/novels/"})
    public  Result getNovelsByPage(@RequestParam("page") Integer pageNo ,@RequestParam("page_size") Integer pageSize){
        // 注意分页
        IPage<NovelInfo> pages =  novelInfoService.page(new Page<NovelInfo>(pageNo, pageSize),
                Wrappers.query(new NovelInfo()).select("novel_id,new_update_chapter_time,novel_img,novel_author,novel_state,new_update_chapter,novel_name,novel_brief").orderByDesc(true, "weight")
        );

//        List<NovelInfoParam> params = new ArrayList<>();
        // 处理分页的数据
        for (int i = 0; i < pages.getRecords().size(); i++) {
            // 还可以有优化的空间，倒了两次 这里有问题。
            NovelInfo novelInfo = pages.getRecords().get(i);
            // 只显示部分简介内容，只留下前66个字符。
            if (novelInfo.getNovelBrief().length() >= 66) {
                novelInfo.setNovelBrief(novelInfo.getNovelBrief().substring(0, 66) + "......");
            }else {
                // 为了保持排版的一致性，补足66个字符，即显示三行
                int size = novelInfo.getNovelBrief().length();
                StringBuilder builder = new StringBuilder();
                while (66 - size++ >=0){
                    builder.append("    ");
                }
                novelInfo.setNovelBrief(novelInfo.getNovelBrief() + builder);
            }
//            NovelInfoParam param = new NovelInfoParam();
//            BeanUtils.copyProperties(novelInfo, param);
//            param.setNovelBrief("");
//            BeanUtils.copyProperties(param, novelInfo);
//            pages.getRecords().add(i,novelInfo);
        }
        log.info("获取page_size:{} 总数为：{}",pageSize,pages.getTotal());
        return Result.okWithData(pages);
    }

}
