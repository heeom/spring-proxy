package com.example.springproxy.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceInterfaceImpl implements ServiceInterface {


    @Override
    public void save() {
        log.info("save 호출");
    }

    @Override
    public void find() {
        log.info("find 호출");
    }
}
