package com.example.springproxy.app.v1_proxy;

import com.example.springproxy.app.common.LogTrace;
import com.example.springproxy.app.v1.OrderServiceV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderServiceProxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final LogTrace logTrace;

    @Override
    public void orderItem(String itemId) {
        log.info("====== OrderServiceProxy START =====");
        log.info("====== OrderServiceProxy : call orderServiceV1.orderItem");
        logTrace.log();
        target.orderItem(itemId);
        log.info("====== OrderServiceProxy END =====");
    }
}
