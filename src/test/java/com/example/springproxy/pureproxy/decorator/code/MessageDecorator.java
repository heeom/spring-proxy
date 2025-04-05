package com.example.springproxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {

    private RealComponent realComponent;

    public MessageDecorator(RealComponent realComponent) {
        this.realComponent = realComponent;
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");
        String operation = realComponent.operation();
        String decoResult = "*****" + operation + "*****";
        log.info("MessageDecorator Before : {}, After : {}", operation, decoResult);
        return decoResult;
    }
}
