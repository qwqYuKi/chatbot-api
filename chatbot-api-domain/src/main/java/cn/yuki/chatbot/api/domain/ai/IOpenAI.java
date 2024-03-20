package cn.yuki.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * @Author yuki
 * @Date 2024/3/20 20:34
 * @PackageName: cn.yuki.chatbot.api.domain.ai
 * @Description: chatGPT open ai 接口
 * @ClassName: IOpenAI
 * @Version 1.0
 */
public interface IOpenAI {

    String doChatGPT(String question) throws IOException;
}
