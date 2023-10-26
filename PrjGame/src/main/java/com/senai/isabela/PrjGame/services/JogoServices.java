package com.senai.isabela.PrjGame.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.isabela.PrjGame.entities.Jogo;
import com.senai.isabela.PrjGame.repositories.JogoRepository;



@Service
public class JogoServices {
	private final JogoRepository jogorepository;
	
	@Autowired
	public JogoServices(JogoRepository jogoRepository) {
		this.jogorepository = jogoRepository;
	}
	
	public Jogo saveJogo (Jogo jogo) {
		return jogorepository.save(jogo);
	}
	
	public Jogo getJogoById(Long id) {
		return jogorepository.findById(id).orElse(null);
	}
	
	public List<Jogo> getAllJogo(){
		return jogorepository.findAll();
	}
	
	public void deleteJogo(Long id) {
		jogorepository.deleteById(id);
	}
	public Jogo updateJogo(Long id, Jogo novoJogo) {
        Optional<Jogo> jogoOptional = jogorepository.findById(id);
        if (jogoOptional.isPresent()) {
        	Jogo jogoExistente = jogoOptional.get();
           	jogoExistente.setName(novoJogo.getName());
        	jogoExistente.setPlataform(novoJogo.getPlataform());          
            return jogorepository.save(jogoExistente); 
        } else {
            return null; 
        }
    }
	
	

}
