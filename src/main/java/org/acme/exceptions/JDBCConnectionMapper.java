package org.acme.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.hibernate.exception.JDBCConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Provider
public class JDBCConnectionMapper implements ExceptionMapper<Exception> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Response toResponse(Exception e) {
        if (e instanceof JDBCConnectionException) {
            this.logger.error("Ошибка подключения к БД", e);
            return Response.status(503).build();
        } else {
            this.logger.error("Непредвиденная ошибка работы сервиса: ", e);
            return Response.status(500).type("application/json").build();
        }


    }
}
