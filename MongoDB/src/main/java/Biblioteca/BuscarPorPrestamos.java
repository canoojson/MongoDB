package Biblioteca;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class BuscarPorPrestamos {
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase baseDatos = mongoClient.getDatabase("Biblioteca");
		MongoCollection col_Pres = baseDatos.getCollection("Prestamos");
		
		try {
			Bson filter = Filters.size("libro", 3);
			MongoCursor <Document> cursor_pres=col_Pres.find().filter(filter).iterator();
			while(cursor_pres.hasNext()) {
				System.out.println("3 prestamos: " + "" + cursor_pres.next().toJson());
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			mongoClient.close();
		}
	}
}
