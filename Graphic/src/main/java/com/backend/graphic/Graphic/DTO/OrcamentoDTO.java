package com.backend.graphic.Graphic.DTO;

import com.backend.graphic.Graphic.Entity.Orcamento;
import lombok.Getter;
import lombok.Setter;


/**
* Essas anotações fazem com que o Lombok gere automaticamente os
* métodos de acesso (getters)
* e de modificação (setters)
* para todos os atributos da classe
 */
@Getter
@Setter
public class OrcamentoDTO {
    private String clientName;
    private String phone;
    private String email;
    private String material;
    private String paperType;
    private String format;
    private String dimension;
    private String finishing;
    private int quantity;
    private String notes;
    private String artwork;

    /**
     * Construtor que cria um OrcamentoDTO a partir de um objeto Orcamento.
     *
     * @param orcamento Objeto Orcamento que será convertido em DTO.
     */
    public OrcamentoDTO(Orcamento orcamento) {
        this.clientName = orcamento.getClientName();
        this.phone = orcamento.getPhone();
        this.email = orcamento.getEmail();
        this.material = orcamento.getMaterial();
        this.paperType = orcamento.getPaperType();
        this.format = orcamento.getFormat();
        this.dimension = orcamento.getDimension();
        this.finishing = orcamento.getFinishing();
        this.quantity = orcamento.getQuantity();
        this.notes = orcamento.getNotes();
        this.artwork = orcamento.getArtwork();
    }

}

//public OrcamentoDTO() {}
