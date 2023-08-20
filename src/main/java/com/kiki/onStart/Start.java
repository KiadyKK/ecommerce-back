package com.kiki.onStart;

import com.kiki.common.InterfaceImplementationImpl;
import com.kiki.common.InterfaceImplementationUtil;
import com.kiki.domain.entities.Role;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import com.kiki.ports.primary.RoleService;
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
//        InterfaceImplementationUtil.interfaceImplementation = new InterfaceImplementationImpl();

        for (String role : ROLES) {
            Role result = roleService.getByRole(role);
            if (result == null) roleService.create(role);
        }
    }
}
