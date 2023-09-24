//package com.zhu.blog.service.mq;
//
//import com.alibaba.fastjson.JSON;
//import com.zhu.blog.service.ArticleService;
//import com.zhu.blog.vo.ArticleMessage;
//import com.zhu.blog.vo.Result;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//import java.util.Set;
//
//@Slf4j
//@Component
//@RocketMQMessageListener(topic = "blog-update-article",consumerGroup = "blog-update-article-group")
//public class ArticleListener implements RocketMQListener<ArticleMessage> {
//
//    @Autowired
//    private ArticleService articleService;
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @Override
//    public void onMessage(ArticleMessage message) {
//        log.info("收到的消息:{}",message);
//
//        Long articleId = message.getArticleId();
//        if(articleId!=-1){
//            String params = DigestUtils.md5Hex(articleId.toString());
//            String redisKey = "view_article::ArticleController::findArticleById::"+params;
//            Result articleResult = articleService.findArticleById(articleId);
//            redisTemplate.opsForValue().set(redisKey, JSON.toJSONString(articleResult), Duration.ofMillis(5 * 60 * 1000));
//            log.info("更新了缓存:{}",redisKey);
//        }
//
//        Set<String> keys = redisTemplate.keys("listArticle*");
//        keys.forEach(s -> {
//            redisTemplate.delete(s);
//            log.info("删除了文章列表的缓存:{}",s);
//        });
//    }
//}
