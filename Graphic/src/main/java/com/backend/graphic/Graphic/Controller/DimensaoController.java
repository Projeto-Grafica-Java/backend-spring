package com.backend.graphic.Graphic.Controller;

import com.backend.graphic.Graphic.DTO.DimensaoCreateDTO;
import com.backend.graphic.Graphic.DTO.DimensaoDTO;
import com.backend.graphic.Graphic.Service.DimensaoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dimensao")
public class DimensaoController {

    @Autowired
    private DimensaoService dimensaoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DimensaoDTO> create(@RequestBody DimensaoCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(dimensaoService.create(dto));
    }

    @PatchMapping("{id}")
    @Transactional
    public ResponseEntity<DimensaoDTO> update(@RequestBody DimensaoCreateDTO dto, @PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(dimensaoService.update(dto, id));
    }

}
