package com.backend.graphic.Graphic.Entity;

import com.backend.graphic.Graphic.DTO.OrdemServicoCreateDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ordem_servico")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String clientName;
    private String phone;
    private String email;
    private String serviceType;
    private Boolean printing;
    private String paperType;
    private String finishing;
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "dimension")
    @JsonManagedReference
    private Dimensao dimensao;

    private Double totalValue;
    private String deliveryDate;
    private String deliveryTime;
    private Double entryPayment;
    private Double remainingValue;
    private String notes;

    public OrdemServico(OrdemServicoCreateDTO dto){
        this.clientName = dto.clientName();
        this.phone = dto.phone();
        this.email = dto.email();
        this.serviceType = dto.serviceType();
        this.printing = dto.printing();
        this.paperType = dto.paperType();
        this.finishing = dto.finishing();
        this.quantity = dto.quaintity();
        this.totalValue = dto.totalValue();
        this.deliveryDate = dto.deliveryDate();
        this.deliveryTime = dto.deliveryTime();
        this.entryPayment = dto.entryPayment();;
        this.remainingValue = dto.remainingValue();
        this.notes = dto.notes();
    }
}
