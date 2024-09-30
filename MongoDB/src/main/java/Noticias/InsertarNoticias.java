package Noticias;

import java.util.*;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class InsertarNoticias {
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase baseDatos = mongoClient.getDatabase("Noticias");
		MongoCollection col_not = baseDatos.getCollection("Noticia");

		List<String> tags = Arrays.asList("c", "D");

		List<String> telef = Arrays.asList("73128899", "43278944");

		int id = 2;

		Document n = new Document("id", id).append("titulo", "Ultima hora").append("cuerpo", "DETALLES DE LA NOTICIA")
				.append("fecha", "2015-03-10").append("tags", tags)
				.append("usuario", new Document("nombre_usuario", "Frank_blog").append("nombre", "Frank")
						.append("cuenta_twitter", "Frank_USE").append("descrpcion", "blogger aficionado")
						.append("telefonos", telef).append("direccion", new Document("calle", "Av. de los Castros")
								.append("numero", "2256").append("cp", "39005").append("ciudad", "Santander")));

		col_not.insertOne(n);

		id++;

		tags = Arrays.asList("E", "F");

		n = new Document("id", id).append("titulo", "Noticias relevantes").append("cuerpo", "INFORMACIÓN PRINCIPAL")
				.append("fecha", "2016-08-15").append("tags", tags)
				.append("usuario", new Document("nombre_usuario", "Frank_blog").append("nombre", "Frank")
						.append("cuenta_twitter", "Frank_USE").append("descrpcion", "blogger aficionado")
						.append("telefonos", telef).append("direccion", new Document("calle", "Av. de los Castros")
								.append("numero", "2256").append("cp", "39005").append("ciudad", "Santander")));

		col_not.insertOne(n);

		id++;

		tags = Arrays.asList("G", "H");

		n = new Document("id", id).append("titulo", "Avance informativo").append("cuerpo", "RESUMEN DE LA NOTICIA")
				.append("fecha", "2017-12-05").append("tags", tags)
				.append("usuario", new Document("nombre_usuario", "Frank_blog").append("nombre", "Frank")
						.append("cuenta_twitter", "Frank_USE").append("descrpcion", "blogger aficionado")
						.append("telefonos", telef).append("direccion", new Document("calle", "Av. de los Castros")
								.append("numero", "2256").append("cp", "39005").append("ciudad", "Santander")));

		col_not.insertOne(n);
		
		id++;

		tags = Arrays.asList("I", "J");

		n = new Document("id", id).append("titulo", "Titular destacado").append("cuerpo", "DETALLES ESENCIALES")
				.append("fecha", "2018-11-22").append("tags", tags)
				.append("usuario", new Document("nombre_usuario", "Frank_blog").append("nombre", "Frank")
						.append("cuenta_twitter", "Frank_USE").append("descrpcion", "blogger aficionado")
						.append("telefonos", telef).append("direccion", new Document("calle", "Av. de los Castros")
								.append("numero", "2256").append("cp", "39005").append("ciudad", "Santander")));

		col_not.insertOne(n);
		
		id++;

		tags = Arrays.asList("K", "L");

		n = new Document("id", id).append("titulo", "Noticias en directo").append("cuerpo", "ACTUALIZACIÓN DE LA NOTICIA")
				.append("fecha", "2019-06-30").append("tags", tags)
				.append("usuario", new Document("nombre_usuario", "Frank_blog").append("nombre", "Frank")
						.append("cuenta_twitter", "Frank_USE").append("descrpcion", "blogger aficionado")
						.append("telefonos", telef).append("direccion", new Document("calle", "Av. de los Castros")
								.append("numero", "2256").append("cp", "39005").append("ciudad", "Santander")));

		col_not.insertOne(n);

		MongoCursor<Document> cursor_not = col_not.find().iterator();

		while (cursor_not.hasNext()) {
			System.out.println(cursor_not.next().toJson());
		}
	}
}
