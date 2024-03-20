package cn.yuki.chatbot.api.domain.zsxq.model.res;

import cn.yuki.chatbot.api.domain.zsxq.model.req.ReqData;

/**
 * @Author yuki
 * @Date 2024/3/20 16:57
 * @PackageName: cn.yuki.chatbot.api.domain.zsxq.model.res
 * @Description: 请求回答接口结果
 * @ClassName: AnswerReq
 * @Version 1.0
 */
public class AnswerRes {
    private boolean succeeded;


    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }
}
