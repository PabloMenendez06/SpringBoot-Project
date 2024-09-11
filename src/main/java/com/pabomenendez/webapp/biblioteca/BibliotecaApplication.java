package com.pabomenendez.webapp.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pabomenendez.webapp.biblioteca.system.Main;

import javafx.application.Application;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		// levanta JAVAFX
		Application.launch(Main.class,args);
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
