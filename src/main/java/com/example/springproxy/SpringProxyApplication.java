package com.example.springproxy;

import com.example.springproxy.app.v1.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({AppV1Config.class})
//@SpringBootApplication(scanBasePackages = "com.example.springproxy.app.v1")
@SpringBootApplication(scanBasePackages = {"com.example.springproxy.app.v2", "com.example.springproxy.app.v3"}) // 컴포넌트 스캔할 대상 패키지
public class SpringProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProxyApplication.class, args);
    }

}
