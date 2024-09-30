package Biblioteca;

import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class BuscarPorNombreUsuario {
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase baseDatos = mongoClient.getDatabase("Biblioteca");
		MongoCollection col_Libro = baseDatos.getCollection("Libros");
		Scanner tec = new Scanner(System.in);
		System.out.println("Nombre del autor: ");
		String nom = tec.nextLine();
		System.out.println("Apellidos del autor: ");
		String apell = tec.nextLine();
		try {
			Bson filter = Filters.and(Filters.eq("Autor.Nombre", nom), Filters.eq("Autor.Apellidos", apell));
			MongoCursor<Document> cursor_lib = col_Libro.find().filter(filter).iterator();
			while (cursor_lib.hasNext()) {
				System.out.println(cursor_lib.next().getString("Titulo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mongoClient.close();
		}
	}
}
