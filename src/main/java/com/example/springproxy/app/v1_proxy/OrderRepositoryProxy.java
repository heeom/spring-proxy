package com.example.springproxy.app.v1_proxy;

import com.example.springproxy.app.v1.OrderRepositoryV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderRepositoryProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;

    @Override
    public void save(String itemId) {
        log.info("====== OrderRepositoryProxy START =====");
        log.info("====== OrderRepositoryProxy : call orderRepositoryV1.save");
        target.save(itemId);
        log.info("====== OrderRepositoryProxy END =====");
    }
}
