package qtzt.link;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author yuanlin
 * @date 2020/12/13
 *
 * 开启openfeign调用，作为消费者
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class}) // 不加载默认数据源配置
@MapperScan({"qtzt.link.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}