package com.example.springproxy.pureproxy.decorator;

import com.example.springproxy.pureproxy.decorator.code.DecoratorPatternClient;
import com.example.springproxy.pureproxy.decorator.code.RealComponent;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    public void test() {
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }
}
