package qtzt.link.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanlin
 * @date: 2021-06-01 15:14:42
 * @description:
 */

@Configuration
@Component
public class DynamicDataSourceConfig {
    /**
     * 读取application配置，构建master-db数据源
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.db-main")
    public DataSource myDataSourceMain(){
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 读取application配置，构建slave-db数据源
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.db-sso")
    public DataSource myDataSourceSSO(){
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 读取application配置，构建slave-db数据源
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.db-slave")
    public DataSource myDataSourceSlave(){
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 读取application配置，创建动态数据源
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource myDataSourceMain, DataSource myDataSourceSSO, DataSource myDataSourceSlave) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("db-main",myDataSourceMain);
        targetDataSources.put("db-sso", myDataSourceSSO);
        targetDataSources.put("db-slave", myDataSourceSlave);
        // myDataSourceV5=默认数据源
        // targetDataSources=目标数据源（多个）
        return new DynamicDataSource(myDataSourceMain, targetDataSources);
    }
}
