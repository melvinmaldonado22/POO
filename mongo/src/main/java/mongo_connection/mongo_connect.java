package mongo_connection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class mongo_connect {
    private static final String URI = "mongodb+srv://whitehack:o6H5orTRaYuteJGE@cluster0.ubppspc.mongodb.net/<dbname>?retryWrites=true&w=majority";
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static MongoDatabase getConnection() {
        try {
            if (mongoClient == null) {
                mongoClient = MongoClients.create(URI);
                database = mongoClient.getDatabase("test");
                System.out.println("Conexión a MongoDB establecida correctamente");
            }
            return database;
        } catch (Exception e) {
            System.err.println("Error al conectar a MongoDB: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection() {
        try {
            if (mongoClient != null) {
                mongoClient.close();
                mongoClient = null;
                database = null;
                System.out.println("Conexión a MongoDB cerrada correctamente");
            }
        } catch (Exception e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}