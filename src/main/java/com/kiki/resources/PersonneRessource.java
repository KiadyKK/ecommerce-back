package com.kiki.resources;

import com.kiki.adaptors.services.PersonneAdaptor;
import com.kiki.common.InterfaceImplementationImpl;
import com.kiki.common.InterfaceImplementationUtil;
import com.kiki.domain.requests.personne.SignInRequest;
import com.kiki.domain.requests.personne.SignUpRequest;
import com.kiki.domain.services.PersonneServiceImpl;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/personne")
@ApplicationScoped
public class PersonneRessource {
    @Inject
    PersonneAdaptor personneAdaptor;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("signup")
    public Response signUp(SignUpRequest request) {
        return personneAdaptor.signUp(request);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("signin")
    public Response signIn(SignInRequest request) {
        return personneAdaptor.signIn(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAll(@QueryParam("username") String username, @QueryParam("role") String role) {
        return personneAdaptor.getAll(username, role);
    }
}
