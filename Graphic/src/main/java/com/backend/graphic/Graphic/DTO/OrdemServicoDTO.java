package com.backend.graphic.Graphic.DTO;

import com.backend.graphic.Graphic.Entity.Dimensao;
import com.backend.graphic.Graphic.Entity.OrdemServico;

public record OrdemServicoDTO(
        Integer id,
        String clientName,
        String phone,
        String email,
        String serviceType,
        Boolean printing,
        String paperType,
        String finishing,
        Integer quaintity,

        Dimensao dimensao,

        Double totalValue,
        String deliveryDate,
        String deliveryTime,
        Double entryPayment,
        Double remainingValue,
        String notes
) {
    public OrdemServicoDTO(OrdemServico data){
        this(data.getId(), data.getClientName(), data.getPhone(),
                data.getEmail(), data.getServiceType(),
                data.getPrinting(), data.getPaperType(),
                data.getFinishing(), data.getQuantity(),
                data.getDimensao(), data.getTotalValue(),
                data.getDeliveryDate(), data.getDeliveryTime(),
                data.getEntryPayment(), data.getRemainingValue(),
                data.getNotes());
    }
}
