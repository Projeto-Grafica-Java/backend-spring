package com.backend.graphic.Graphic.Entity;

import com.backend.graphic.Graphic.DTO.EstoqueDTO;
import com.backend.graphic.Graphic.DTO.OrcamentoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "estoque")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(nullable = false)
    private String codigo;
    private String medidas;
    private int vendas;
    private int quantidade;
    private String data;

    public Estoque(EstoqueDTO dto) {
        this.productName = dto.getProductName();
        this.codigo = dto.getCodigo();
        this.medidas = dto.getMedidas();
        this.vendas = dto.getVendas();
        this.quantidade = dto.getQuantidade();
        this.data = dto.getData();
    }
}