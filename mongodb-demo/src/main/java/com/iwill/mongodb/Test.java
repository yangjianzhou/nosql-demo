package com.iwill.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Test {
    public static void main(String[] args) {
        MongoClient client = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = client.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test");
        Document d1 = new Document();
        d1.append("name", "三国演义").append("author", "罗贯中");
        collection.insertOne(d1);

        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(1);
    }
}
