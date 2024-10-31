package com.backend.graphic.Graphic.Controller;

import com.backend.graphic.Graphic.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String senha = loginRequest.getSenha();

        boolean isAuthorized = adminService.isAuthorized(username, senha);

        if (isAuthorized) {
            return ResponseEntity.ok("Usuário autorizado");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos");
        }
    }

    // Tornar a classe LoginRequest estática
    public static class LoginRequest {
        private String username;
        private String senha;

        // Getters e Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }
    }
}