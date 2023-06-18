package pacuf5;
import java.util.Scanner; //para poder utilizar el Scanner e introducir datos en el programa. 

public class Main {		//Clase "Main", no confundir con el m�todo "Main", que va dentro. 
	

// ********** VARIABLE PARA INTRODUCCI�N DE DATOS **********
	//Declaramos un Scanner para que el usuario pueda introducir datos. 
	private static final Scanner sc = new Scanner(System.in);
	
	
	// ********** VARIABLES PARA CREAR UN USUARIO **********
	//Declaramos una variable que guardar� objetos de clase Usuario.
	private static Usuario nuevoUsuario = new Usuario();
	 
	// Declaramos una variable para guardar el nombre del Usuario.
	private static String nombreUsuario = "";
	 
	//Declaramos una variable para guardar la edad del Usuario en String.
	private static String edadUStr = "";
	 
	//Declaramos una variable para guardar la edad del Usuario en tipo byte (n�mero).
	private static byte edadUsuario = -1;
	 
	//Declaramos una variable para guardar el DNI del Usuario
	private static String dniUsuario = "";
	 
	//Declaramos una variable para comprobar si el usuario creado es correcto. Comienza en"false" porque a�n no ha sido creado.
	private static boolean usuarioCreado = false;
	

/***********************************************************************
 * FUNCI�N PARA CREAR UN USUARIO: creamos una funci�n, llamada "crearUsuario", 
 * para que dicho usuario escriba sus datos personales.
 ************************************************************************ */  
	private static void crearUsuario() {
		
		usuarioCreado = false;
		
		//Solicitamos al usuario que escriba su nombre, y repetimos el proceso mientras dicho nombre est� vac�o.
		do {
			System.out.println("Introduce el nombre del usuario");
			nombreUsuario = sc.nextLine();	 
		} while(nombreUsuario.isEmpty());
		
		nuevoUsuario.setNombre(nombreUsuario);
		 
		/* Solicitamos al usuario que escriba su edad: repetimos el proceso 
		 * mientras (while) dicha edad en formato String est� vac�a, (para eso creamos antes "edadUStr" como String, 
		 * para poder utilizar el m�todo ".isEmpty" en el while),
		 * o mientras (while) la edad en formato byte sea menor o igual a cero*/
		do {
			System.out.println("Introduce la edad del usuario");
			edadUStr = sc.nextLine();
		// Probamos a pasar la edad a formato Byte (n�mero). 
			try {
				edadUsuario = Byte.parseByte(edadUStr);
				nuevoUsuario.setEdad(edadUsuario);
			} catch(NumberFormatException e) {
				System.out.println("La edad debe introducirse en formato num�rico, y ser m�s que 0");
			}
		} while(edadUStr.isEmpty() || edadUsuario <= 0);
		 
		/* Solicitamos al usuario que escriba su DNI, y repetimos el proceso: 
		 * 		1) mientras dicho DNI est� vac�o, o bien
		 * 		2) mientras el m�todo "setDNI" (booleano) devuelva "false"*/
		
		do {
			System.out.println("Introduce el DNI del usuario");
			dniUsuario = sc.nextLine().toUpperCase();
			
		/* Si el valor introducido funciona, se asigna el valor del DNI
		a la variable dni de la clase Usuario*/
			if(nuevoUsuario.setDNI(dniUsuario)) {
				nuevoUsuario.setDNI(dniUsuario);
			}
			else {
				System.out.println("El DNI introducido no es v�lido.");
			}
		} while(dniUsuario.isEmpty() || nuevoUsuario.setDNI(dniUsuario) == false);

		//Si todo est� funciona, aceptamos y creamos al usuario igual�ndolo a "true". 
		usuarioCreado = true;
	}


//******************** VARIABLES PARA VISUALIZAR EL MEN� CON LAS INSTRUCCIONES ********************
	
	/*Declaramos una variable "String" para guardar la instrucci�n que introduzca el usuario, 
	 * y lo dejamos sin contenido.*/
	private static String instruccion = "";

