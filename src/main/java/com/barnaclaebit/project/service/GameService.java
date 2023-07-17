package com.barnaclaebit.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barnaclaebit.project.entity.Game;
import com.barnaclaebit.project.repository.GameRepository;

@Service
public class GameService {

	
	@Autowired
	private GameRepository gameRepository;
	
	
	public List<Game> findAll(){
		
		return gameRepository.findAll(); 
	}
	
}
