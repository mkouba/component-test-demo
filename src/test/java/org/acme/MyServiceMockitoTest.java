package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class MyServiceMockitoTest {

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

}
