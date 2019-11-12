package me.ilvc.all.user.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;

/**
 * @author Lvc
 * @create 2019/11/12 17:01
 */
//@Configuration
//@MapperScan(basePackages = "me.ilvc.all.user.novel.mapper", sqlSessionTemplateRef = "novelSqlSessionTemplate")
public class NovelDataSourceConfig {

    @Bean
    // 根据application.properteis系统配置文件中,对应属性的前缀,指明使用其对应的数据
    @ConfigurationProperties(prefix = "spring.datasource.novel")
    public DataSource novelDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @DependsOn("novelDataSource")
    public SqlSessionFactory novelSqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        System.out.println(novelDataSource());
        factoryBean.setDataSource(novelDataSource());
        return factoryBean.getObject();
    }

    /**
     * DefaultSqlSession和SqlSessionTemplate都实现了SqlSession,但我们
     * 注入线程安全的SqlSessionTemplate,而不使用默认的线程不安全的DefaultSqlSession
     *
     */
//    @Bean
    @DependsOn("novelSqlSessionFactory")
    public SqlSessionTemplate novelSqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(novelSqlSessionFactory());
        return template;
    }

}
