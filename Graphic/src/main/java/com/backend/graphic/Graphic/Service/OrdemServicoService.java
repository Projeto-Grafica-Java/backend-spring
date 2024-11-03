package com.backend.graphic.Graphic.Service;

import com.backend.graphic.Graphic.DTO.OrdemServicoCreateDTO;
import com.backend.graphic.Graphic.DTO.OrdemServicoDTO;
import com.backend.graphic.Graphic.Entity.Dimensao;
import com.backend.graphic.Graphic.Entity.OrdemServico;
import com.backend.graphic.Graphic.Repository.DimensaoRepository;
import com.backend.graphic.Graphic.Repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    @Autowired
    private DimensaoRepository dimensaoRepository;

    public OrdemServicoDTO create(OrdemServicoCreateDTO data){
        Dimensao dimensao = dimensaoRepository.findById(data.dimensaoId())
                .orElseThrow(() -> new RuntimeException("Dimensão não encontrada!"));

        OrdemServico ordemServico = new OrdemServico(data);

        ordemServico.setDimensao(dimensao);
        dimensao.setOrdemServico(ordemServico);

        return new OrdemServicoDTO(ordemServicoRepository.save(ordemServico));
    }

    public List<OrdemServicoDTO> getAll(){
        return ordemServicoRepository.findAll().stream().map(OrdemServicoDTO::new).toList();
    }

    public OrdemServicoDTO update(OrdemServicoCreateDTO data, Integer id){
        OrdemServico ordemServico = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem não encontrada"));

        if (data.clientName() != null) {
            ordemServico.setClientName(data.clientName());
        }

        if (data.phone() != null) {
            ordemServico.setPhone(data.phone());
        }

        if (data.email() != null) {
            ordemServico.setEmail(data.email());
        }

        if (data.serviceType() != null) {
            ordemServico.setServiceType(data.serviceType());
        }

        if (data.printing() != null) {
            ordemServico.setPrinting(data.printing());
        }

        if (data.paperType() != null) {
            ordemServico.setPaperType(data.paperType());
        }

        if (data.finishing() != null) {
            ordemServico.setFinishing(data.finishing());
        }

        if (data.quaintity() != null) {
            ordemServico.setQuantity(data.quaintity());
        }

        if (data.totalValue() != null) {
            ordemServico.setTotalValue(data.totalValue());
        }

        if (data.deliveryDate() != null) {
            ordemServico.setDeliveryDate(data.deliveryDate());
        }

        if (data.deliveryTime() != null) {
            ordemServico.setDeliveryTime(data.deliveryTime());
        }

        if (data.entryPayment() != null) {
            ordemServico.setEntryPayment(data.entryPayment());
        }

        if (data.remainingValue() != null) {
            ordemServico.setRemainingValue(data.remainingValue());
        }

        if (data.notes() != null) {
            ordemServico.setNotes(data.notes());
        }

        return new OrdemServicoDTO(ordemServicoRepository.save(ordemServico));
    }
}
