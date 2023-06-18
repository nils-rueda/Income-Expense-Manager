package pacuf5;

public class Usuario {

//************** Atributos ************** 	
	private String nombre;
	private int edad;
	private String DNI;
	
	
//************** M�todos.****************

	//Constructor de Usuario: m�todo constructor de la clase "Usuario" (se llaman igual, Usuario y Usuario).
	public Usuario() {		
		this.nombre = " ";	//lo dejamos vac�o, por el momento.
		this.edad = 0;		//lo ponemos a 0, por el momento.
		this.DNI = " ";		//lo dejamos vac�o, por el momento.
	}
	
	//Getter y Setter de la variable "nombre": 
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Getter y Setter de la variable "edad":
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//Getter y Setter de la variable "DNI":

	public String getDNI() {	//getter del DNI.
		return DNI;
	}
	
	public boolean setDNI(String DNI) {	 	/* m�todo setter del DNI, de tipo booleano. 
											Fijar� el DNI, y devolver� "true" o "false", 
											dependiendo de si se ha introducido de forma correcta. */ 
		
		/* Usaremos IF y el m�todo "matches", que  indica si un String coincide con lo pedido en el par�metro, o no. 
		Comprobaremos que sean d�gitos (del 1 al 8), que acabe en una letra, y damos la posiblidad de que tenga un gui�n. */
		
		if(DNI.matches("^[0-9]{8}[a-zA-Z]$") || DNI.matches("^[0-9]{8}[-][a-zA-Z]$")){
			this.DNI=DNI;	//si se cumple la condici�n del "matches", se aceptar� el DNI, y devolveremos true. 
			return true;
		}
		else{
			return false;	// si no se cumple, no se aceptar� el DNI, y devolveremos false. 
		}      
	}
	
	//M�todo toString, para devolver el nombre, la edad y el DNI del Usuario creado:
	
	public String toString() {
		return "Tu nombre:" + this.nombre + ". Tu edad : " + this.edad + ". Tu DNI: " + this.DNI + ".";
	}
	
}
