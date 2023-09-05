package com.kiki.adaptors.services;

import com.kiki.domain.dto.personne.PersonneDto1;
import com.kiki.domain.requests.personne.SignInRequest;
import com.kiki.domain.requests.personne.SignUpRequest;
import com.kiki.ports.primary.PersonneService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@ApplicationScoped
public class PersonneAdaptor {
    @Inject
    Logger LOGGER;

    @Inject
    PersonneService personneService;

    public Response signUp(SignUpRequest request) {
        return personneService.signUp(request);
    }

    public Response signIn(@NotNull SignInRequest request) {
        return personneService.signIn(request);
    }

    public Response getAll(String username, String role) {
        try {
            List<PersonneDto1> personneDto1s = personneService.getAll(username, role);
            return Response.ok(personneDto1s).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    public Response updatePending(long id) {
        try {
            int res = personneService.updatePending(id);
            return Response.ok(res).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    public Response deletePersonne(long id) {
        try {
            int res = personneService.deletePersonne(id);
            return Response.ok(res).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}
