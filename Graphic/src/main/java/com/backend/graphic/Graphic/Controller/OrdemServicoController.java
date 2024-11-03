package com.backend.graphic.Graphic.Controller;

import com.backend.graphic.Graphic.DTO.OrdemServicoCreateDTO;
import com.backend.graphic.Graphic.DTO.OrdemServicoDTO;
import com.backend.graphic.Graphic.Entity.OrdemServico;
import com.backend.graphic.Graphic.Service.OrdemServicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordemservico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<OrdemServicoDTO> create(@RequestBody OrdemServicoCreateDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(ordemServicoService.create(data));
    }

    @GetMapping
    public ResponseEntity<List<OrdemServicoDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(ordemServicoService.getAll());
    }

    @PatchMapping("{id}")
    @Transactional
    public ResponseEntity<OrdemServicoDTO> update(@RequestBody OrdemServicoCreateDTO data, @PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(ordemServicoService.update(data, id));
    }
}
