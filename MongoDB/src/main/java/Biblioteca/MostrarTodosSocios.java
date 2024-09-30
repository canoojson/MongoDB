package Biblioteca;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MostrarTodosSocios {
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase baseDatos = mongoClient.getDatabase("Biblioteca");
		MongoCollection col_Socios = baseDatos.getCollection("Socios");

		// Mostrar todos los socios
		MongoCursor<Document> cursor_soc = col_Socios.find().iterator();

		while (cursor_soc.hasNext()) {
			System.out.println(cursor_soc.next().toJson());
		}
	}
}
