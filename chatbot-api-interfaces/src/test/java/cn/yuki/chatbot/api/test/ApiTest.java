package cn.yuki.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.junit.Test;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author yuki
 * @Date 2024/3/19 19:32
 * @PackageName: cn.yuki.chatbot.api.test
 * @Description: 单元测试
 * @ClassName: ApiTest
 * @Version 1.0
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88888822488552/topics?scope=all&count=20");

        get.addHeader("cookie","sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585118111241584%22%2C%22first_id%22%3A%2218ba8fb1aaddf-025acfbff283e5e-26031051-1327104-18ba8fb1aae5e4%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiYThmYjFhYWRkZi0wMjVhY2ZiZmYyODNlNWUtMjYwMzEwNTEtMTMyNzEwNC0xOGJhOGZiMWFhZTVlNCIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4NTExODExMTI0MTU4NCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585118111241584%22%7D%2C%22%24device_id%22%3A%2218ba8fb1aaddf-025acfbff283e5e-26031051-1327104-18ba8fb1aae5e4%22%7D; zsxq_access_token=39AFE0CC-434C-91BB-220C-E15BE98356B9_4100D0FA29ADCAE7; zsxqsessionid=ec02e8794461ee822b05317bd5c7765e; abtest_env=product");
        get.addHeader("Content-Type","application/json;charset=utf-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/2855845454444441/answer");

        post.addHeader("cookie","sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585118111241584%22%2C%22first_id%22%3A%2218ba8fb1aaddf-025acfbff283e5e-26031051-1327104-18ba8fb1aae5e4%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiYThmYjFhYWRkZi0wMjVhY2ZiZmYyODNlNWUtMjYwMzEwNTEtMTMyNzEwNC0xOGJhOGZiMWFhZTVlNCIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4NTExODExMTI0MTU4NCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585118111241584%22%7D%2C%22%24device_id%22%3A%2218ba8fb1aaddf-025acfbff283e5e-26031051-1327104-18ba8fb1aae5e4%22%7D; zsxq_access_token=39AFE0CC-434C-91BB-220C-E15BE98356B9_4100D0FA29ADCAE7; abtest_env=product; zsxqsessionid=cb9f6cdec944557e9656cdee2cf29152");
        post.addHeader("Content-Type","application/json;charset=utf-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"用得着你说？\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_chatGPT() throws IOException{
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//
//        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
//        post.addHeader("Content-Type","application/json");
//        post.addHeader("Authorization","Bearer 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");
//
//        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"帮我写一个冒泡排序\", \"temperature\": 0,\"max_tokens\": 1024}";
//
//        CloseableHttpResponse response = httpClient.execute(post);
//        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//            String res = EntityUtils.toString(response.getEntity());
//            System.out.println(res);
//        }else{
//            System.out.println(response.getStatusLine().getStatusCode());
//        }
        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions";
        String accessToken = "24.9737d96c89398debaae8ac6a35a8fea3.2592000.1713525779.282335-57391140";

        HashMap<String, String> msg = new HashMap<>();
        msg.put("role", "user");
        msg.put("content", "帮我写一个c语言的冒泡排序");

        ArrayList<HashMap> messages = new ArrayList<>();
        messages.add(msg);

        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("messages", messages);

        String response = HttpUtil.post(url + "?access_token=" + accessToken, JSONUtil.toJsonStr(requestBody));

        System.out.println(response);

    }
}
