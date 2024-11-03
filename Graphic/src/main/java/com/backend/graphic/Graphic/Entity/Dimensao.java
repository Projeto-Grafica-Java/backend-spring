package com.backend.graphic.Graphic.Entity;

import com.backend.graphic.Graphic.DTO.DimensaoCreateDTO;
import com.backend.graphic.Graphic.DTO.DimensaoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dimension")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Dimensao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double campo1;
    private Double campo2;

    @OneToOne(mappedBy = "dimensao")
    @JsonBackReference
    private OrdemServico ordemServico;

    public Dimensao(DimensaoCreateDTO dto){
        this.campo1 = dto.campo1();
        this.campo2 = dto.campo2();
    }
}
