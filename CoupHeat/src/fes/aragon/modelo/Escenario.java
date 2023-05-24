package fes.aragon.modelo;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Escenario extends ComponentesJuego {
	public static final List<CuadroTileMap> cuadros = new ArrayList<>();
	private Image imagen;
	static int limiteIzquierdo;
    static int limiteDerecho;
    static int limiteArriba;
    static int limiteAbajo;
    static int limiteIzquierdaBoss;
    
	public Escenario(int x, int y, String imagen, int velocidad) {
		super(x, y, imagen, velocidad);

// el canvas tiene un tamaño de 1000x600, al no tener suelo obtamos por no usar la matriz para delimitar el escenario
			limiteIzquierdo = x;
		    limiteDerecho = x + 1000;
		    limiteArriba= y;
		    limiteAbajo=600;	
		    limiteIzquierdaBoss=250;
		
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		for (CuadroTileMap cuadro : cuadros) {
			graficos.drawImage(
					imagen,
					cuadro.getCoorXImagenDentro(),
					cuadro.getCoorYImagenDentro(),
					cuadro.getAnchoImagenDentro(),
					cuadro.getAltoImagenDentro(),
					cuadro.getxVentana(),
					cuadro.getyVentana(),
					cuadro.getAnchoVentanaPintar(),
					cuadro.getAltoImagenDentro()
					);
			
			graficos.strokeRect(
					cuadro.getxVentana(),
					cuadro.getyVentana(),
					cuadro.getAnchoImagenDentro(),
					cuadro.getAnchoImagenDentro()
					);
		}

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

	}
}
