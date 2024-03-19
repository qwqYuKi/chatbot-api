package cn.yuki.chatbot.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author yuki
 * @Date 2024/3/19 19:13
 * @PackageName: cn.yuki.chatbot.api
 * @Description: 启动入口
 * @ClassName: ApiApplication
 * @Version 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
