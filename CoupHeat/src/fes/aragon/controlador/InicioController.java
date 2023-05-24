/*package fes.aragon.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import fes.aragon.extras.MusicaCiclica;
import fes.aragon.inicio.Main;
import fes.aragon.modelo.Boss;
import fes.aragon.modelo.DisparoEnemigos;
import fes.aragon.modelo.Disparos;
import fes.aragon.modelo.Escenario;
import fes.aragon.modelo.Fondo;
import fes.aragon.modelo.Personaje;
import javafx.animation.AnimationTimer;
//import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
  
public class InicioController {
	private GraphicsContext graficos;
	private Scene escena;	
	private Thread hiloFondo;
	private Thread hiloVictoria;
	private Thread hiloDerrota;
	private Fondo fondo;
	private Personaje personaje;
	private Escenario mapa;
	private Disparos disparos;
	private DisparoEnemigos disparosEnemigos;
	private Boss boss;
	private MusicaCiclica musicaVictoria=null;
	private MusicaCiclica musicaDerrota=null;
	private Personaje seMurio;
 
    @FXML
    private Canvas canvas;
    
    @FXML
    private Canvas canvasDos;
    
    @FXML
    private Pane panel;
    
   public void cargarMusicaVictoria() {
	   musicaVictoria = new MusicaCiclica("Cuphead OST - Introduction [Music]");
	   this.hiloVictoria = new Thread(musicaVictoria);
	   
	   

	   hiloVictoria.start();
   }
   public void cargarMusicaDerrota() {
	   musicaDerrota = new MusicaCiclica("Cuphead OST - Introduction [Music]");
	   this.hiloDerrota = new Thread(musicaDerrota);
	   
	   hiloDerrota.start();
   }
private void componentesIniciarUno() {
		
		graficos=canvas.getGraphicsContext2D();
		MusicaCiclica entrada = new MusicaCiclica("Floral_Fury");
		hiloFondo = new Thread(entrada);
		hiloFondo.start();
		fondo=new Fondo(0, 0,"/fes/aragon/recursos/fondo2.png" , 1);		
		personaje=new Personaje(0, 0,"/fes/aragon/recursos/Chalice.png" , 5,"/fes/aragon/recursos/personajeMuerto.png", null);
		boss=new Boss(550, 250, "/fes/aragon/recursos/Boss.png", 10, "/fes/aragon/recursos/BossMuerto.png", null);
		boss.setPersonaje(personaje);
		personaje.setBoss(boss);
		personaje.setController(this);
		boss.setController(this);		
		mapa=new Escenario(0, 0, "/fes/aragon/recursos/cuadros.png", 0);
		disparos=new Disparos(0, 0, "/fes/aragon/recursos/Shot.png", 7);
		disparosEnemigos=new DisparoEnemigos(0, 0, "/fes/aragon/recursos/weapon_wide_EX_0014.png", 9);
		personaje.setDisparos(disparos);
		boss.setDisparos(disparosEnemigos);
		personaje.verificarColision();
	}

	public void iniciarUno() {
		componentesIniciarUno();
		pintar();
		eventosTeclado();		
		ciclo();
		
	}

	  
private void componentesIniciarDos() { 
		
		graficos=canvas.getGraphicsContext2D();
		MusicaCiclica entrada = new MusicaCiclica("Cuphead OST - Introduction [Music]");
		hiloFondo = new Thread(entrada);
		hiloFondo.start();
		fondo=new Fondo(0, 0,"/fes/aragon/recursos/dos2.jpg" , 1);		
		boss=new Boss(550, 250, "/fes/aragon/recursos/mermaid_transform_0031.png ", 10, "/fes/aragon/recursos/bossMuerto2.png", null);
		personaje=new Personaje(0, 0,"/fes/aragon/recursos/mugman_plane_trans_down_0001.png" , 5,"/fes/aragon/recursos/personajeMuerto.png", null);
		personaje.setBoss(boss);
		boss.setPersonaje(personaje);
		boss.setController(this);
		personaje.setController(this);
		mapa=new Escenario(0, 0, "/fes/aragon/recursos/cuadros.png", 0);
		disparos=new Disparos(0, 0, "/fes/aragon/recursos/Shot.png", 7);
		disparosEnemigos=new DisparoEnemigos(0, 0,"/fes/aragon/recursos/bird_bullet_0001.png", 10);
		personaje.setDisparos(disparos);
		boss.setDisparos(disparosEnemigos);
		personaje.verificarColision();
		
	}
	public void iniciarDos() {
		
		componentesIniciarDos();
		pintar();
		eventosTeclado();		
		ciclo();
	}
	
private void componentesIniciarTres() {
		
		graficos=canvas.getGraphicsContext2D();
		MusicaCiclica entrada = new MusicaCiclica("Cuphead OST - Botanic Panic [Music]");
		hiloFondo = new Thread(entrada);
		hiloFondo.start();
		fondo=new Fondo(0, 0,"/fes/aragon/recursos/fondotres2.jpg" , 1);		
		boss=new Boss(550, 250, "/fes/aragon/recursos/inventor_gem_attack_blue_0009.png", 10, "/fes/aragon/recursos/bossMuerto3.png", null);
		personaje=new Personaje(0, 0,"/fes/aragon/recursos/cuphead_plane_idle_straight_0001.png" , 5,"/fes/aragon/recursos/personajeMuerto.png", null);
		personaje.setBoss(boss);
		boss.setPersonaje(personaje);
		boss.setController(this);
		personaje.setController(this);	
		mapa=new Escenario(0, 0, "/fes/aragon/recursos/cuadros.png", 0);
		disparos=new Disparos(0, 0, "/fes/aragon/recursos/Shot.png", 7);
		disparosEnemigos=new DisparoEnemigos(0, 0, "/fes/aragon/recursos/weapon_charge_loop_0008.png", 9); 
		personaje.setDisparos(disparos);
		boss.setDisparos(disparosEnemigos);
		personaje.verificarColision();
		personaje.verificarColisionDisparo();
		
	}
	public void iniciarTres() {
		componentesIniciarTres();
		pintar();
		eventosTeclado();		
		ciclo();
	}
	
	public void ciclo() {
		AnimationTimer tiempo=new AnimationTimer() {
			
			@Override
			public void handle(long tiempoActual) {
				calculosLogica();
				pintar();
				eventosVentana();
				
			}

			
		};
		tiempo.start();
	}

	
	private void pintar() {
		
		this.fondo.pintar(graficos);		
		this.mapa.pintar(graficos);
		this.personaje.pintar(graficos);
		this.boss.pintar(graficos);
		this.disparos.pintar(graficos);
		this.disparosEnemigos.pintar(graficos);
		
	}
	private void calculosLogica() {
		this.fondo.logicaCalculos();
		this.personaje.logicaCalculos();
		this.disparos.logicaCalculos();
		this.disparosEnemigos.logicaCalculos();
		this.boss.logicaCalculos();
		this.personaje.verificarColision();
		this.personaje.verificarColisionDisparo();
		this.boss.verificarColisionDisparoPersonaje();
		muerte();
		
	}
	private void eventosTeclado() {
		
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {				
				
				fondo.teclado(arg0,true);
				personaje.teclado(arg0,true);
			}			
		});
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				personaje.teclado(arg0,false);
			}
			
		});
		
	}
	
	public void eventosVentana() {
		Stage escenario=(Stage)escena.getWindow();
		escenario.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
			}
		});
		Stage escene=(Stage)escena.getWindow();
		escene.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
			
			}
			
		});
		Stage escenari=(Stage)escena.getWindow();
		escenari.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
	
			}
		});
	}
public void setEscena(Scene escena) {
	this.escena = escena;		
	
}
	public void setPrincipalController(PrincipalController principalController) {

	}
	public void muerte() {
		seMurio=personaje;
		if(seMurio.getMuerto()) {
			this.cerrar();
		}
	}
	
	private void cerrar() {
		Stage hola=(Stage) escena.getWindow();
		hola.close();
	}
}*/

