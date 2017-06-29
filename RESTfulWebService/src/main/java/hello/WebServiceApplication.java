package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Allen on 2017/6/29.
 */
//Your ApplicationContext is unlikely to start due to a @ComponentScan of the default package.
//查了半天终于才stack overflow上看到了解决方案，链接如下：stack overflow
//是因为application.java 文件不能直接放在main/java文件夹下，必须要建一个包把他放进去

@SpringBootApplication
public class WebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }
}
