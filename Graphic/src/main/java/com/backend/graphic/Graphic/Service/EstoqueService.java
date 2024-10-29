package com.backend.graphic.Graphic.Service;


import com.backend.graphic.Graphic.DTO.EstoqueDTO;
import com.backend.graphic.Graphic.DTO.OrcamentoDTO;
import com.backend.graphic.Graphic.Entity.Estoque;
import com.backend.graphic.Graphic.Entity.Orcamento;
import com.backend.graphic.Graphic.Repository.EstoqueRepository;
import com.backend.graphic.Graphic.Repository.OrcamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public EstoqueDTO createProduto(EstoqueDTO estoqueDTO) {
        Estoque estoque = new Estoque(estoqueDTO);
        estoque = estoqueRepository.save(estoque);
        return new EstoqueDTO(estoque);
    }

    public List<EstoqueDTO> listAllProdutos() {
        List<Estoque> estoques = estoqueRepository.findAll();
        return estoques.stream().map(EstoqueDTO::new).collect(Collectors.toList());
    }

    public Optional<EstoqueDTO> findProdutoById(Integer id) {
        Optional<Estoque> estoque = estoqueRepository.findById(id);
        return estoque.map(EstoqueDTO::new);
    }

    public void deleteProduto(Integer id) {
        estoqueRepository.deleteById(id);
    }

    public Optional<EstoqueDTO> updateProduto(Integer id, EstoqueDTO estoqueDTO) {
        Optional<Estoque> optionalEstoque = estoqueRepository.findById(id);
        if (optionalEstoque.isPresent()) {
            Estoque estoque = optionalEstoque.get();

            estoque.setProductName(estoqueDTO.getProductName());
            estoque.setCodigo(estoqueDTO.getCodigo());
            estoque.setMedidas(estoqueDTO.getMedidas());
            estoque.setVendas(estoqueDTO.getVendas());
            estoque.setQuantidade(estoqueDTO.getQuantidade());
            estoque.setData(estoqueDTO.getData());

            estoque = estoqueRepository.save(estoque);
            return Optional.of(new EstoqueDTO(estoque));
        }
        return Optional.empty();
    }
}