package com.tarefas.gerenciador_tarefas2.repository;

import com.tarefas.gerenciador_tarefas2.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
