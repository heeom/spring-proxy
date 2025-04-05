package com.example.springproxy.pureproxy.proxy;

import com.example.springproxy.pureproxy.proxy.code.CacheProxy;
import com.example.springproxy.pureproxy.proxy.code.ProxyPatternClient;
import com.example.springproxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void proxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(new CacheProxy(realSubject));
        client.execute();
        client.execute();
        client.execute();
    }
}
