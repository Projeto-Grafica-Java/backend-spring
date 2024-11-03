package com.backend.graphic.Graphic.DTO;

import com.backend.graphic.Graphic.Entity.Dimensao;

public record DimensaoDTO(
        Integer id,
        Double campo1,
        Double campo2
) {
    public DimensaoDTO(Dimensao dimensao){
        this(dimensao.getId(), dimensao.getCampo1(), dimensao.getCampo2());
    }
}