	/*Declaramos una variable "byte" para almacenar, en tipo "n�mero", 
	el valor que el usuario ha introducido en "String", es decir, en tipo "texto".*/
	private static byte numeroInstruccion= -1;	/* ponemos -1 para que no sea 0, pues 0 implicar�a
											la salida del programa al visualizar el men�. */  



/**********************************************************************************
* FUNCI�N QUE 1) VISUALIZA EL MEN� CON LAS INSTRUCCIONES, 
* 2) SOLICITA UNA INSTRUCCI�N AL USUARIO, Y
* 3) PROCEDE A PASAR LA INSTRUCCI�N INTRODUCIDA EN FORMA DE TEXTO A FORMA DE N�MERO. 
 * *******************************************************************************  */
	private static void mostrarMenu(){
		//Usamos un do-while para mantener activo el men� de instrucciones mientras se cumplan las condiciones indicadas abajo.
		//Dentro del do-while, usamos un try-catch para garantizar que el n�mero introducido es correcto.
		do {
			System.out.println("1 - Introduce un nuevo gasto.");
			System.out.println("2 - Introduce un nuevo ingreso.");
			System.out.println("3 - Mostrar gastos.");
			System.out.println("4 - Mostrar ingresos.");
			System.out.println("5 - Mostrar saldo.");
			System.out.println("0 - Salir.");
			
			try {
				//Solicitamos al usuario que escoja una instrucci�n.
				System.out.print("Introduce una instrucci�n del men�: ");
	 
				//Registramos lo que el usuario ha introducido, y lo guardamos en la variable "instrucci�n".
				instruccion = sc.nextLine();
	 
				//Convertimos el valor String a byte, para cerciorarnos de que se ha introducido un n�mero (y no un texto). 
				numeroInstruccion = Byte.parseByte(instruccion);
			} catch(NumberFormatException e) {
				System.out.println(e.getMessage());
				System.out.println("La instrucci�n debe ser un n�mero de 0 a 5");	//lanzamos un mensaje de error si no se ha cumplido lo pedido.
			}
		} while(numeroInstruccion < 0 && numeroInstruccion > 5);
	}

//******************** VARIABLES PARA LA CLASE "CUENTA" ******************** //
	 
	/*Declaramos una variable (nuevaCuenta) para guardar un objeto del tipo Cuenta.. 
	 * Para empezar, le asignamos el valor "null". */
	private static Cuenta nuevaCuenta = null;
	 
	//Declaramos una variable "String" para guardar el importe del ingreso/gasto, seg�n proceda.
	private static String importe = "";
	 
	// Declaramos una variable "double", para guardar, en n�meros decimales, el importe del ingreso/gasto.
	private static double importeTotal = 0;
	 
	// Declaramos una variable "String" para guardar el concepto del ingreso/gasto.
	private static String concepto  ="";


/****************************************************************  
* (1) FUNCI�N PARA INTRODUCIR GASTOS EN LA CUENTA  
* ************************************************************** */
	private static void introducirGastos(){
		//Vaciamos las variables, o las ponemos a 0, porque podr�an tener alg�n valor previo. 
		importe = "";
		concepto = "";
		importeTotal = 0;
		//Solicitamos que se introduzca el concepto del gasto.
		do {
			System.out.print("Introduce el concepto del gasto: ");
			concepto = sc.nextLine();
		} while(concepto.isEmpty());

		//Solicitamos que se introduzca el importe del gasto.
		do {
			System.out.print("Introduce el importe del gasto: ");
			importe = sc.nextLine();
			try { 		//Usamos un try-catch para tratar de pasar el valor introducido a formato de n�mero:
				importeTotal = Double.parseDouble(importe);
			} catch(NumberFormatException e){
				System.out.println("Error. El importe del gasto debe ser un n�mero" + e.getMessage());
			} 
		} while(importe.isEmpty());
		
		/*Usamos un IF: si el saldo de la cuenta es menos que el importe total del gasto, o si es igual a 0, 
		 * pediremos que antes se realice un ingreso. 
		 * Si no (else), a�adimos el gasto a la cuenta, e indicamos que el gasto se ha relizado con �xito */

		if(nuevaCuenta.getSaldo() < importeTotal || nuevaCuenta.getSaldo() == 0){
			System.out.println("No hay fondos suficientes. Antes de poder hacer un gasto, debes realizar un ingreso.");
			}
		else { 
			nuevaCuenta.addGastos(concepto, importeTotal); 	    //A�adimos el gasto a la cuenta
			System.out.println("Gasto registrado con �xito.");   //Indicamos que el gasto ha sido exitoso.
		}
	}


/* **************************************************************************** 
 * (2) FUNCI�N PARA INTRODUCIR INGRESOS EN LA CUENTA  
 * ****************************************************************************  */
	
