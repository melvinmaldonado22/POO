package mongo_connection;

import org.bson.Document;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class login {
    private MongoCollection<Document> collection;

    public login(String collectionName) {
        MongoDatabase database = mongo_connect.getConnection();
        if (database != null) {
            this.collection = database.getCollection(collectionName);
        }
    }
    public void iniciar_sesion(Document loginData){
        Document user = collection.find(Filters.eq("email", loginData.getString("email"))).first();
        if (user != null && user.getString("password").equals(loginData.getString("password"))) {
            System.out.println("Inicio de sesión exitoso");
            System.out.println("Bienvenido " + user.getString("nombre"));
        } else {
            System.out.println("Inicio de sesión fallido...");
        }

    };
}
