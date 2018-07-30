import interceptor.MyInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * springboot启动类
 */
@SpringBootApplication
@ComponentScan("com.wx.project,interceptor")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);

    }
}
