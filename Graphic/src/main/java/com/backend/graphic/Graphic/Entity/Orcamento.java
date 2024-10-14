package com.backend.graphic.Graphic.Entity;

import com.backend.graphic.Graphic.DTO.OrcamentoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Classe que representa uma entidade de orçamento.
 * Esta classe é mapeada para a tabela "orcamento" no banco de dados.
 */
@Entity
@Table(name = "orcamento")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Orcamento {
    /**
     * Identificador único do orçamento.
     * Este campo é a chave primária da entidade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nome do cliente associado ao orçamento.
     * Este campo é obrigatório, não pode ser nulo.
     */
    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(nullable = false)
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
     * Construtor que aceita um objeto OrcamentoDTO.
     * Este construtor é útil para criar uma nova instância de Orcamento a partir de dados transferidos por um DTO.
     *
     * @param dto O objeto OrcamentoDTO contendo os dados para o novo Orcamento.
     */
    public Orcamento(OrcamentoDTO dto) {
        this.clientName = dto.getClientName();
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.material = dto.getMaterial();
        this.paperType = dto.getPaperType();
        this.format = dto.getFormat();
        this.dimension = dto.getDimension();
        this.finishing = dto.getFinishing();
        this.quantity = dto.getQuantity();
        this.notes = dto.getNotes();
        this.artwork = dto.getArtwork();
    }
}