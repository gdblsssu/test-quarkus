package org.acme.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.jboss.logging.annotations.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Liveness
public class DBCheck implements HealthCheck {

    @ConfigProperty(name = "quarkus.datasource.jdbc.url")
    String url;
    @ConfigProperty(name = "quarkus.datasource.username")
    String username;
    @ConfigProperty(name = "quarkus.datasource.password")
    String password;
    @Override
    public HealthCheckResponse call() {

        if(isConnect()){
            return HealthCheckResponse.up("DB is connected");
        } else {
            return HealthCheckResponse.down("No connection to db");
        }
    }

    private boolean isConnect(){
        try (Connection conn = DriverManager.getConnection(
                url, username, password)) {

            if (conn != null) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
