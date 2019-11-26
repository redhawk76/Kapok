package xyz.redhawk.kapok;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.redhawk.kapok.mapper")
public class KapokApplication {

    public static void main(String[] args) {
        SpringApplication.run(KapokApplication.class, args);
    }

}
