package com.example.springproxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InterfaceAImpl implements InterfaceA {

    @Override
    public String call() {
        log.info("A 호출");
        return "A";
    }
}
