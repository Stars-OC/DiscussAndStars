package xyz.starsoc.replay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thciwei.x.file.storage.spring.EnableFileStorage;

@SpringBootApplication
@EnableTransactionManagement
@EnableFileStorage
@MapperScan("xyz/starsoc/replay/mapper")
public class ReplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReplayApplication.class, args);
    }

}
