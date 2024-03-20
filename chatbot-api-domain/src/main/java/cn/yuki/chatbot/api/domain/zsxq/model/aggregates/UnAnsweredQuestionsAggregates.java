package cn.yuki.chatbot.api.domain.zsxq.model.aggregates;

import cn.yuki.chatbot.api.domain.zsxq.model.res.RespData;

/**
 * @Author yuki
 * @Date 2024/3/20 16:40
 * @PackageName: cn.yuki.chatbot.api.domain.zsxq.model.aggregates
 * @Description: 未回答问题的聚合信息
 * @ClassName: queryUnAnsweredQuesttionTopicId
 * @Version 1.0
 */
public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;
    private RespData resp_data;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getResp_data() {
        return resp_data;
    }

    public void setResp_data(RespData resp_data) {
        this.resp_data = resp_data;
    }

}
