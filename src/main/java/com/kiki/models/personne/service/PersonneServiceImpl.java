package com.kiki.models.personne.service;

import com.kiki.models.personne.entity.Personne;
import com.kiki.models.personne.repo.PersonneRepo;
import com.kiki.models.personne.request.SignUpRequest;
import com.kiki.models.role.entity.Role;
import com.kiki.models.role.repo.RoleRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class PersonneServiceImpl implements PersonneService {
    private final Logger LOGGER = Logger.getLogger(PersonneServiceImpl.class);

    @Inject
    PersonneRepo personneRepo;

    @Inject
    RoleRepo roleRepo;

    @Override
    public Response signUp(SignUpRequest request) {
        try {
            String email = request.getEmail();
            String role = request.getRole();
            String secretCode = request.getSecretCode();
            boolean pending = true;
            String message = "You are registered successfully ! Go back to signin.";
            Response.Status status = Response.Status.CREATED; //201

            //Check duplicated email
            Optional<Personne> personne = Optional.ofNullable(personneRepo.findByEmail(email));
            if (personne.isPresent())
                return Response.status(Response.Status.CONFLICT).entity("Failed ! Email is already in use !").build(); //409

            //Save user
            if (!Objects.equals(role, "Administrateur"))
                message = "You are registered successfully ! Wait until admin confirm your request to signin.";
            else if (!Objects.equals(secretCode, "kiki")) {
                status = Response.Status.NOT_ACCEPTABLE; //406
                message = "Invalid Secret Code !";
                pending = false;
            }

            if (status == Response.Status.CREATED) {
                Role role1 = roleRepo.findByRole(role);
                Personne newPersonne = new Personne(request, role1, pending);
                personneRepo.persist(newPersonne);
            }

            LOGGER.info("User saved sucessfully !");
            return Response.status(status).entity(message).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