package fes.aragon.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import fes.aragon.extras.MusicaCiclica;
import fes.aragon.inicio.Main;
import fes.aragon.modelo.Boss;
import fes.aragon.modelo.DisparoEnemigos;
import fes.aragon.modelo.Disparos;
import fes.aragon.modelo.Escenario;
import fes.aragon.modelo.Fondo;
import fes.aragon.modelo.Personaje;
import javafx.animation.AnimationTimer;
//import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
  
public class InicioController {
	private GraphicsContext graficos;
	private Scene escena;	
	private Thread hiloFondo;
	private Thread hiloVictoria;
	private Thread hiloDerrota;
	private Fondo fondo;
	private Personaje personaje;
	private Escenario mapa;
	private Disparos disparos;
	private DisparoEnemigos disparosEnemigos;
	private Boss boss;
	private MusicaCiclica musicaVictoria=null;
	private MusicaCiclica musicaDerrota=null;
	private Personaje seMurio;
 
    @FXML
    private Canvas canvas;
    
    @FXML
    private Canvas canvasDos;
    
    @FXML
    private Pane panel;
    
   public void cargarMusicaVictoria() {
	   musicaVictoria = new MusicaCiclica("Cuphead OST - Introduction [Music]");
	   this.hiloVictoria = new Thread(musicaVictoria);
	   
	   

	   hiloVictoria.start();
   }
   public void cargarMusicaDerrota() {
	   musicaDerrota = new MusicaCiclica("Cuphead OST - Introduction [Music]");
	   this.hiloDerrota = new Thread(musicaDerrota);
	   
	   hiloDerrota.start();
   }
private void componentesIniciarUno() {
		
		graficos=canvas.getGraphicsContext2D();
		MusicaCiclica entrada = new MusicaCiclica("Floral_Fury");
		hiloFondo = new Thread(entrada);
		hiloFondo.start();
		fondo=new Fondo(0, 0,"/fes/aragon/recursos/fondo2.png" , 1);		
		personaje=new Personaje(0, 0,"/fes/aragon/recursos/chalice_plane_idle_straight_0004.gif" , 5,"/fes/aragon/recursos/chalice_plane_ghost_0024.gif", null);
		boss=new Boss(550, 250, "/fes/aragon/recursos/blimp_idle_0021.gif", 10, "/fes/aragon/recursos/blimp_dash_fx_explode_0015.gif", null);
		boss.setPersonaje(personaje);
		personaje.setBoss(boss);
		personaje.setController(this);
		boss.setController(this);		
		mapa=new Escenario(0, 0, "/fes/aragon/recursos/cuadros.png", 0);
		disparos=new Disparos(0, 0, "/fes/aragon/recursos/Shot.png", 7);
		disparosEnemigos=new DisparoEnemigos(0, 0, "/fes/aragon/recursos/weapon_wide_bullet_a_0005.gif", 9);
		personaje.setDisparos(disparos);
		boss.setDisparos(disparosEnemigos);
		personaje.verificarColision();
	}

