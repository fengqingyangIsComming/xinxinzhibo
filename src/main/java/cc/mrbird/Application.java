package cc.mrbird;

import cc.mrbird.common.cedatasource.DynamicDataSourceRegister;
import cc.mrbird.common.config.FebsProperies;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@MapperScan("cc.mrbird.*.dao")
@PropertySource("application.yml")
@EnableConfigurationProperties({FebsProperies.class})
@EnableCaching
@EnableAsync
@Import({DynamicDataSourceRegister.class}) // 注册动态多数据源
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        log.info("FEBS started up successfully at {} {}", LocalDate.now(), LocalTime.now());
        log.warn("***********程序启动完成！***********");
    }
}
