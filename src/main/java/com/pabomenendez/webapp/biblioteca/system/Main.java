package com.pabomenendez.webapp.biblioteca.system;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.pabomenendez.webapp.biblioteca.BibliotecaApplication;
import com.pabomenendez.webapp.biblioteca.controller.FXController.IndexController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    // atributos
     private ConfigurableApplicationContext applicationContext;
    private Stage stage;
    private Scene scene;

    // se ejecuta cada vez que yo instancie la clase MAIN
    @Override
    public void init(){
        this.applicationContext = new SpringApplicationBuilder(BibliotecaApplication.class).run();
    }

//Se ejecuta al iniciar la aplicación de javaFX
    @Override
    public void start (Stage primaryStąge )throws Exception {
        this.stage = primaryStąge;
        stage.setTitle("Biblioteca Springboot");
        // carga la escnea principal
        indexView();
        stage.show();

        }

        public Initializable cambiarEscena(String fxmlName, int width, int height)throws IOException{
            Initializable initializable = null;
            FXMLLoader loader = new FXMLLoader();

            loader.setControllerFactory(applicationContext::getBean);
            InputStream archivo = Main.class.getResourceAsStream("/templates/" + fxmlName);
            loader.setBuilderFactory(new JavaFXBuilderFactory());
            loader.setLocation(Main.class.getResource("/templates/" + fxmlName));

            scene = new Scene((AnchorPane)loader.load(archivo), width, height);
            stage.setScene(scene);
            stage.sizeToScene();
            return initializable;
        }

        // mostrar index
        public void indexView(){
            try {
                IndexController indexView = (IndexController)cambiarEscena("index.fxml", 600, 400);
                indexView.setStage(this);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    
}
