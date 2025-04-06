package com.example.springproxy.app.v1_proxy;

import com.example.springproxy.app.v1.OrderControllerV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderControllerProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;

    @Override
    public String request(String itemId) {
        log.info("====== OrderControllerProxy START =====");
        log.info("====== OrderControllerProxy : call orderControllerV1.request() =====");
        String result = target.request(itemId);
        log.info("====== OrderControllerProxy target result : {}", result);
        log.info("====== OrderControllerProxy END =====");
        return result;
    }

    @Override
    public String noLog() {
        log.info("====== OrderControllerProxy START =====");
        String result = target.noLog();
        log.info("====== OrderControllerProxy target result : {}", result);
        log.info("====== OrderControllerProxy END =====");
        return result;
    }
}
