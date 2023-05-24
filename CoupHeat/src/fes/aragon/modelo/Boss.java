package fes.aragon.modelo;

import fes.aragon.controlador.InicioController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Boss extends ComponentesJuego {
	private Image imagen;
	private Rectangle rectangulo;
	private Rectangle recEnemigoDerrotado;
	private Rectangle r;
	private DisparoEnemigos disparos;
	int numArriba;
	int numAbajo;
	int numDisparo;
	int numRand;
	int numDerecha;
	int numIzquierda;
	private int vida=500;
	private boolean arriba=false;
	private boolean abajo=false;
	private boolean izquierda=false;
	private boolean derecha=false;
	private boolean derrotado;
	private Image imagenDerrotado;
	private InicioController controller;
	private boolean disparo=false;
	private Personaje personaje;
	
	
	public Boss(int x, int y, String imagen, int velocidad, String enemigoDerrotado, Personaje personaje) {
		super(x, y, imagen, velocidad);
		// TODO Auto-generated constructor stub
		this.imagen=new Image(imagen);
		this.imagenDerrotado= new Image(enemigoDerrotado);
		rectangulo = new Rectangle(x,y,this.imagen.getWidth(),this.imagen.getHeight());
		recEnemigoDerrotado=new Rectangle(x,y,this.imagenDerrotado.getWidth(),this.imagenDerrotado.getHeight());
		r=new Rectangle(x,y,this.imagen.getWidth(),this.imagen.getHeight());	
	}
	
	@Override
	public void pintar(GraphicsContext graficos) {
		// TODO Auto-generated method stub
		graficos.drawImage(imagen, x, y);
		//graficos.strokeRect(rectangulo.getX(), rectangulo.getY(),
		//		rectangulo.getWidth(), rectangulo.getHeight());
		graficos.strokeRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
	}

	@Override
	public void teclado(KeyEvent evento, boolean presiona) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void raton(KeyEvent evento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logicaCalculos() {
		// TODO Auto-generated method stub
		//calculo de movimiento
			numArriba=(int)(Math.random()*20+1);
			numAbajo=(int)(Math.random()*20+1);
			numDisparo=(int)(Math.random()*35+1);
			numRand=(int)(Math.random()*10+1);
			numIzquierda = (int)(Math.random()*20+1);
			numDerecha=(int)(Math.random()*20+1);
		
		//movimientos y comportamientos
			if(!derrotado&&!(personaje.derrotado())) {
			if(numArriba==1) {
				arriba=true;
			}else {
				arriba=false;
			}
			if(numAbajo==1) {
				abajo=true;
			}else {
				abajo=false;
			}
			if(numDisparo==1) {
				disparo=true;
			}
			
			if(arriba) {
				y-=velocidad*2;
			}
			
			if(abajo) {
				y+=velocidad*2;
			}
			if(numIzquierda==1) {
				izquierda=true;
			}else {
				izquierda=false;
			}
			if(numDerecha==1) {
				derecha=true;
			}else {
				derecha=false;
			}
			if(derecha) {
				x+=velocidad*5;
					}	
				if(izquierda) {
				x-=velocidad*5;
					}
			if(disparo) {
				this.disparos.agregarDisparoEnemigo(new Rectangle(x+r.getWidth()/2,y+r.getHeight()/2,15,15));
				disparo=false;
			}
		}
		
		this.r.setX(x);
		this.r.setY(y);
		this.rectangulo.setX(x);
		this.rectangulo.setY(y);
		this.recEnemigoDerrotado.setX(x);
		this.recEnemigoDerrotado.setY(y);
		
		//movimiento en limites del mapa
		if (derecha) {
			// Si el personaje está en el límite derecho del escenario, no permitir que se
			// mueva más hacia la derecha
			if (x + r.getWidth() >= Escenario.limiteDerecho) {
				x = (Escenario.limiteDerecho- (int)r.getWidth());
			} else {
				x += velocidad;
			}
		}

		if (izquierda) {
			if (x <=300) {
				x = Escenario.limiteIzquierdaBoss;
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
			if (y + r.getHeight() >= 600) {
			
				y =(int) (Escenario.limiteAbajo - r.getHeight());
	
			}
			else {
				y+=velocidad;
			}
		}
		
		}
	public void disminuirVida() {
		
		vida -=50;
		System.out.println("Vida del enemigo: "+vida);
		if(vida<=0) {
			
			System.out.println("el enemigo a muerto");
			imagen=imagenDerrotado;
			r=recEnemigoDerrotado;
			
			derrotado=true;
			reproducirMusicaVictoria();
		}
	}
	
	public void reproducirMusicaVictoria() {
		if(controller!=null) {
			controller.cargarMusicaVictoria();
		}
	}
	public void verificarColisionDisparoPersonaje() {
		if(!(personaje.derrotado())) {
			boolean contacto=false;
			int indiceDisparo=0;
			for(Rectangle recDisparos: disparos.getDisparo()) {
				if(personaje.getFiguraPersonaje().getBoundsInLocal().intersects(recDisparos.getBoundsInLocal())) {
					System.out.println("contacto enemigo");
					contacto=true;
					break;
				}
				indiceDisparo++;
			}
			if (contacto) {
				disparos.getDisparo().remove(indiceDisparo);
				personaje.disminuirVida();
			}
		}
		
	}
	public boolean derrotado() {
		return derrotado;
	}
	public void setDisparos(DisparoEnemigos disparos) {
		this.disparos=disparos;
	}
	public Rectangle getFiguraEnemigo() {
		return rectangulo;
	}
	
	public void setController(InicioController g) {
		this.controller=g;
	}
	public void setPersonaje(Personaje personaje) {
		this.personaje=personaje;
	}
	
}
