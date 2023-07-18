package org.acme.health;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.jboss.logging.annotations.Properties;

import java.awt.geom.QuadCurve2D;
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

    @Inject
    EntityManager entityManager;

    @Override
    public HealthCheckResponse call() {

        try{
            Query checkCon = entityManager.createQuery("select 1");
            checkCon.getResultList();
            return HealthCheckResponse.up("DB is connected");
        } catch (Exception e){
            return HealthCheckResponse.down("Database connection error");
        }
    }



}
