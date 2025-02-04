/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_empleado
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.empleado.mundo;

/*OPCION 1: BASADOS EN LA ANTIGUEDAD DEL EMPLEADO
 * SE DEBE CALCULAR UN INCREMENTO SALARIAL DE LA SIGUIENTE FORMA
 * 
 *  - ANTIGUEDAD >=  1 --- 15%
 *  - ANTIGUEDAD > 1 && <= 2 --- 18%
 *  ANTIGUEDAD > 2 && ANTIGUEDAD <= 3 --- 20%
 *  
 *  SE MUESTRA EL NUEVO SALARIO
 *  ANALIZAR ANTIGUEDAD 
 *  
 *  
 */

/* OPCION 2 : 

 * SI LA FECHA DE INGRESO ES INFERIOR AL 2016 Y LA EDAD DEL EMPLEADO
 * ES MENOR A 28 A�OS SE DEBE PAGAR UNA PRIMA ADICIONAL AL SALARIO DEL 10% TENIENDO
 * EN CUENTA QUE LA PRIMA ANUAL ES DE UN SUELO
 *  MOSTRAR EN PANTALLA PRIMA ADICIONAL(SUELDO*100)/100 
 * 
 * 
 * 
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase que representa un empleado.
 */
public class Empleado {
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Nombre del empleado.
	 */
	private String nombre;

	/**
	 * Apellido del empleado.
	 */
	private String apellido;

	/**
	 * Genero del empleado. <br>
	 * 1 indica g�nero masculino. <br>
	 * 2 indica g�nero femenino. <br>
	 */
	private int genero;

	/**
	 * Fecha de nacimiento del empleado.
	 */
	private Fecha fechaNacimiento;

	/**
	 * Fecha de ingreso del empleado a la compa��a.
	 */
	private Fecha fechaIngreso;

	/**
	 * Ruta de la imagen.
	 */
	private String imagen;

	/**
	 * Salario del empleado.
	 */
	private double salario;

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Construye el empleado. <br>
	 * <b>post: </b> Se cre� el empleado con los siguientes valores: <br>
	 * Nombre: Pedro, Apellido: Matallana, G�nero: masculino (1), Fecha de
	 * nacimiento: 16-6-1982, Fecha de ingreso: 5-4-2000, Imagen: empleado1.png,
	 * Salario: 1500000.
	 */
	public Empleado() {
		nombre = "Pedro";
		apellido = "Matallana";
		genero = 1;
		fechaNacimiento = new Fecha(16, 6, 1982);
		fechaIngreso = new Fecha(5, 4, 2000);
		imagen = "empleado1.png";
		salario = 1500000;
	}

	/**
	 * Retorna el nombre del empleado.
	 * 
	 * @return Nombre del empleado.
	 */
	public String darNombre() {
		return nombre;
	}

	/**
	 * Retorna el genero del empleado.
	 * 
	 * @return Genero del empleado.
	 */
	public int darGenero() {
		return genero;
	}

	/**
	 * Retorna la fecha de nacimiento del empleado en una cadena.
	 * 
	 * @return Fecha de nacimiento del empleado.
	 */
	public String darFechaNacimiento() {
		String strFecha = fechaNacimiento.toString();
		return strFecha;
	}

	/**
	 * Retorna la fecha de ingreso del empleado en una cadena.
	 * 
	 * @return Fecha de ingreso del empleado.
	 */
	public String darFechaIngreso() {
		String strFecha = fechaIngreso.toString();
		return strFecha;
	}

	/**
	 * Retorna la ruta de la imagen del empleado.
	 * 
	 * @return Ruta de la imagen.
	 */
	public String darImagen() {
		return imagen;
	}

	/**
	 * Retorna el salario del empleado.
	 * 
	 * @return Salario del empleado.
	 */
	public double darSalario() {
		return salario;
	}

	/**
	 * Retorna el apellido del empleado.
	 * 
	 * @return Apellido del empleado.
	 */
	public String darApellido() {
		return apellido;
	}

	/**
	 * Retorna la edad del empleado en a�os.
	 * 
	 * @return Edad del empleado en a�os.
	 */
	public int calcularEdad() {
		Fecha hoy = darFechaActual();

		int edad = fechaNacimiento.darDiferenciaEnMeses(hoy) / 12;

		return edad;
	}

