package org.acme.health;

import io.smallrye.health.checks.UrlHealthCheck;
import jakarta.ws.rs.HttpMethod;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class OwnersDocumentUrlCheck {
    @Readiness
    HealthCheck urlCheck() {
        return new UrlHealthCheck("http://localhost:8080/ownersdocument")
                .requestMethod(HttpMethod.GET).name("Check owner's document url");
    }
}
