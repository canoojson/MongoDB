package Biblioteca;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class CrearLibro {
	public static void main(String[] args) {
		MongoClient mongoClient=MongoClients.create();
		MongoDatabase baseDatos=mongoClient.getDatabase("Biblioteca");
		MongoCollection col_Libro = baseDatos.getCollection("Libros");
		
		Document libro = new Document("Titulo", "Sira").append("Autor", new Document("Nombre", "Maria").append("Apellido", "Dueñas")).append("ISBN",468885);
		
		col_Libro.insertOne(libro);
		
		
		
		//Mostrar todos los libros
		MongoCursor <Document> cursor_lib=col_Libro.find().iterator();
		
		while(cursor_lib.hasNext()) {
			System.out.println(cursor_lib.next().toJson());
		}
	}
}
