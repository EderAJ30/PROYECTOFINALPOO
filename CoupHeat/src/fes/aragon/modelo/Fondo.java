package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class Fondo extends ComponentesJuego {
	private int xx=1000;;
	private Image imagen;
	private Image imagenDos;

	public Fondo(int x, int y, String imagen, int velocidad) {
		super(x, y, imagen, velocidad);
		this.imagen=new Image(imagen);
		this.imagenDos=new Image(imagen.replace('2', '3'));
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		// TODO Auto-generated method stub
		
		graficos.drawImage(imagen, x, y);
		graficos.drawImage(imagenDos, xx,y);
			}

	@Override
	public void teclado(KeyEvent evento,boolean presiona) {
		// TODO Auto-generated method stub

	}

	@Override
	public void raton(KeyEvent evento) {

	}

	@Override
	public void logicaCalculos() {
		x-= velocidad;
		xx -= velocidad;
		if (x == -1000) {
			x = 1000;
		}
		if (xx ==-1000) {
			xx = 1000;
		}

	}

}