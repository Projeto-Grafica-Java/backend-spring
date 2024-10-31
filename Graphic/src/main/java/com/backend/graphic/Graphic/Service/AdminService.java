package com.backend.graphic.Graphic.Service;

import com.backend.graphic.Graphic.Entity.Admin;
import com.backend.graphic.Graphic.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean isAuthorized(String username, String senha) {
        return adminRepository.findByUsername(username)
                .map(admin -> admin.getSenha().equals(senha))
                .orElse(false);
    }
}
