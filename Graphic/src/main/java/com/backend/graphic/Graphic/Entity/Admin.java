package com.backend.graphic.Graphic.Entity;

import com.backend.graphic.Graphic.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, length = 15)
    private String senha;

    public Admin(UserDTO dto) {
        this.username = dto.getUsername();
        this.senha = dto.getSenha();
    }
}