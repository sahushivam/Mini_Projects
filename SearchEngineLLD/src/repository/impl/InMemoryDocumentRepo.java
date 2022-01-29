package repository.impl;

import model.Document;
import repository.DocumentRepo;

import java.util.HashMap;
import java.util.UUID;

public class InMemoryDocumentRepo implements DocumentRepo {

    public static HashMap<UUID, Document> map = new HashMap<>();

    @Override
    public UUID addDocument(UUID datasetID, String documentName, String content) {
        Document document = new Document(datasetID, documentName, content);
        map.put(document.getDocumentId(), document);
        return document.getDocumentId();
    }
}
