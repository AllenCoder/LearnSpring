package hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Allen on 2017/6/29.
 */
@SpringBootApplication
public class GsBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(GsBatchApplication.class, args);
    }
}
/*错误原因
 1.  @Bean 方法不能私有
 2.JobExecutionListenerSupport
*
*3. Person缺少空构造方法
*
* */