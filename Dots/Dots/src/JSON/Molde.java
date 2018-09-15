package JSON;
import java.io.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

// se le da el orden de las claves
/**
 * Esta clase permite meter todos los datos que queremos enviar al servidor, usando los atributos de la misma clase.
 *
 */
@JsonPropertyOrder(value = {"nombre", "apellido","edad"}) // El orden que van a tener los elementos cuando se conviertan en Json Strings
public class Molde implements Serializable {
	
	
	
	private String nombre, apellido;
	//@JsonIgnore
	private int edad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	

}
