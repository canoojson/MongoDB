package Biblioteca;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class BuscarDentroArray {
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase baseDatos = mongoClient.getDatabase("Biblioteca");
		MongoCollection col_Pres = baseDatos.getCollection("Prestamos");
		MongoCollection col_Lib = baseDatos.getCollection("Libros");
		
		try {
			Bson filter = Filters.all("libro", Filters.eq("isbn", "446854"));
			
			Document prestamo = (Document) col_Pres.find().filter(filter).first();
	        
			System.out.println("Prestamo: " + prestamo);
			
			filter = Filters.eq("ISBN","446854");
			
			Document libro = (Document) col_Lib.find().filter(filter).first();
			
			System.out.println("Titulo del libro: " + libro.getString("Titulo"));
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			mongoClient.close();
		}
	}
}
