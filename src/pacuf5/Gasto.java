package pacuf5;

public class Gasto extends Dinero {		/*La clase Gasto hereda de la clase "Dinero". 
										Para ello, usamos la palabra clave "extends".*/
	
//************** M�todos ************** 
	
	//constructor "Gasto", en el que se inicializar�n los valores recibidos por par�metros.
	public Gasto(double gasto, String description) {
		this.dinero = gasto;			//este atributo "dinero" viene de la clase abstracta Dinero, de la que hereda esta clase Gasto.
		this.description = description; 	/*igual ocurre con description. 
											En este caso, el par�metro del m�todo Gasto se llama igual ("description"). */
	}
	
	//M�todo "toString", para mostrar la descripci�n del gasto, y el dinero gastado.
	public String toString() {
		return "Descripci�n del gasto: " + this.description + ". " + "Dinero gastado: " + this.dinero + "."; 	
	}
}
