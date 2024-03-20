package cn.yuki.chatbot.api.domain.zsxq;

import cn.yuki.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * @Author yuki
 * @Date 2024/3/20 16:28
 * @PackageName: cn.yuki.chatbot.api.domain.zsxq
 * @Description: 知识星球Api接口
 * @ClassName: ZsxqApi
 * @Version 1.0
 */
public interface IZsxqApi {
    /**
     * 未回答的问题的聚合接口
     * @param groupId
     * @param cookie
     * @return
     * @throws IOException
     */
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;

    /**
     *
     * @param groupId
     * @param cookie
     * @param topicId
     * @param text
     * @param silenced 是否可见
     * @return
     * @throws IOException
     */
    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;

}
