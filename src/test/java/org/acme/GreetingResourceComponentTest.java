package org.acme;

import io.quarkus.test.InjectMock;
import io.quarkus.test.component.QuarkusComponentTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusComponentTest(MyService.class)
public class GreetingResourceComponentTest {

    @Inject
    GreetingResource greetingResource;

    @InjectMock
    OtherService otherService;

    @Test
    public void testHelloEndpoint() {
        Mockito.when(otherService.ping()).thenReturn("Insights!");
        assertEquals("Insights!", greetingResource.hello());
    }

}