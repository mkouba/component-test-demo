
package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class MyServiceTest {

    @Inject
    MyService myService;

    @Test
    public void testPing() {
        // What if want to test different configurations
        // E.g. config property & OtherService implementation?
        // 1. Test profiles + CDI alternatives
        // 2. @Mock OtherService - a "global" test CDI alternative
        // 3. @InjectMock + Mockito
        assertEquals("pong", myService.ping());
    }

}