package Biblioteca;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class BuscarPorAsimov {
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase baseDatos = mongoClient.getDatabase("Biblioteca");
		MongoCollection col_Libro = baseDatos.getCollection("Libros");

		// Buscar el libro titulo Los pilares de la tierra

		try {
			Bson filter = Filters.eq("Autor.Apellidos","Asimov");

			MongoCursor <Document> cursor_lib=col_Libro.find().filter(filter).sort(Sorts.descending("Titulo")).projection(Projections.include("Titulo","año_publicacion")).iterator();

			while(cursor_lib.hasNext()) {
				System.out.println("Libros: "
						+ ""
						+ cursor_lib.next().toJson());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mongoClient.close();
		}

	}
}