	private static void introducirIngresos(){
		//Vaciamos las variables, o las ponemos a 0, porque podr�an tener alg�n valor previo.
		importe = "";
		concepto = "";
		importeTotal = 0;
 
		//Solicitamos que se introduzca el concepto del ingreso.
		do {
			System.out.print("Introduce el concepto del ingreso: ");
			concepto = sc.nextLine(); 
		} while(concepto.isEmpty());
		
		//Solicitamos que se introduzca el importe del ingreso.
		do {
			System.out.print("Introduce el importe del ingreso: ");
			importe = sc.nextLine();
			try { 		//Usamos un try-catch para tratar de pasar el valor introducido a formato de n�mero:
				importeTotal = Double.parseDouble(importe);
			} catch(NumberFormatException e) {
				System.out.println("Error. El importe del ingreso debe ser un n�mero" + e.getMessage());
			}
		} while(importe.isEmpty());
		
		//A�adimos el ingreso a la cuenta.
		nuevaCuenta.addIngresos(concepto, importeTotal);   
		
		//Indicamos que el ingreso ha sido exitoso.
		System.out.println("Ingreso registrado con �xito.");
	}
	
/* **************************************************************** 
* (3) FUNCI�N PARA MOSTRAR LOS GASTOS DE LA CUENTA.  
* ****************************************************************  */
	
	private static void mostrarGastos(){
		
		//Si la lista de gastos no est� vac�a, usamos un FOR para recorrer dicha lista de gastos.
		if(!nuevaCuenta.getGastos().isEmpty()) {
			for(int i = 0; i < nuevaCuenta.getGastos().size(); i++) {
				System.out.println(nuevaCuenta.getGastos().get(i).toString());
			}
		}
		else { 	//Si la lista resulta estar vac�a, as� lo indicaremos en la consola.
			System.out.println("No hay gastos en la cuenta.");
			}
	}

/* **************************************************************** 
* (4) FUNCI�N PARA MOSTRAR LOS INGRESOS DE LA CUENTA
* ****************************************************************  */

	private static void mostrarIngresos() {
		
		//Si la lista de ingresos no est� vac�a, usamos un FOR para recorrer dicha lista de ingresos.
		if(!nuevaCuenta.getIngresos().isEmpty()) {
			for(int i = 0; i < nuevaCuenta.getIngresos().size(); i++) {
				System.out.println(nuevaCuenta.getIngresos().get(i).toString());
			}
		}
		else { 	//Si la lista resulta estar vac�a, as� lo indicaremos en la consola.
			System.out.println("No hay ingresos en esta cuenta.");
		}
	}    

/* **************************************************************** 
* FUNCI�N MAIN
* ****************************************************************  */
	
	public static void main(String[] args) {
		
		/* Con un do-while, llamamos a la funci�n correspondiente para crear un Usuario ("CrearUsuario()").
		 * * Cuando se haya creado correctamente, la variable "usuarioCreado" pasar� a ser True, y terminar� el do-while.*/
		do {
			crearUsuario();
		} while(usuarioCreado = false);
	
		// Imprimimos en consola los datos personales del reci�n creado usuario.
		System.out.println("Datos del usuario nuevo:");
		System.out.println(nuevoUsuario.toString());
			
		//Procedemos a crear una nueva cuenta, asociada al nuevo Usuario. 
		nuevaCuenta = new Cuenta(nuevoUsuario);
			
		/* Con un do-while, llamamos a la funci�n "mostrarMenu()".
		* La funci�n se inicializar� con la variable "numeroInstruccion" igual a -1 (para que no sea 0, u otro n�mero del men�).
		* Adem�s, el men� se visualizar� siempre que la variable "numeroInstruccion" no sea un n�mero entre 0 y 5.
		* Al seleccionar 0, el programa terminar�.*/
		
		do {
			mostrarMenu();
			/* Con un switch, indicamos qu� instrucci�n debe activarse (del 0 al 5). 
			 * * Cada n�mero del men� llamar� a la funci�n correspondiente.  */
			switch(numeroInstruccion) {
				case 0: // 0 pone fin al programa, con el mensaje pedido en el enunciado.
					System.out.println("Fin del programa. \n" + "Gracias por utilizar la aplicaci�n.");
					break;
				case 1: // 1 introduce un nuevo gasto. 
					introducirGastos();
					break;
				case 2: // 2 introduce un nuevo ingreso. 
					introducirIngresos();
					break;
				case 3: // 3 muestra los gastos.
					mostrarGastos();
					break;
				case 4: // 4 muestra los ingresos.
					mostrarIngresos();
					break;
				case 5: // 5 muestra el saldo de la cuenta
					System.out.println(nuevaCuenta.toString());
					break;
				default: //Por defecto, se pedir� que se introduzca una instrucci�n v�lida. 
					System.out.println("Introduce una instrucci�n v�lida.");
					break;
			} 
		} while(numeroInstruccion !=0); //El do-while se ejecutar� siempre que "numeroInstruccion" sea distinto de 0. 
		
		
	} //FIN DE LA FUNCI�N MAIN. 
	
} //FIN DE LA CLASE MAIN.