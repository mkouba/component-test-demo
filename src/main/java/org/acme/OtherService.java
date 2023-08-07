package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OtherService {

    public String ping() {
        return "pong";
    }
}
