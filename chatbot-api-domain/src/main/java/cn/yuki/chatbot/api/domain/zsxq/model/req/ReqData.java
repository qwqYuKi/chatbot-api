package cn.yuki.chatbot.api.domain.zsxq.model.req;

/**
 * @Author yuki
 * @Date 2024/3/20 16:37
 * @PackageName: cn.yuki.chatbot.api.domain.zsxq.model.req
 * @Description: TODO
 * @ClassName: ReqData
 * @Version 1.0
 */
public class ReqData {

    private String text;
    private String[] image_ids = new String[]{};
    private boolean silenced;

    public ReqData(String text, boolean silenced) {
        this.text = text;
        this.silenced = silenced;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(String[] image_ids) {
        this.image_ids = image_ids;
    }

    public boolean isSilenced() {
        return silenced;
    }

    public void setSilenced(boolean silenced) {
        this.silenced = silenced;
    }
}