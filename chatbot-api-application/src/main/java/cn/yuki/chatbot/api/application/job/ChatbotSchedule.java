package cn.yuki.chatbot.api.application.job;

import cn.yuki.chatbot.api.domain.ai.IOpenAI;
import cn.yuki.chatbot.api.domain.zsxq.IZsxqApi;
import cn.yuki.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import cn.yuki.chatbot.api.domain.zsxq.model.vo.Topics;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * @Author yuki
 * @Date 2024/3/21 18:18
 * @PackageName: cn.yuki.chatbot.api.application.job
 * @Description: 问答任务
 * @ClassName: chatbotSchedule
 * @Version 1.0
 */
@EnableScheduling
@Configuration
public class ChatbotSchedule {

    private Logger logger = LoggerFactory.getLogger(ChatbotSchedule.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;
    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;

    @Scheduled(cron = "0/30 * * * * ?")
    public void run(){
        try {
            //防止回答太规律被风控
            if(new Random().nextBoolean()){
                logger.info("随机打烊中...");
                return;
            }
            //该时间段不回答问题
            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if(hour > 22 || hour < 7){
                logger.info("打烊时间不工作，ai下班了。请于7~22点来哦");
                return;
            }

            //检索问题
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
            logger.info("检索结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));
            List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
            if(topics == null || topics.isEmpty()){
                logger.info("本次检索未查询到待回答问题");
                return;
            }

            //AI回答，一次只回答一个，回答多了可能会被风控
            Topics topic = topics.get(0);
            String answer = openAI.doChatGPT(topic.getQuestion().getText().trim());

            //问题回复
            boolean status = zsxqApi.answer(groupId, cookie, topic.getTopic_id(), answer, false);
            logger.info("编号：{}，问题：{}，答案：{}，状态：{}",topic.getTopic_id(),topic.getQuestion().getText(),answer,status);
        }catch (Exception e){
            logger.error("自动回答问题异常",e);
        }
    }

}
