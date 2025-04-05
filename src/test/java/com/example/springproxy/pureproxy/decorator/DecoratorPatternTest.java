package com.example.springproxy.pureproxy.decorator;

import com.example.springproxy.pureproxy.decorator.code.DecoratorPatternClient;
import com.example.springproxy.pureproxy.decorator.code.MessageDecorator;
import com.example.springproxy.pureproxy.decorator.code.RealComponent;
import com.example.springproxy.pureproxy.decorator.code.TimeDecorator;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    public void test() {
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    public void decoratorTest() {
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(messageDecorator);
        decoratorPatternClient.execute();
    }

    @Test
    public void decoratorTest2() {
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(timeDecorator);
        decoratorPatternClient.execute();
    }
}
