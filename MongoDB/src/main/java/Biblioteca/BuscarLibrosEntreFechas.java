package Biblioteca;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class BuscarLibrosEntreFechas {
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase baseDatos = mongoClient.getDatabase("Biblioteca");
		MongoCollection col_Libro = baseDatos.getCollection("Libros");
		
		try {
			Bson filter = Filters.and(Filters.gt("año_publicacion",1990),Filters.lt("año_publicacion", 2000));
			MongoCursor <Document> cursor_lib=col_Libro.find().filter(filter).iterator();
			while(cursor_lib.hasNext()) {
				System.out.println(cursor_lib.next().getString("titulo"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			mongoClient.close();
		}
	}
}
