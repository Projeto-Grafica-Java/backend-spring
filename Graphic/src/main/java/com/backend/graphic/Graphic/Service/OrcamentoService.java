package com.backend.graphic.Graphic.Service;

import com.backend.graphic.Graphic.DTO.OrcamentoDTO;
import com.backend.graphic.Graphic.Entity.Orcamento;
import com.backend.graphic.Graphic.Repository.OrcamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrcamentoService {

    // Repositório que será utilizado para acessar os dados de orçamentos
    private final OrcamentoRepository orcamentoRepository;

    public OrcamentoService(OrcamentoRepository orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    // Método pra criar um novo orçamento
    public OrcamentoDTO createOrcamento(OrcamentoDTO orcamentoDTO) {
        // Cria uma nova instância de Orcamento a partir do DTO recebido
        Orcamento orcamento = new Orcamento(orcamentoDTO);
        // Salva o orçamento no repositório e retorna o DTO correspondente
        orcamento = orcamentoRepository.save(orcamento);
        return new OrcamentoDTO(orcamento);
    }

    // Método para listar todos os orçamentos
    public List<OrcamentoDTO> listAllOrcamentos() {
        // Obtém todos os orçamentos do repositório
        List<Orcamento> orcamentos = orcamentoRepository.findAll();
        // Converte a lista de entidades Orcamento para uma lista de OrcamentoDTO
        return orcamentos.stream().map(OrcamentoDTO::new).collect(Collectors.toList());
    }

    // Método para deletar um orçamento
    public void deleteOrcamento(Integer id) {
        orcamentoRepository.deleteById(id);
    }

    // Método para buscar orçamento por ID
    public Optional<OrcamentoDTO> findOrcamentoById(Integer id) {
        Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
        return orcamento.map(OrcamentoDTO::new);
    }

    // Método para editar um orçamento
    public Optional<OrcamentoDTO> updateOrcamento(Integer id, OrcamentoDTO orcamentoDTO) {
        // Tenta encontrar o orçamento pelo ID
        Optional<Orcamento> optionalOrcamento = orcamentoRepository.findById(id);
        // Verifica se o orçamento existe
        if (optionalOrcamento.isPresent()) {
            // Atualiza os campos do orçamento com os valores do DTO
            Orcamento orcamento = optionalOrcamento.get();
            orcamento.setClientName(orcamentoDTO.getClientName());
            orcamento.setPhone(orcamentoDTO.getPhone());
            orcamento.setEmail(orcamentoDTO.getEmail());
            orcamento.setMaterial(orcamentoDTO.getMaterial());
            orcamento.setPaperType(orcamentoDTO.getPaperType());
            orcamento.setFormat(orcamentoDTO.getFormat());
            orcamento.setDimension(orcamentoDTO.getDimension());
            orcamento.setFinishing(orcamentoDTO.getFinishing());
            orcamento.setQuantity(orcamentoDTO.getQuantity());
            orcamento.setNotes(orcamentoDTO.getNotes());
            orcamento.setArtwork(orcamentoDTO.getArtwork());
            // Salva o orçamento atualizado e retorna o DTO correspondente
            orcamento = orcamentoRepository.save(orcamento);
            return Optional.of(new OrcamentoDTO(orcamento));
        }
        // Retorna vazio se o orçamento não foi encontrado
        return Optional.empty();
    }
}
