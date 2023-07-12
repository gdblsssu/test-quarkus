package org.acme.health;

import io.smallrye.health.checks.UrlHealthCheck;
import jakarta.ws.rs.HttpMethod;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;

public class CarUrlCheck {
    @Readiness
    HealthCheck urlCheck() {
        return new UrlHealthCheck("http://localhost:8080/cars").requestMethod(HttpMethod.GET).name("Check car url");
    }
}
