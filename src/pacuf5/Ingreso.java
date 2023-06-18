package pacuf5;

public class Ingreso extends Dinero {	/*La clase Ingreso hereda de la clase "Dinero". 
										Para ello, usamos la palabra clave "extends".*/
	
//************** M�todos ************** 
	
	//constructor "Ingreso", en el que se inicializar�n los valores recibidos por par�metros.
	public Ingreso(double ingreso, String description) {
		this.dinero = ingreso;		//este atributo "dinero" viene de la clase abstracta Dinero, de la que hereda esta clase Ingreso.
		this.description = description;	/*igual ocurre con description. 
										En este caso, el par�metro del m�todo Ingreso se llama igual ("description"). */
	}
	
	//M�todo "toString", para mostrar la descripci�n del ingreso, y el dinero ingresado.
	public String toString() {
		return "Descripci�n del ingreso: " + this.description + ". " + "Dinero ingresado: " + this.dinero + "."; 
	}
}
