package com.backend.graphic.Graphic.DTO;

import com.backend.graphic.Graphic.Entity.Estoque;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EstoqueDTO {
    private String productName;
    private String codigo;
    private String medidas;
    private int vendas;
    private int quantidade;
    private String data;

    public EstoqueDTO(Estoque estoque) {
        this.productName = estoque.getProductName();
        this.codigo = estoque.getCodigo();
        this.medidas = estoque.getMedidas();
        this.vendas = estoque.getVendas();
        this.quantidade = estoque.getQuantidade();
        this.data = estoque.getData();
    }
    public EstoqueDTO() {}

}