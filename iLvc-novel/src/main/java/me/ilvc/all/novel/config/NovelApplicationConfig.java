package me.ilvc.all.novel.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.xml.sax.SAXException;

import javax.annotation.Resource;

/**
 * @Author iLvc
 * @contact http://iLvc.me
 * @Since 2019/11/21 11:18:54
 **/

//@Configuration
//@PropertySource("classpath:solr.properties")
@EnableSolrRepositories(basePackages = "me.ilvc.all.novel.repositoty")
public class NovelApplicationConfig {
    @Value("${solr.server.url}")
    private String SOLR_SERVER_URL;

    @Resource
    private Environment environment;

//    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient.Builder(environment.getRequiredProperty(SOLR_SERVER_URL))
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
    }

//    @Bean
    public SolrTemplate solrTemplate(SolrClient client){
        return new SolrTemplate(client);
    }


}
