package me.ilvc.all.novel.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import me.ilvc.all.common.model.Result;
import me.ilvc.all.common.model.Results;
import me.ilvc.all.common.model.novel.NovelChapter;
import me.ilvc.all.common.model.novel.NovelInfo;
import me.ilvc.all.novel.service.INovelChapterService;
import me.ilvc.all.novel.service.INovelInfoService;
import me.ilvc.all.novel.vo.NovelChapterParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author iLvc
 * @since 2019-11-12
 */
@RestController
@Slf4j
//@RequestMapping("/novel-chapter")
public class NovelChapterController {

    @Autowired
    private INovelChapterService novelChapterService;
    @Autowired
    private INovelInfoService novelInfoService;

    @GetMapping("/novels/{novelId}/chapters/{chapterId}")
    public Result<NovelChapterParam> getNovelChapterById(@PathVariable String novelId, @PathVariable String chapterId) {
        NovelChapterParam param = new NovelChapterParam();
        NovelChapter chapter = novelChapterService.getById(chapterId);
        BeanUtils.copyProperties(chapter, param);
        return Result.okWithData(param);
    }

    /**
     * 获取小说所有的章节
     *
     * @param novelId
     * @return
     */
    @GetMapping("/novels/{novelId}/chapters")
    public Results<NovelChapterParam> getAllChapterByNovelId(@PathVariable String novelId) {
        List<NovelChapterParam> list = new ArrayList<>();
        NovelInfo novelInfo = novelInfoService.getById(novelId);
        for (NovelChapter chapter : novelChapterService.list(
                Wrappers.query(new NovelChapter()).
                        eq("novel_name", novelInfo.getNovelName()))) {
            NovelChapterParam param = new NovelChapterParam();
            BeanUtils.copyProperties(chapter, param);
            list.add(param);
        }
        return Results.okWithData(list);
    }

    /**
     * 获取小说的最新章节
     *
     * @param novelId
     * @return
     */
    @GetMapping("/novels/{novelId}/chapters/new")
    public Result<NovelChapterParam> getChapterByLatestByNovelId(@PathVariable Integer novelId) {

        NovelInfo novelInfo = novelInfoService.getById(novelId);
        if (novelId == null) {
            return Result.errorWithMsg("小说 " + novelId + " 不存在！");
        }

        NovelChapter novelChapter = novelChapterService.getOne(
                Wrappers.query(new NovelChapter()).
                        eq("chapter_name", novelInfo.getNewUpdateChapter()));
        NovelChapterParam param = new NovelChapterParam();
        if (novelChapter == null) {
            // 最新章节没有 需要 爬虫去处理
            // 暂时不做处理
            return Result.errorWithMsg("该章节不存在，或正在更新！请稍后在尝试！");
        }
        BeanUtils.copyProperties(novelChapter, param);
        return Result.okWithData(param);
    }

    @GetMapping("/novels/{novelId}/chapters/{chapterId}/pre")
    public Result<NovelChapterParam> getPreChapterByChapterId(@PathVariable Integer novelId, @PathVariable Integer chapterId) {

        NovelInfo novelInfo = novelInfoService.getById(novelId);
        if (novelInfo == null) {
            return Result.errorWithMsg("小说 " + novelId + " 不存在！");
        }
        NovelChapter curr_chapter = novelChapterService.getById(chapterId);
        log.info("当前章节：{ }",curr_chapter);
        // 上一章节
        if (curr_chapter == null) {
            return Result.errorWithMsg(chapterId+"该章节不存在！");
        }
        NovelChapter novelChapter = novelChapterService.getOne(
                Wrappers.query(new NovelChapter()).
                        eq("chapter_url", curr_chapter.getPreChapterUrl()));
        NovelChapterParam param = new NovelChapterParam();
        BeanUtils.copyProperties(novelChapter, param);
        return Result.okWithData(param);
    }

    @GetMapping("/novels/{novelId}/chapters/{chapterId}/next")
    public Result<NovelChapterParam> getNextChapterByChapterId(@PathVariable Integer novelId, @PathVariable Integer chapterId) {

        NovelInfo novelInfo = novelInfoService.getById(novelId);
        if (novelInfo == null) {
            return Result.errorWithMsg("小说 " + novelId + " 不存在！");
        }
        NovelChapter curr_chapter = novelChapterService.getById(chapterId);
        log.info("当前章节：{ }",curr_chapter);
        // 上一章节
        if (curr_chapter == null) {
            return Result.errorWithMsg(chapterId+"该章节不存在！");
        }
        NovelChapter novelChapter = novelChapterService.getOne(
                Wrappers.query(new NovelChapter()).
                        eq("chapter_url", curr_chapter.getNextChpterUrl()));
        NovelChapterParam param = new NovelChapterParam();
        BeanUtils.copyProperties(novelChapter, param);
        return Result.okWithData(param);
    }

}
