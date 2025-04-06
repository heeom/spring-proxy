package com.example.springproxy.app.v1_proxy;

import com.example.springproxy.app.common.LogTrace;
import com.example.springproxy.app.v1.OrderRepositoryV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderRepositoryProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        log.info("====== OrderRepositoryProxy START =====");
        log.info("====== OrderRepositoryProxy : call orderRepositoryV1.save");
        logTrace.log();
        target.save(itemId);
        log.info("====== OrderRepositoryProxy END =====");
    }
}
