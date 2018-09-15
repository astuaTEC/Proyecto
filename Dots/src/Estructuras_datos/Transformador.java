package Estructuras_datos;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Esta clase es la encargada de hacer las conversiones a Json y viceversa.
 *
 */
public class Transformador {
	
	private static ObjectMapper mapper; // Este es el objeto que permite hacer las conversiones
	
	static {
		mapper = new ObjectMapper(); // Lo hacemos estático
		
	}
	
	/**
	 * Este metodo se encarga de convertir los objetos java a Json Strings
	 * @param objeto El objeto que queremos convertir a Json String
	 * @return El objeto en formato Json
	 */
	public static String convertJavaToJson(Object objeto) {
		
		String jsonResult = "";
		
		try {
			jsonResult =mapper.writeValueAsString(objeto);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha ocurrido un error al convertir un objeto java a json :" + e.getMessage());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha ocurrido un error al convertir un objeto java a json :"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha ocurrido un error al convertir un objeto java a json :"+ e.getMessage());
		}

		
		return jsonResult;
		
	}
	/**
	 * Este metodo se encarga de convertir un Json String a un objeto de la clase java deseada.
	 * @param jsonString El objeto que queremos convertir a javaObject.
	 * @param cls
	 * @return El Json String en formato Java.
	 */
	public static <T> T convertJsonToJava(String jsonString, Class<T> cls) {
		T result = null;
		try {
			result = mapper.readValue(jsonString, cls);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al convertir de json a objeto java :"+ e.getMessage());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al convertir de json a objeto java :"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al convertir de json a objeto java :"+e.getMessage());
		}
		return result;
	}
}



