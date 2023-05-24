package fes.aragon.modelo;
import java.util.ArrayList;

import fes.aragon.controlador.InicioController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Personaje extends ComponentesJuego{
	private int gravedad =0;
	private boolean desciende =true;
	private boolean salto=false;
	public static Rectangle rectangulo;
	private Rectangle recPersonajeDerrotado;
	private ArrayList<Rectangle> disparosCol=new ArrayList<>();
	public static Rectangle rectDerecha;
	private Disparos disparos;
	private Image imagen;
	private Image personajeDerrotado;
	private Boss enemigos;
	private Rectangle colPersonaje;
	private Rectangle colBoss;
	private boolean derecha =false;
	private boolean izquierda = false;
	private boolean arriba=false;
	private boolean abajo =false;
	private boolean disparo=false;
	private int vida=3;
	private InicioController controller;
	private boolean derrotado=false;
	private boolean muerto=false;
	public Personaje(int x, int y, String imagen, int velocidad, String personajeDerrotado, Boss enemigo) {
		super(x, y, imagen, velocidad);
		this.imagen=new Image(imagen);
		this.personajeDerrotado=new Image(personajeDerrotado);
		rectangulo=new Rectangle(x, y,this.imagen.getWidth(),this.imagen.getHeight());
		rectDerecha=new Rectangle(x+(this.imagen.getWidth()/2), y, this.imagen.getWidth()/2,this.imagen.getHeight()/2);
		recPersonajeDerrotado = new Rectangle(x, y, this.imagen.getWidth(), this.imagen.getHeight());
		//this.enemigos= enemigo;
	}
	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(imagen, x, y);
		//graficos.strokeRect(rectangulo.getX(), rectangulo.getY(), rectangulo.getWidth(), rectangulo.getHeight());
		//graficos.setStroke(Color.RED); 
		
		/*graficos.strokeRect(rectDerecha.getX(), gravedad, gravedad, gravedad);
		graficos.setStroke(Color.BLACK);
		*/
		graficos.strokeRect(recPersonajeDerrotado.getX(), recPersonajeDerrotado.getY(),
				recPersonajeDerrotado.getWidth(), recPersonajeDerrotado.getHeight());
	}
	@Override
	public void teclado(KeyEvent evento, boolean presiona) {
		// TODO Auto-generated method stub
		
			if (presiona) {
				switch (evento.getCode().toString()) {
				case "RIGHT":
					derecha = true;
					break;
				case "LEFT":
					izquierda = true;
					break;
				case "UP":
					arriba = true;
					break;
				case "DOWN":
					abajo = true;
					break;
				case "Z":
					y += velocidad * -15;
					x += 10;
					this.salto = true;
					break;
				case "SPACE":
					disparo=true;

				}
			} else {
				switch (evento.getCode().toString()) {
				case "RIGHT":
					derecha = false;
					break;
				case "LEFT":
					izquierda = false;
					break;
				case "UP":
					arriba = false;
					break;
				case "DOWN":
					abajo = false;
					break;

				}
		}
		
		

		
	}
	@Override
	public void raton(KeyEvent evento) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void logicaCalculos() {
		
			if (derecha) {
				x += velocidad;
			}
			if (izquierda) {
				x -= velocidad;
			}
			if (arriba) {
				y -= velocidad;
			}
			if (abajo) {
				y += velocidad;
			}
			if (derecha) {
				// Si el personaje está en el límite derecho del escenario, no permitir que se
				// mueva más hacia la derecha
				if (x + rectangulo.getWidth() >= Escenario.limiteDerecho) {
					x = Escenario.limiteDerecho - (int) rectangulo.getWidth();
				} else {
					x += velocidad;
				}
			}

			if (izquierda) {
				// Si el personaje está en el límite izquierdo del escenario, no permitir que se
				// mueva más hacia la izquierda
				if (x <= Escenario.limiteIzquierdo) {
					x = Escenario.limiteIzquierdo;
				} else {
					x -= velocidad;
				}
			}
			if (arriba) {
				if (y <= Escenario.limiteArriba) {
					y=Escenario.limiteArriba;
				}
				else {
					y-= velocidad;
				}
			}
			if (abajo) {
				if (y + rectangulo.getHeight() >= 600) {
					y =(int) (Escenario.limiteAbajo - Personaje.rectangulo.getHeight());
				}
				else {
					y+=velocidad;
				}
			}
			this.rectangulo.setX(x);
			this.rectangulo.setY(y);
			/*
			//colisi n cuadro rojo
			for (CuadroTileMap cuadro : Escenario.cuadros) {
				if (this.rectDerecha.getBoundsInLocal().intersects((cuadro.getRectangulo().getBoundsInLocal()))) {				
					x-=velocidad;
					this.rectangulo.setX(x);				
					this.rectDerecha.setX(x+this.imagen.getWidth()/2);				
					break;
				} 
			}
			this.recPersonajeDerrotado.setX(x);
			this.recPersonajeDerrotado.setY(y);
			this.rectangulo.setX(x);
			this.rectangulo.setY(y);
			this.rectDerecha.setX(x+this.imagen.getWidth()/2);
			this.rectDerecha.setY(y);
			//colision general
			for (CuadroTileMap cuadro : Escenario.cuadros) {
				if (this.rectangulo.getBoundsInLocal().intersects((cuadro.getRectangulo().getBoundsInLocal()))) {
					this.desciende=false;
					this.salto=false;
					break;
				} else {
					this.desciende=true;
				}
			}
			if (desciende == true || salto == true) {
				y += gravedad;
				this.rectangulo.setX(x);
				this.rectangulo.setY(y);
			}
			*/
			if(!derrotado&&!(enemigos.derrotado())) {
				if(disparo) {
					this.disparos.agregarDisparo(new Rectangle(x+rectangulo.getWidth()/2,y,10,10));
					disparo=false;
				}
				
			
			
		}else if (derrotado) {
			y-=velocidad;
			if(y==0) {
				muerto=true;
			}
		}
			
		
		
		
		
		//ver si hay colicion con nave y enemigos
		/*
		int i=0;
		boolean col=false;
		for (Rectangle rec : rEnemigos) {
			if(this.r.getBoundsInLocal().intersects((rec.getBoundsInLocal()))) {
				System.out.println("Colision");
				col=true;
				break;
			}
			i++;
		}
		if (col==true) {
			rEnemigos.remove(i);
		}
		//ver si hay colisiones entre el disparo y enemigos
		int indiceDisparo=0;
		int indiceEnemigo=0;
		boolean contacto=false;
		for (Rectangle rec : rEnemigos) {
			for (Rectangle recDisparo : disparos.getDisparo()) {
				if (rec.getBoundsInLocal().intersects((recDisparo.getBoundsInLocal()))) {
					contacto=true;
					break;
				}
				indiceDisparo++;
			}
			if (contacto) {
				disparos.getDisparo().remove(indiceDisparo);
				rEnemigos.remove(indiceEnemigo);
				
			}
			indiceDisparo=0;
			indiceEnemigo++;
		}
		*/
	}
	public void setDisparos(Disparos disparos) {
		this.disparos=disparos;
	}
	public void verificarColision() {
		
		if(!derrotado) {
			boolean contacto=false;
			if(rectangulo.getBoundsInLocal().intersects(enemigos.getFiguraEnemigo().getBoundsInLocal())) {
				System.out.println("Colision");
				contacto=true;
				
			}
			if(contacto) {
				disminuirVida();
			}
		}
		
	}
	public void verificarColisionDisparo() {
		if(!(enemigos.derrotado())) {
			boolean contacto=false;
			int indiceDisparo = 0;
			for (Rectangle recDisparos : disparos.getDisparo()) {
				if(enemigos.getFiguraEnemigo().getBoundsInLocal().intersects(recDisparos.getBoundsInLocal())) {
					System.out.println("Contacto");
					contacto=true;
					break;
				}
				indiceDisparo++;
			}
			if(contacto) {
				disparos.getDisparo().remove(indiceDisparo);
				enemigos.disminuirVida();
			}
		}

	}
	public void disminuirVida() {
		vida-=1;
		System.out.println("Vida: "+vida);
		if(vida<=0) {
			System.out.println("Has muerto");
			imagen=personajeDerrotado;
			rectangulo=recPersonajeDerrotado;
			
			this.derrotado=true;
			reproducirMusicaDerrota();
			
			}
		
	}
	
	private void reproducirMusicaDerrota() {
		// TODO Auto-generated method stub
		if(controller!=null) {
			controller.cargarMusicaDerrota();
		}
	}

	/*
	public void verificarColisionDisparoEnemigo() {
		boolean contacto=false;
		int indiceDisparo=0;
		for (Rectangle recDisparos : disparos.getDisparo()) {
			if(r.getBoundsInLocal().intersects(recDisparos.getBoundsInLocal()))
		}
	}
	*/
	public boolean derrotado() {
		return derrotado;
	}
	public Rectangle getFiguraPersonaje() {
		return rectangulo;
	}
	public void setController(InicioController h) {
		this.controller=h;
	}
	/*
	public ArrayList<Rectangle> getrEnemigos() {
		return rEnemigos;
	}
	public void setrEnemigos(ArrayList<Rectangle> rEnemigos) {
		this.rEnemigos = rEnemigos;
	}
	*/
	public void setBoss(Boss enemigos) {
		this.enemigos=enemigos;
	}
	public boolean getMuerto() {
		return muerto;
	}
}