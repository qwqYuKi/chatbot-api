package cn.yuki.chatbot.api.domain.ai.service;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import cn.yuki.chatbot.api.domain.ai.IOpenAI;
import cn.yuki.chatbot.api.domain.ai.model.aggregates.AIAnswer;
import cn.yuki.chatbot.api.domain.ai.model.vo.Choices;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author yuki
 * @Date 2024/3/20 20:35
 * @PackageName: cn.yuki.chatbot.api.domain.ai.service
 * @Description: 调用服务
 * @ClassName: IOpenAI
 * @Version 1.0
 */
@Service
public class OpenAI implements IOpenAI {

    private Logger logger = LoggerFactory.getLogger(OpenAI.class);

    @Value("${chatbot-api.openAiKey}")
    private String openAiKey;

    @Override
    public String doChatGPT(String question) throws IOException {
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//
//        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
//        post.addHeader("Content-Type","application/json");
//        post.addHeader("Authorization","Bearer openAiKey");
//
//        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + question +"\", \"temperature\": 0,\"max_tokens\": 1024}";
//
//        CloseableHttpResponse response = httpClient.execute(post);
//        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//            String jsonStr = EntityUtils.toString(response.getEntity());
//            AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
//            StringBuilder answer = new StringBuilder();
//            List<Choices> choices = aiAnswer.getChoices();
//            for(Choices choice : choices){
//                answer.append(choice.getText());
//            }
//            return answer.toString();
//        }else{
//            throw new RuntimeException("api.openai.com Err Code is " + response.getStatusLine().getStatusCode());
//        }



        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions";
        String accessToken = "24.9737d96c89398debaae8ac6a35a8fea3.2592000.1713525779.282335-57391140";

        HashMap<String, String> msg = new HashMap<>();
        msg.put("role", "user");
        msg.put("content", question);

        ArrayList<HashMap> messages = new ArrayList<>();
        messages.add(msg);

        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("messages", messages);

        String response = HttpUtil.post(url + "?access_token=" + accessToken, JSONUtil.toJsonStr(requestBody));

        AIAnswer aiAnswer = JSON.parseObject(response, AIAnswer.class);
        String answer = aiAnswer.getResult();

        return answer;
    }
}
