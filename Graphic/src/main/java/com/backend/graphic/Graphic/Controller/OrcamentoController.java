package com.backend.graphic.Graphic.Controller;

import com.backend.graphic.Graphic.DTO.OrcamentoDTO;
import com.backend.graphic.Graphic.Service.OrcamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orcamentos") // Mapeia a URL base
public class OrcamentoController {

    private final OrcamentoService orcamentoService;

    // Construtor que injeta o OrcamentoService através da injeção de dependência
    public OrcamentoController(OrcamentoService orcamentoService){
        this.orcamentoService = orcamentoService;
    }

    // Endpoint para criar um novo orçamento
    @PostMapping
    public ResponseEntity<OrcamentoDTO> createOrcamento(@RequestBody OrcamentoDTO orcamento){
        OrcamentoDTO createdOrcamento = orcamentoService.createOrcamento(orcamento);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdOrcamento);
    }

    @GetMapping
    public ResponseEntity<List<OrcamentoDTO>> listAllOrcamentos() {
        List<OrcamentoDTO> orcamentos = orcamentoService.listAllOrcamentos();
        return ResponseEntity.ok(orcamentos);
    }

    // Endpoint para deletar um orçamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrcamento(@PathVariable Integer id) {
        orcamentoService.deleteOrcamento(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para listar orçamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoDTO> getOrcamentoById(@PathVariable Integer id) {
        Optional<OrcamentoDTO> orcamentoDTO = orcamentoService.findOrcamentoById(id);
        return orcamentoDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint para editar um orçamento
    @PutMapping("/{id}")
    public ResponseEntity<OrcamentoDTO> updateOrcamento(@PathVariable Integer id, @RequestBody OrcamentoDTO orcamentoDTO) {
        Optional<OrcamentoDTO> updatedOrcamento = orcamentoService.updateOrcamento(id, orcamentoDTO);
        return updatedOrcamento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}