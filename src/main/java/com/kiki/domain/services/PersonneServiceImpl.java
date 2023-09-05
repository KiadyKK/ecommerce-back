package com.kiki.domain.services;

import com.kiki.common.InterfaceImplementation;
import com.kiki.domain.dto.personne.PersonneDto1;
import com.kiki.domain.entities.Personne;
import com.kiki.domain.entities.Role;
import com.kiki.domain.mappers.PersonneMapper;
import com.kiki.domain.requests.personne.SignInRequest;
import com.kiki.domain.requests.personne.SignUpRequest;
import com.kiki.ports.primary.PersonneService;
import com.kiki.ports.secondary.PersonneRepo;
import com.kiki.ports.secondary.RoleRepo;
import io.smallrye.jwt.build.Jwt;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.factory.Mappers;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class PersonneServiceImpl implements PersonneService {
    @Inject
    Logger LOGGER;

    private final PersonneMapper personneMapper = Mappers.getMapper(PersonneMapper.class);

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
            boolean pending = false;
            String message = "You are registered successfully ! Go back to signin.";
            Response.Status status = Response.Status.CREATED; //201

            //Check duplicated email
            Optional<Personne> personne = Optional.ofNullable(personneRepo.findByEmail(email));
            if (personne.isPresent())
                return Response.status(Response.Status.CONFLICT).entity("Failed ! Email is already in use !").build(); //409

            //Save user
            if (!role.equals("Administrateur")) {
                message = "You are registered successfully ! Wait until admin confirm your request to signin.";
                pending = true;
            } else if (!Objects.equals(secretCode, "kiki")) {
                status = Response.Status.NOT_ACCEPTABLE; //406
                message = "Invalid Secret Code !";
            }

            if (status == Response.Status.CREATED) {
                Role role1 = roleRepo.findByRole(role);
                Personne newPersonne = new Personne(request, role1, pending);
                personneRepo.persist(newPersonne);
                LOGGER.info("User saved sucessfully !");
            }

            return Response.status(status).entity(message).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @Override
    public Response signIn(@NotNull SignInRequest request) {
        try {
            //Check username
            Personne personne = personneRepo.findByUsername(request.getUsername());
            Optional<Personne> optional = Optional.ofNullable(personne);
            if (optional.isEmpty()) return Response.status(Response.Status.NOT_FOUND).entity("User Not found.").build();

            //check mdp
            boolean checkMdp = BCrypt.checkpw(request.getMdp(), personne.getMdp());
            if (!checkMdp) return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Password !").build();

            //return token
            return generateJwt(personne);
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    private Response generateJwt(Personne personne) {
        String token = Jwt.issuer("ecommerce")
                .subject("ecommerce")
                .groups(personne.getRole().getRole())
                .expiresAt(System.currentTimeMillis() + 3600)
                .sign();

        PersonneDto1 personneDto1 = personneMapper.entityToDto1(personne);
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("personne", personneDto1).put("token", "Bearer " + token);

        LOGGER.info("User logged successfully");
        return Response.ok(jsonObject).build();
    }

    @Override
    public List<PersonneDto1> getAll(String username, String searchRole) {
        List<Personne> personnes = personneRepo.listByUsernameAndRole(username, searchRole);

        LOGGER.info("Get All personne, size ==> " + personnes.size());
        return personnes.stream().map(personneMapper::entityToDto1).toList();
    }

    @Override
    public int updatePending(long id) {
        personneRepo.updatePending(id);

        LOGGER.info("Update pending successfully !");
        return (int) id;
    }

    @Override
    public int deletePersonne(long id) {
        personneRepo.deletePersonne(id);

        LOGGER.info("Delete person successfully !");
        return (int) id;
    }
}
