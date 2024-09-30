package Biblioteca;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class BuscarSocioConIsbn {
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase baseDatos = mongoClient.getDatabase("Biblioteca");
		MongoCollection col_Pres = baseDatos.getCollection("Prestamos");
		MongoCollection col_Soc = baseDatos.getCollection("Socios");
		
		try {
			Bson filter = Filters.all("libro", Filters.eq("isbn", "446854"));
			
			Document prestamo = (Document) col_Pres.find().filter(filter).first();
	        
			Document ObjetoSocio = (Document) prestamo.get("socio");
			int numSocio = ObjetoSocio.getInteger("num_socio");
			
			filter = Filters.eq("Num_socio",numSocio);
			
			Document socio = (Document) col_Soc.find().filter(filter).first();
			
			System.out.println("Nombre del socio: " + socio.getString("Nombre"));
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			mongoClient.close();
		}
	}
}
