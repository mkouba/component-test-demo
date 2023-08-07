package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.InjectMock;
import io.quarkus.test.component.QuarkusComponentTest;
import jakarta.inject.Inject;

@QuarkusComponentTest
public class MyServiceComponentTest {

    @Inject
    MyService myService;

    @InjectMock
    OtherService otherService;

    @Test
    public void testPing() {
        Mockito.when(otherService.ping()).thenReturn("pong");
        assertEquals("pong", myService.ping());

        Mockito.when(otherService.ping()).thenReturn("foo");
        assertEquals("foo", myService.ping());
    }

    // ================================================================
    // WORKAROUND for https://github.com/quarkusio/quarkus/issues/35199
    // ================================================================
    static String countSystemProperty = null;

    @BeforeAll
    static void beforeAll() {
        countSystemProperty = System.getProperty("count");
        if (countSystemProperty != null) {
            System.setProperty("count", "1");
        }
    }

    @AfterAll
    static void afterAll() {
        if (countSystemProperty != null) {
            System.setProperty("count", countSystemProperty);
            countSystemProperty = null;
        }
    }
}
