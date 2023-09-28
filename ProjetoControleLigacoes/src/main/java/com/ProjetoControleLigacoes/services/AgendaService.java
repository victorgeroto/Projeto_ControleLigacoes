package com.ProjetoControleLigacoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoControleLigacoes.entities.Agenda;
import com.ProjetoControleLigacoes.repository.AgendaRepository;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;

    //construtor que recebe a dependencia
    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }
    
    public List<Agenda> buscaTodosAgendas(){
    	return agendaRepository.findAll();
    }
    
    public Agenda buscaAgendaId(Long id) {
        Optional <Agenda> agenda = agendaRepository.findById(id);
        return agenda.orElse(null);
    }
    //metodo salvar os produtos
    public Agenda SalvaAgenda(Agenda agenda) {
    	return agendaRepository.save(agenda);
    }
    public Agenda alterarAgenda(Long id, Agenda alterarAgend) {
    	Optional <Agenda> existeAgenda = agendaRepository.findById(id);
    	
    	if (existeAgenda.isPresent()) {
    		alterarAgend.setId(id);
    		return agendaRepository.save(alterarAgend);
    	}
    	return null;
    }
    public boolean apagarAgenda(Long id) {
    	Optional <Agenda> existeAgenda = agendaRepository.findById(id);
    	if (existeAgenda.isPresent()) {
    		agendaRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}

