package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MyService {

    @Inject
    OtherService other;

    @ConfigProperty(name = "count", defaultValue = "1")
    int count;

    public String ping() {
        return other.ping().repeat(count);
    }
}