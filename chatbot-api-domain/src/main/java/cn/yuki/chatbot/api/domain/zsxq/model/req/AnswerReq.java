package cn.yuki.chatbot.api.domain.zsxq.model.req;

/**
 * @Author yuki
 * @Date 2024/3/20 16:56
 * @PackageName: cn.yuki.chatbot.api.domain.zsxq.model.req
 * @Description: 请求回答接口信息
 * @ClassName: Answer
 * @Version 1.0
 */
public class AnswerReq {
    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }
}
