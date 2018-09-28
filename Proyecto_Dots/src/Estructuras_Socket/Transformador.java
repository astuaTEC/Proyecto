package Estructuras_Socket;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Polygon;
import java.io.*;

import java.util.ArrayList;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Esta clase es la encargada de hacer las conversiones a Json y viceversa.
 *
 */
public class Transformador {
	private static Gson gson = new Gson();
	private static ObjectMapper mapper; // Este es el objeto que permite hacer las conversiones
	public static java.lang.reflect.Type listType = new TypeToken<ArrayList<Polygon>>(){}.getType();
	static {
		mapper = new ObjectMapper(); // Lo hacemos est�tico
		
	}
	
	/**
	 * Este metodo se encarga de convertir los objetos java a Json Strings
	 * @param objeto El objeto que queremos convertir a Json String
	 * @return El objeto en formato Json
	 */
	public static String convertJavaToJson(Object objeto) {
		
		String jsonResult = "";
		//String JSON = "";
		try {
			jsonResult = mapper.writeValueAsString(objeto);
                       
                        //JSON= gson.toJson(objeto);
                        //ArrayList<Polygon> arrayDeJson = gson.fromJson(JSON, listType);
		} catch (JsonGenerationException | JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha ocurrido un error al convertir un objeto java a json :" + e.getMessage());
		}
            // TODO Auto-generated catch block
             catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha ocurrido un error al convertir un objeto java a json :"+ e.getMessage());
		}

		
		return jsonResult;
		
	}
        public static String convertJavaToJson2(Object objeto) {
		
		
                String jsonArray = gson.toJson(objeto); // TODO Auto-generated catch block
            // TODO Auto-generated catch block
            // TODO Auto-generated catch block
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Polygon>>(){}.getType();
            ArrayList<Polygon> arrayDeJson = gson.fromJson(jsonArray, listType);
       
            //ArrayList<Polygon> arrayDeJson = gson.fromJson(JSON, listType);

		
	return jsonArray;
		
	}
        
	/**
	 * Este metodo se encarga de convertir un Json String a un objeto de la clase java deseada.
     * @param <T>
	 * @param jsonString El objeto que queremos convertir a javaObject.
	 * @param cls
	 * @return El Json String en formato Java.
	 */
	public static <T> T convertJsonToJava(String jsonString, Class<T> cls) {
		T result = null;
                
		try {
			result = mapper.readValue(jsonString, cls);
                        
		} catch (JsonParseException | JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al convertir de json a objeto java :"+ e.getMessage());
		}
            // TODO Auto-generated catch block
             catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al convertir de json a objeto java :"+e.getMessage());
		}
		return result;
	}
        public static ArrayList<Polygon> convertJsonToJava2(String jsonArray, ArrayList<Polygon> cls) {
		
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Polygon>>(){}.getType(); // TODO Auto-generated catch block
            // TODO Auto-generated catch block
            // TODO Auto-generated catch block
            ArrayList<Polygon> arrayDeJson = gson.fromJson(jsonArray, listType);
            return arrayDeJson;
	}
        
       public static void main(String[] args){
           ArrayList<Polygon> p = new ArrayList();
           
           Polygon poly = new Polygon();
           
           poly.addPoint(100, 100);
           poly.addPoint(200, 100);
           poly.addPoint(100, 200);
           
          p.add(poly);
          System.out.println(p.get(0).getBounds());
          String j = Transformador.convertJavaToJson2(p);
          
          System.out.println(j);
          ArrayList<Polygon> a = new ArrayList();
          ArrayList<Polygon> pf = Transformador.convertJsonToJava2(j,a);
          System.out.println(pf.get(0).getBounds());
          
       }
}





