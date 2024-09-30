package Biblioteca;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class BuscarLibroPorNombre {
	public static void main(String[] args) {
		MongoClient mongoClient=MongoClients.create();
		MongoDatabase baseDatos=mongoClient.getDatabase("Biblioteca");
		MongoCollection col_Libro=baseDatos.getCollection("Libros");
		
		//Buscar el libro titulo Los pilares de la tierra
		
		try {
			Bson filter = Filters.eq("Titulo", "Los pilares de la tierra");
			
			Document Libro = (Document) col_Libro.find().filter(filter).first();
			System.out.println("Libro " + Libro);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			mongoClient.close();
		}
		
		
	}
}
