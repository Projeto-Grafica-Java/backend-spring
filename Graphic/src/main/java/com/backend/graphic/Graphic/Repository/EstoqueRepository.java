package com.backend.graphic.Graphic.Repository;

import com.backend.graphic.Graphic.Entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

}
