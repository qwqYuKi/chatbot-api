package cn.yuki.chatbot.api.domain.zsxq.model.vo;

/**
 * @Author yuki
 * @Date 2024/3/20 16:35
 * @PackageName: cn.yuki.chatbot.api.domain.zsxq.model.vo
 * @Description: TODO
 * @ClassName: UserSpecific
 * @Version 1.0
 */
public class UserSpecific {

    private boolean liked;

    private boolean subscribed;

    public void setLiked(boolean liked){
        this.liked = liked;
    }
    public boolean getLiked(){
        return this.liked;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }

}