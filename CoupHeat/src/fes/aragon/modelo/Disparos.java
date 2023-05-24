package fes.aragon.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Disparos extends ComponentesJuego {
	private ArrayList<Rectangle> disparo=new ArrayList<>();
	private Image imagen;
	public Disparos(int x, int y, String imagen, int velocidad) {
		super(x, y, imagen, velocidad);
		
		this.imagen=new Image(imagen);
	}

	 

	@Override
	public void pintar(GraphicsContext graficos) {
		
		for (Rectangle rectangulo : disparo) {
			graficos.drawImage(imagen, rectangulo.getX(), rectangulo.getY());
			graficos.strokeRect(rectangulo.getX(), rectangulo.getY(),
					this.imagen.getWidth(), this.imagen.getHeight());
		}
	}

	@Override
	public void teclado(KeyEvent evento, boolean presiona) {
		
		
	}

	@Override
	public void raton(KeyEvent evento) {
		
		
	}

	@Override
	public void logicaCalculos() {
		// TODO Auto-generated method stub
		Iterator it=disparo.iterator();
		while (it.hasNext()) {
			Rectangle r=(Rectangle) it.next();
			if(r.getX()<0) {
				it.remove();
			}else {
				r.setX(r.getX()+velocidad);
			}
		}
		
	}
	public void agregarDisparo(Rectangle rec) {
		this.disparo.add(rec);
	}
	public ArrayList<Rectangle> getDisparo(){
		return disparo;
	}
	
}
	