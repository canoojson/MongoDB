package Biblioteca;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class AccederLibro {
	public static void main(String[] args) {
		MongoClient mongoClient=MongoClients.create();
		MongoDatabase baseDatos=mongoClient.getDatabase("Biblioteca");
		MongoCollection col_Libro=baseDatos.getCollection("Libros");
		
		//Mostrar todos los libros
		MongoCursor <Document> cursor_lib=col_Libro.find().iterator();
		
		while(cursor_lib.hasNext()) {
			System.out.println(cursor_lib.next().toJson());
		}
		
	}
}
