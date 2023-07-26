package com.kiki.onStart;

import com.kiki.models.role.entity.Role;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import com.kiki.models.role.service.RoleService;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Start {
    private final List<String> ROLES = new ArrayList<>(
            List.of("Administrateur", "Commercial", "Comptable", "Magasinier", "Utilisateur")
    );

    @Inject
    RoleService roleService;

    @Transactional
    void onStart(@Observes StartupEvent event) {
        for (String role : ROLES) {
            Role result = roleService.getByRole(role);
            if (result == null) roleService.create(role);
        }
    }
}
