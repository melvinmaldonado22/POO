package mongo_connection;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class MongoCRUD extends login {
    private MongoCollection<Document> collection;

    public MongoCRUD(String collectionName) {
        super(collectionName);
        MongoDatabase database = mongo_connect.getConnection();
        if (database != null) {
            this.collection = database.getCollection(collectionName);
        }
    }

    // CREATE - Insertar un documento
    public void insertDocument(Document document) {
        try {
            collection.insertOne(document);
            System.out.println("Documento insertado correctamente");
        } catch (Exception e) {
            System.err.println("Error al insertar documento: " + e.getMessage());
        }
    }

    // READ - Obtener todos los documentos
    public List<Document> getAllDocuments() {
        List<Document> documents = new ArrayList<>();
        try {
            // Simplemente agregar los documentos a la lista sin imprimir
            collection.find().forEach(documents::add);
        } catch (Exception e) {
            System.err.println("Error al obtener documentos: " + e.getMessage());
        }
        return documents;
    }

    // READ - Obtener documento por ID
    public Document getDocumentById(String id) {
        try {
            return collection.find(Filters.eq("_id", new ObjectId(id))).first();
        } catch (Exception e) {
            System.err.println("Error al obtener documento por ID: " + e.getMessage());
            return null;
        }
    }

    // UPDATE - Actualizar documento por ID
    public void updateDocument(String id, Document updateData) {
        try {
            collection.updateOne(
                Filters.eq("_id", new ObjectId(id)),
                new Document("$set", updateData)
            );
            System.out.println("Documento actualizado correctamente");
        } catch (Exception e) {
            System.err.println("Error al actualizar documento: " + e.getMessage());
        }
    }

    // DELETE - Eliminar documento por ID
    public void deleteDocument(String id) {
        try {
            collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
            System.out.println("Documento eliminado correctamente");
        } catch (Exception e) {
            System.err.println("Error al eliminar documento: " + e.getMessage());
        }
    }

}
