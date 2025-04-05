package com.example.springproxy;

import com.example.springproxy.app.v1.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({AppV1Config.class})
@SpringBootApplication(scanBasePackages = "com.example.springproxy.app.v1")
public class SpringProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProxyApplication.class, args);
    }

}
