package com.backend.graphic.Graphic.DTO;


public record OrdemServicoCreateDTO(
        String clientName,
        String phone,
        String email,
        String serviceType,
        Boolean printing,
        String paperType,
        String finishing,
        Integer quaintity,

        Integer dimensaoId,

        Double totalValue,
        String deliveryDate,
        String deliveryTime,
        Double entryPayment,
        Double remainingValue,
        String notes
){
}
