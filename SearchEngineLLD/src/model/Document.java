package model;

import java.util.UUID;

public class Document {

    UUID documentId;
    UUID DatasetId;
    String name;
    String content;

    public Document(UUID datasetID, String documentName, String content) {
        setDocumentId();
        setName(documentName);
        setDatasetId(datasetID);
        setContent(content);
    }

    public UUID getDocumentId() {
        return documentId;
    }

    public void setDocumentId() {
        this.documentId = UUID.randomUUID();
    }

    public UUID getDatasetId() {
        return DatasetId;
    }

    public void setDatasetId(UUID datasetId) {
        DatasetId = datasetId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
