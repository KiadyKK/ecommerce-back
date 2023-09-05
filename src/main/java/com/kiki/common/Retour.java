package com.kiki.common;

import com.kiki.adaptors.services.AgenceAdaptor;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

public class Retour {
    private final Logger LOGGER = Logger.getLogger(Retour.class);

    private String message;

    private final Response.Status status;

    public Retour(String entity, Response.Status status) {
        switch (status) {
            case CONFLICT -> this.message = " already exists.";
            case CREATED -> this.message = " created successfully !";
            case INTERNAL_SERVER_ERROR -> this.message = " internal server error.";
            default -> {
            }
        }
        this.message = entity + this.message;
        this.status = status;
    }

    public Response getResponse() {
        LOGGER.info(this.message);
        return Response.status(status).entity(this.message).build();
    }
}
