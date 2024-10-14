package com.backend.graphic.Graphic.Repository;

import com.backend.graphic.Graphic.Entity.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
Ao estender JpaRepository, o OrcamentoRepository herda uma série de métodos úteis, como:

        save(Orcamento entity): Para salvar ou atualizar uma entidade no banco de dados.
        findById(Integer id): Para buscar uma entidade pelo seu ID.
        findAll(): Para retornar todas as entidades do tipo Orcamento.
        deleteById(Integer id): Para deletar uma entidade pelo seu ID.
 */

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {
    // nn são necessárias declarações adicionais, pois JpaRepository fornece métodos padrão

}
