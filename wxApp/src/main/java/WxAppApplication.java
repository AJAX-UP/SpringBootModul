
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wx.project")
public class WxAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxAppApplication.class, args);
    }
}