package com.springbootdata.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springbootdata.entity.User;
import com.springbootdata.repository.UserRepository;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository; //injeção q o spring faz (data repository)
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		criarRegistros();//Crio registros pela primeira vez
		
		User user1 = userRepository.findByEmail("murillopezzuol@hotmail.com");
		System.out.println(user1.getNome());//Murillo
		
		User user2 = userRepository.findByNomeIgnoreCase("gABrIeLla");
		System.out.println(user2.getNome());//Gabriella
		
	}
	
	
	//Crio registros para realizar os testes básicos de Spring Data etc...
	private void criarRegistros(){
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			createUser("Murillo", "murillopezzuol@hotmail.com");
			createUser("João","joao@gmail.com");
			createUser("Gabriella", "gabriella@gmail.com");
			createUser("Manuela", "manuela@gmail.com");
			createUser("Raul Pezzuol", "raulpezzuol@gmail.com");
			createUser("Muriçoca", "muripezzuol@gmail.com");
			createUser("NOME", "E-MAIL");
		}
	}
	
	private void createUser(String nome, String email) {
		User user = new User(nome, email);
		userRepository.save(user);//Save do spring data repository
	}

}
