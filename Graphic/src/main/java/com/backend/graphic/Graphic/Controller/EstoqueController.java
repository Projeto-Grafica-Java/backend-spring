package com.backend.graphic.Graphic.Controller;

import com.backend.graphic.Graphic.DTO.EstoqueDTO;
import com.backend.graphic.Graphic.DTO.OrcamentoDTO;
import com.backend.graphic.Graphic.Service.EstoqueService;
import com.backend.graphic.Graphic.Service.OrcamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    // Endpoint para criar um novo produto no estoque
    @PostMapping
    public ResponseEntity<EstoqueDTO> createProduto(@RequestBody EstoqueDTO produto) {
        EstoqueDTO createdProduto = estoqueService.createProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduto);
    }

    @GetMapping
    public ResponseEntity<List<EstoqueDTO>> listAllProdutos() {
        List<EstoqueDTO> estoques = estoqueService.listAllProdutos();
        return ResponseEntity.ok(estoques);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueDTO> getProdutoById(@PathVariable Integer id) {
        Optional<EstoqueDTO> estoqueDTO = estoqueService.findProdutoById(id);
        return estoqueDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id) {
        estoqueService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstoqueDTO> updateProduto(@PathVariable Integer id, @RequestBody EstoqueDTO estoqueDTO) {
        Optional<EstoqueDTO> updatedProduto = estoqueService.updateProduto(id, estoqueDTO);
        return updatedProduto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}