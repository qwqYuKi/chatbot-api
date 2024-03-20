package cn.yuki.chatbot.api.domain.zsxq.model.res;

import cn.yuki.chatbot.api.domain.zsxq.model.vo.Topics;

import java.util.List;

/**
 * @Author yuki
 * @Date 2024/3/20 16:41
 * @PackageName: cn.yuki.chatbot.api.domain.zsxq.model.res
 * @Description: 结果数据
 * @ClassName: RespData
 * @Version 1.0
 */
public class RespData {
    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
}
