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
		
		User user2 = userRepository.findByNomeQualquerCoisa("Raul Pezzuol");
		System.out.println(user2.getNome());//Raul Pezzuol
		
		User user3 = userRepository.findByNomeIgnoreCase("gABrIeLla");
		System.out.println(user3.getNome());//Gabriella
		
		List<User> user4 = userRepository.findByNomeIgnoreCaseLike("m");
		user4.stream()
		.forEach(u -> System.out.print(u.getNome() + " - "));//Murillo - Manuela - Muriçoca - NOME
		
		System.out.println();
		List<User> user5 = userRepository.findByIdadeGreaterThanEqual(50);
		user5.stream()
		.forEach(u -> System.out.print(u.getNome() + " - "));//NOME - José
	}
	
	
	//Crio registros para realizar os testes básicos de Spring Data etc...
	private void criarRegistros(){
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			createUser("Murillo", "murillopezzuol@hotmail.com",21);
			createUser("João","joao@gmail.com", 15);
			createUser("Gabriella", "gabriella@gmail.com",19);
			createUser("Manuela", "manuela@gmail.com",6);
			createUser("Raul Pezzuol", "raulpezzuol@gmail.com",11);
			createUser("Muriçoca", "muripezzuol@gmail.com",30);
			createUser("NOME", "E-MAIL",50);
			createUser("Sandro", "sandro@hotmail.com", 21);
			createUser("José", "jose@hotmail.com",55);
		}
	}
	
	private void createUser(String nome, String email, int idade) {
		User user = new User(nome, email, idade);
		userRepository.save(user);//Save do spring data repository
	}

}
