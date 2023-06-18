package pacuf5;

public abstract class Dinero {
	
//************** Atributos ************** 
	
	protected double dinero;		//ser� la cantidad de dinero (la heredar�n las clases Ingreso y Gasto). 
	protected String description;	//ser� el concepto del ingreso o del gasto de dinero (lo heredar�n las clases Ingreso y Gasto). 
	
	
//************** M�todos ************** 
	
	//Getter y Setter de la variable "dinero": 
	
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	
	//Getter y Setter de la variable "description": 
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
