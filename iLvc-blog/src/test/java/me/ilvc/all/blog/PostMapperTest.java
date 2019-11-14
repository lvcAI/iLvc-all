package me.ilvc.all.blog;

import me.ilvc.all.blog.entity.TPost;
import me.ilvc.all.blog.mapper.PostMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lvc
 * @create 2019/11/12 10:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostMapperTest {

    @Autowired
    private PostMapper postMapper;


    @Test
    public void testselectById(){

        TPost TPost =  postMapper.selectById(44);
        System.out.println(TPost);
    }
}
