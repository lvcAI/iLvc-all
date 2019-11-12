package me.ilvc.all.novel.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lvc
 * @create 2019/11/12 14:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NovelInfoMapperTest {

    @Autowired
    private NovelInfoMapper novelInfoMapper;


    @Test
    public void testSelectById(){
        System.out.println(novelInfoMapper.selectById(46084));
    }


}
