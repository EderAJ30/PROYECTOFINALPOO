package fes.aragon.controlador;

import java.io.IOException;

//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

import fes.aragon.extras.MusicaCiclica;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PrincipalController {
	  
	@FXML
    private Button btnNivelDos;
 
    @FXML
    private Button btnNivelTres;
    
    @FXML
    private Button btnSeleccion;
    
    @FXML
    private Button btnNivelUno;

    @FXML
    private Button btnSalir;
    
    private InicioController controlador;
      
    
    private void nuevaVentana(String archivo) {
    	try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("/fes/aragon/fxml/"+archivo+".fxml"));
			Scene sceneUno = new Scene(root.load());
			Stage escenario=new Stage();
			escenario.setScene(sceneUno);
			
			
			controlador = root.getController();
			controlador.setEscena(sceneUno);
			controlador.eventosVentana();
			escenario.initModality(Modality.APPLICATION_MODAL);
			escenario.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    
    @FXML
    void IniciarNivelDos(ActionEvent event) {
//    	Object primaryStage;
		this.nuevaVentana("InicioDos");
		controlador.iniciarDos();
    }

    @FXML
    void IniciarNivelTres(ActionEvent event) {
//    	Object primaryStage;
		this.nuevaVentana("InicioTres");
		controlador.iniciarTres(); 
    }
    
    @FXML
    void IniciarNivelUno(ActionEvent event) {
//    	Object primaryStage;
		this.nuevaVentana("Inicio");
		controlador.iniciarUno(); 
    }

    @FXML
    void Salir(ActionEvent event) {
    	Platform.exit(); 
    } 
    
    
    

	public void setInicioController(InicioController inicioController) {
		
	}
	

}


