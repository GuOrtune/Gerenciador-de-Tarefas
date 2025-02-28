package com.tarefas.gerenciador_tarefas2.service;

import com.tarefas.gerenciador_tarefas2.model.Tarefa;
import com.tarefas.gerenciador_tarefas2.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    // Criar ou atualizar uma tarefa
    public Tarefa salvarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // Buscar todas as tarefas
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    // Buscar uma tarefa por id
    public Optional<Tarefa> buscarTarefaPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    // Deletar uma tarefa
    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }

    // Atualizar o status da tarefa (concluída ou não)
    public Tarefa atualizarTarefa(Long id, boolean concluida) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);
        if (tarefaExistente.isPresent()) {
            Tarefa tarefa = tarefaExistente.get();
            tarefa.setConcluida(concluida);
            return tarefaRepository.save(tarefa);
        }
        return null;
    }
}