	public void iniciarUno() {
		componentesIniciarUno();
		pintar();
		eventosTeclado();		
		ciclo();
		
	}

	  
private void componentesIniciarDos() { 
		
		graficos=canvas.getGraphicsContext2D();
		MusicaCiclica entrada = new MusicaCiclica("Cuphead OST - Introduction [Music]");
		hiloFondo = new Thread(entrada);
		hiloFondo.start();
		fondo=new Fondo(0, 0,"/fes/aragon/recursos/dos2.jpg" , 1);		
		boss=new Boss(550, 250, "/fes/aragon/recursos/bird_mad_flap_0007.gif", 10, "/fes/aragon/recursos/stretcher_death_0016.gif", null);
		personaje=new Personaje(0, 0,"/fes/aragon/recursos/chalice_plane_idle_straight_0004.gif" , 5,"/fes/aragon/recursos/chalice_plane_ghost_0024.gif", null);
		personaje.setBoss(boss);
		boss.setPersonaje(personaje);
		boss.setController(this);
		personaje.setController(this);
		mapa=new Escenario(0, 0, "/fes/aragon/recursos/cuadros.png", 0);
		disparos=new Disparos(0, 0, "/fes/aragon/recursos/Shot.png", 7);
		disparosEnemigos=new DisparoEnemigos(0, 0,"/fes/aragon/recursos/weapon_charge_loop_0008.gif", 10);
		personaje.setDisparos(disparos);
		boss.setDisparos(disparosEnemigos);
		personaje.verificarColision();
		
	}
	public void iniciarDos() {
		
		componentesIniciarDos();
		pintar();
		eventosTeclado();		
		ciclo();
	}
	
private void componentesIniciarTres() {
		
		graficos=canvas.getGraphicsContext2D();
		MusicaCiclica entrada = new MusicaCiclica("Cuphead OST - Botanic Panic [Music]");
		hiloFondo = new Thread(entrada);
		hiloFondo.start();
		fondo=new Fondo(0, 0,"/fes/aragon/recursos/fondotres2.jpg" , 1);		
		boss=new Boss(550, 250, "/fes/aragon/recursos/inventor_gem_attack_0025.gif", 10, "/fes/aragon/recursos/inventor_death_0022.gif", null);
		personaje=new Personaje(0, 0,"/fes/aragon/recursos/chalice_plane_idle_straight_0004.gif" , 5,"/fes/aragon/recursos/chalice_plane_ghost_0024.gif", null);
		personaje.setBoss(boss);
		boss.setPersonaje(personaje);
		boss.setController(this);
		personaje.setController(this);	
		mapa=new Escenario(0, 0, "/fes/aragon/recursos/cuadros.png", 0);
		disparos=new Disparos(0, 0, "/fes/aragon/recursos/Shot.png", 7);
		disparosEnemigos=new DisparoEnemigos(0, 0, "/fes/aragon/recursos/inventor_gem_blue_bullets_0020.gif", 9); 
		personaje.setDisparos(disparos);
		boss.setDisparos(disparosEnemigos);
		personaje.verificarColision();
		personaje.verificarColisionDisparo();
		
	}
	public void iniciarTres() {
		componentesIniciarTres();
		pintar();
		eventosTeclado();		
		ciclo();
	}
	
