package cn.yuki.chatbot.api.domain.zsxq.model.vo;

/**
 * @Author yuki
 * @Date 2024/3/20 16:32
 * @PackageName: cn.yuki.chatbot.api.domain.zsxq.model.vo
 * @Description: TODO
 * @ClassName: Question
 * @Version 1.0
 */
public class Question
{
    private Owner owner;

    private Questionee questionee;

    private String text;

    private boolean expired;

    private boolean anonymous;

    private String owner_location;

    public void setOwner(Owner owner){
        this.owner = owner;
    }
    public Owner getOwner(){
        return this.owner;
    }
    public void setQuestionee(Questionee questionee){
        this.questionee = questionee;
    }
    public Questionee getQuestionee(){
        return this.questionee;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void setExpired(boolean expired){
        this.expired = expired;
    }
    public boolean getExpired(){
        return this.expired;
    }
    public void setAnonymous(boolean anonymous){
        this.anonymous = anonymous;
    }
    public boolean getAnonymous(){
        return this.anonymous;
    }
    public void setOwner_location(String owner_location){
        this.owner_location = owner_location;
    }
    public String getOwner_location(){
        return this.owner_location;
    }
}
