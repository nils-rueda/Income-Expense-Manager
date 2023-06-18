package pacuf5;

public class GastoException extends Exception {		//la clase GastoException hereda de Exception.
	

	private String error = ""; 
	
	//M�todos*************************************:
	
	public GastoException() {		//procedemos a elaborar nuestra excepci�n en forma de funci�n. .
		this.error = "No puedes realizar m�s gastos.";
	}

	public String getMessage() { 	//para devolver el error producido en la clase. 
		return error;
	}
}
