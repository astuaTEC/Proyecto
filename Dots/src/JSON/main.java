package JSON;
import java.io.IOException;
import java.util.stream.Stream;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
public class main {

	public static void main(String[] args) {
		Molde persona = new Molde();
		
	
		
		persona.setNombre("Kevin");
		persona.setApellido("Acevedo");
		persona.setEdad(17);
		
		Molde persona1 = new Molde();
		
		persona1.setNombre("Keylor");
		persona1.setApellido("Morales");
		persona1.setEdad(20);
		
		Molde persona2 = new Molde();
		persona2.setNombre("Eddy");
		persona2.setApellido("Pineda");
		persona2.setEdad(37);
		
		//String jsonMolde = Transformador.convertJavaToJson(persona);
		
		//System.out.println(jsonMolde);
		
		Molde[] ListaPersonas = Stream.of(persona,persona1,persona2).toArray(Molde[]::new);
		
		
		String JsonArray = Transformador.convertJavaToJson(ListaPersonas);
		
		
		System.out.println(JsonArray);
		
		
		
	
		
}
}
