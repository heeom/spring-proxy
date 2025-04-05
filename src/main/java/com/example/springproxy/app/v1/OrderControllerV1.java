package com.example.springproxy.app.v1;

import org.springframework.web.bind.annotation.*;

/**
 * boot 3.0 (spring 6.0) 부터 클래스 레벨에 @RequestMapping 이 있어도 스프링 컨트롤러로 인식하지 않는다.
 * @Controller가 있어야 인식가능 -> @RestController = @ResponsBody + @Controller 포함하므로 인식 가능
 */
//@RequestMapping // 스프링은 @Controller 또는 @RequestMapping 이 있어야 스프링 컨트롤러로 인식
@RestController
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