	public void ciclo() {
		AnimationTimer tiempo=new AnimationTimer() {
			
			@Override
			public void handle(long tiempoActual) {
				calculosLogica();
				pintar();
				eventosVentana();
				
			}

			
		};
		tiempo.start();
	}

	
	private void pintar() {
		
		this.fondo.pintar(graficos);		
		this.mapa.pintar(graficos);
		this.personaje.pintar(graficos);
		this.boss.pintar(graficos);
		this.disparos.pintar(graficos);
		this.disparosEnemigos.pintar(graficos);
		
	}
	private void calculosLogica() {
		this.fondo.logicaCalculos();
		this.personaje.logicaCalculos();
		this.disparos.logicaCalculos();
		this.disparosEnemigos.logicaCalculos();
		this.boss.logicaCalculos();
		this.personaje.verificarColision();
		this.personaje.verificarColisionDisparo();
		this.boss.verificarColisionDisparoPersonaje();
		muerte();
		
	}
	private void eventosTeclado() {
		
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {				
				
				fondo.teclado(arg0,true);
				personaje.teclado(arg0,true);
			}			
		});
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				personaje.teclado(arg0,false);
			}
			
		});
		
	}
	
	public void eventosVentana() {
		Stage escenario=(Stage)escena.getWindow();
		escenario.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
			}
		});
		Stage escene=(Stage)escena.getWindow();
		escene.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
			
			}
			
		});
		Stage escenari=(Stage)escena.getWindow();
		escenari.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
	
			}
		});
	}
public void setEscena(Scene escena) {
	this.escena = escena;		
	
}
	public void setPrincipalController(PrincipalController principalController) {

	}
	public void muerte() {
		seMurio=personaje;
		if(seMurio.getMuerto()) {
			this.cerrar();
		}
	}
	
	private void cerrar() {
		Stage hola=(Stage) escena.getWindow();
		hola.close();
	}
}
