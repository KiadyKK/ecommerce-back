package com.kiki.models.personne.resource;

import com.kiki.models.personne.request.SignInRequest;
import com.kiki.models.personne.request.SignUpRequest;
import com.kiki.models.personne.service.PersonneService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/personne")
@ApplicationScoped
public class PersonneRessource {
    @Inject
    PersonneService personneService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("signup")
    public Response signUp(SignUpRequest request) {
        return personneService.signUp(request);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("signin")
    public Response signIn(SignInRequest request) {
        return personneService.signIn(request);
    }
}
