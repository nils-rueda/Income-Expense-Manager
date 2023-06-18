package pacuf5;
import java.util.List;			//para poder usar los List.
import java.util.ArrayList;		//para poder usar los ArrayList. 

public class Cuenta {

//************** Atributos ************** 
	
	private double saldo;
	private Usuario usuario;
	private List<Gasto>gastos;
	private List<Ingreso>ingresos;
	
	
//************** M�todos.****************
	
	//Constructor: pasamos por par�metro al usuario creado.
	
	public Cuenta(Usuario usuario) {
		this.saldo = 0;		//el saldo comienza siendo 0. 
		this.usuario = usuario;
		this.gastos = new ArrayList<Gasto>();
		this.ingresos = new ArrayList<Ingreso>(); //
	}
	
	//Getter y Setter de saldo:	
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	//Getter y Setter de usuario:	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//M�todo para a�adir Ingresos: al a�adir un nuevo ingreso, �ste se sumar� al saldo vigente: 
	
	public double addIngresos(String description, double cantidad) {
		//Creamos el ingreso, y pasamos la cantidad y la descripcion:
		Ingreso nuevoIngreso = new Ingreso(cantidad, description);
		//A�adimos el ingreso a la lista:
		this.ingresos.add(nuevoIngreso);
		//Sumamos el saldo:
		this.saldo = this.saldo + cantidad;
		//Devolvemos el saldo final: 
		return saldo;
	}
	
	/*Al a�adir un nuevo gasto se debe comprobar si se dispone de saldo
	suficiente, en caso contrario se deber� lanzar una nueva excepci�n del
	tipo GastoException(), pero el programa no debe finalizar. Si se dispone
	de saldo suficiente se restar� el importe del gasto y se devolver� el saldo
	de la cuenta.*/
	
	public double addGastos(String description, double cantidad) {
		try { 
			this.saldo = this.saldo - cantidad;   //A�adir un gasto implica restar la cantidad al saldo.
			if (this.getSaldo() < 0) { 			  //Si el saldo es inferior a 0, llamamos a la Excepci�n creada.
				throw new GastoException();		  //lanzamos nueva instancia de la clase GastoException. 
			}
		}
		catch(GastoException error) {		//Con la Excepci�n se activa el "catch". 
			return -1;						//Devolvemos -1 para no salir del programa.
		}
		
		//En caso de que no se active el catch, pasamos al siguiente bloque: 
		Gasto nuevoGasto = new Gasto(cantidad,description); //Creamos un nuevo gasto y lo a�adimos a la lista de gastos.
		gastos.add(nuevoGasto); 
		return saldo;	//Se devuelve el saldo. 

	}
	
	//Devolvemos la lista de ingresos
	public List <Ingreso> getIngresos() {
		return ingresos;
	}
	
	 //Devolvemos la lista de gastos
	public List<Gasto>getGastos() {
		return gastos;
	}
	
	//M�todo "toString", para mostrar el saldo. Se impmimir� si el usuario selecciona el n�mero 5 del men� de instrucciones. 
	public String toString() {			
		return "Usuario: " + this.usuario +  ". Saldo: " + this.saldo + ".";
	}

}
