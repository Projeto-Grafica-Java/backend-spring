package com.backend.graphic.Graphic.DTO;

import com.backend.graphic.Graphic.Entity.Admin;
import com.backend.graphic.Graphic.Entity.Estoque;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {
    private String username;
    private String senha;

    public UserDTO(Admin admin) {
        this.username = admin.getUsername();
        this.senha = admin.getSenha();
    }
    public UserDTO() {}

}