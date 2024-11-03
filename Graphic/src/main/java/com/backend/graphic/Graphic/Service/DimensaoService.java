package com.backend.graphic.Graphic.Service;

import com.backend.graphic.Graphic.DTO.DimensaoCreateDTO;
import com.backend.graphic.Graphic.DTO.DimensaoDTO;
import com.backend.graphic.Graphic.Entity.Dimensao;
import com.backend.graphic.Graphic.Repository.DimensaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DimensaoService {
    @Autowired
    private DimensaoRepository dimensaoRepository;

    public DimensaoDTO create(DimensaoCreateDTO data){
        Dimensao dimensao = new Dimensao(data);
        return new DimensaoDTO(dimensaoRepository.save(dimensao));
    }

    public DimensaoDTO update(DimensaoCreateDTO data, Integer id){
        Dimensao dimensao = dimensaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dimensão não encontrada"));

        if(data.campo1() != null){
            dimensao.setCampo1(data.campo1());
        }
        if(data.campo2() != null){
            dimensao.setCampo2(data.campo2());
        }

        return new DimensaoDTO(dimensaoRepository.save(dimensao));
    }
}
