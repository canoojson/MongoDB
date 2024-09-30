package Biblioteca;

import java.util.Date;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class ActualizarBorrarBiblioteca {
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase baseDatos = mongoClient.getDatabase("Biblioteca");
		MongoCollection col_Pres = baseDatos.getCollection("Prestamos");

		try {
			Bson filter = Filters.eq("socio.num_socio", 1);
			col_Pres.updateOne(filter, new Document("$set", new Document("fecha_dev", new Date("2024/09/24"))
					.append("fecha_pres", new Date("2024/09/24"))));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mongoClient.close();
		}
	}
}
