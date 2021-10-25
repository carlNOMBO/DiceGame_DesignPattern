package Persist;

import Core.Entry;
import Core.HighScore;
import Core.Player;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class HighScoreMongo implements HighScore {
    private String host;
    private int port;
    private String databaseName;
    private String collection;

    private List<Entry> highscores;

    public HighScoreMongo(String host, int port, String databaseName, String collection) {
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.collection = collection;
    }

    @Override
    public void save(Entry score) {
        MongoDatabase database = this.getDatabase();
        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection(this.collection);

        //Inserting document into the collection
        Document document = new Document("name", score.getPlayer().getName())
                .append("score", score.getScore())
                .append("gameDate", score.getGameDate());

        collection.insertOne(document);
    }

    @Override
    public void load() {
        this.highscores = new ArrayList<>();
        MongoDatabase database = this.getDatabase();
        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection(this.collection);
        // Getting the iterable object
        FindIterable<Document> iterDoc = collection.find();
        Iterator<Document> it = iterDoc.iterator();
        while (it.hasNext()) {
            Document doc = it.next();
            this.highscores.add(new Entry(doc.getInteger("score"),
                                    doc.getDate("gameDate"),
                                    new Player(doc.getString("name"))));
        }
        this.highscores.forEach(x->{System.out.println(x.toString());});
    }

    @Override
    public void add(Entry bestScore) {

    }

    public MongoDatabase getDatabase(){
        // Creating a Mongo client
        MongoClient mongo = new MongoClient( this.host , this.port );

        // Accessing the database
        MongoDatabase database = mongo.getDatabase(this.databaseName);

        return database;
    }

}