	/**
	 * Retorna la antig�edad del empleado en a�os.
	 * 
	 * @return Antig�edad del empleado en a�os.
	 */
	public double calcularAntiguedad() {
		Fecha hoy = darFechaActual();
		double antiguedad = fechaIngreso.darDiferenciaEnMeses(hoy) / 12.0;

		return antiguedad;
	}

	/**
	 * Retorna las prestaciones del empleado usando la f�rmula: p = (a * s)/12
	 * (p: prestaciones, a: antig�edad, s: salario). <br>
	 * La antig�edad que se utiliza est� dada en a�os, as� que si un empleado
	 * lleva menos de un a�o en la empresa, sus prestaciones ser�n 0.
	 * 
	 * @return Prestaciones del empleado.
	 */
	public double calcularPrestaciones() {
		double antiguedad = calcularAntiguedad();
		double prestaciones = ((double) (antiguedad * salario)) / 12.0;
		return prestaciones;
	}

	/**
	 * Cambia la informaci�n del empleado con los valores dados por par�metro. <br>
	 * <b> post: </b> El nombre, apellido, g�nero, fecha de nacimiento, fecha de
	 * ingreso, salario e imagen fueron cambiados con los valores dados por
	 * par�metro.
	 * 
	 * @param pNombre
	 *            Nombre del empleado. pNombre != null && pNombre != "".
	 * @param pApellido
	 *            Apellido del empleado. pApellido != null && pApellido != "".
	 * @param pGenero
	 *            G�nero del empleado. pGenero == 1 || pGenero == 0.
	 * @param pFechaNacimiento
	 *            Fecha de nacimiento del empleado. pFechaNacimiento != null.
	 * @param pFechaIngreso
	 *            Fecha de ingreso del empleado. pFechaIngreso != null.
	 * @param pSalario
	 *            Salario del empleado. pSalario > 0.
	 * @param pImagen
	 *            Imagen del empleado. pImagen != null && pImagen != "".
	 */
	public void cambiarEmpleado(String pNombre, String pApellido, int pGenero,
			Fecha pFechaNacimiento, Fecha pFechaIngreso, int pSalario,
			String pImagen) {
		nombre = pNombre;
		apellido = pApellido;
		genero = pGenero;
		fechaNacimiento = pFechaNacimiento;
		fechaIngreso = pFechaIngreso;
		salario = pSalario;
		imagen = pImagen;
	}

	/**
	 * Cambia el salario del empleado con el valor dado por par�metro. <br>
	 * <b>post: </b> El salario tiene el valor ingresado por par�metro.
	 * 
	 * @param pSalario
	 *            Nuevo salario del empleado. pSalario > 0.
	 */
	public void cambiarSalario(double pSalario) {
		salario = pSalario;
	}

	/**
	 * Retorna la fecha actual.
	 * 
	 * @return Fecha actual.
	 */
	public Fecha darFechaActual() {
		GregorianCalendar gc = new GregorianCalendar();

		int dia = gc.get(Calendar.DAY_OF_MONTH);
		int mes = gc.get(Calendar.MONTH) + 1;
		int anho = gc.get(Calendar.YEAR);
		Fecha hoy = new Fecha(dia, mes, anho);

		return hoy;

	}

	// -----------------------------------------------------------------
	// Puntos de Extensi�n
	// -----------------------------------------------------------------

	/**
	 * M�todo para la extensi�n 1.
	 * 
	 * @return Respuesta 1.
	 */
	public String metodo1() {
		if (calcularAntiguedad() == 1) {
			return "NUEVO SALARIO :" + (darSalario() + (darSalario() * 0.15));
		} else {
			if (calcularAntiguedad() > 1 && calcularAntiguedad() <= 2) {
				return "NUEVO SALARIO:"
						+ (darSalario() + (darSalario() * 0.18));
			} else {
				if (calcularAntiguedad() > 2 && calcularAntiguedad() <= 3) {
					return "NUEVO SALARIO: " + darSalario()
							+ (darSalario() * 0.20);

				}
			}
		}

		return "No hay Incremento Salarial";

	}

	/**
	 * M�todo para la extensi�n 2.
	 * 
	 * @return Respuesta 2.
	 */
	public String metodo2() {
		
	if(fechaIngreso.darAnio() < 2016 & calcularEdad() < 28){
	return "PRIMA ADICIONAL : " + 	darSalario()*0.10;
	}else
		return "NO TIENE PRIMA ADICIONAL";
		
	}

}