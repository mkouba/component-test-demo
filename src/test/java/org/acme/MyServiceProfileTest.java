package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.Set;

import org.acme.MyServiceProfileTest.MyTestProfile;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.QuarkusTestProfile;
import io.quarkus.test.junit.TestProfile;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;

@QuarkusTest
@TestProfile(MyTestProfile.class)
public class MyServiceProfileTest {

    @Inject
    MyService myService;

    @Test
    public void testPing() {
        assertEquals("mockmock", myService.ping());
    }

    public static class MyTestProfile implements QuarkusTestProfile {

        @Override
        public Set<Class<?>> getEnabledAlternatives() {
            return Set.of(MockOtherService.class);
        }

        @Override
        public Map<String, String> getConfigOverrides() {
            return Map.of("count", "2");
        }

    }

    @Alternative
    @ApplicationScoped
    public static class MockOtherService extends OtherService {

        @Override
        public String ping() {
            return "mock";
        }

    }

}
