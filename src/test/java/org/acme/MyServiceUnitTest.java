package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceUnitTest {

    @Test
    public void testPing() {
        // ----------------------------------
        // Construct the component under test
        MyService myService = new MyService();
        // What if the test class has a different package?
        // 1. Use constructor/setter injection
        // 2. Use reflection...
        OtherService otherService = Mockito.mock(OtherService.class);
        myService.other = otherService;
        myService.count = 1;
        // ----------------------------------

        Mockito.when(otherService.ping()).thenReturn("pong");
        assertEquals("pong", myService.ping());

        Mockito.when(otherService.ping()).thenReturn("foo");
        assertEquals("foo", myService.ping());
    }

}
