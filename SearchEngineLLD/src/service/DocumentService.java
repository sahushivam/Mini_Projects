package service;

import java.util.UUID;

public interface DocumentService {

    UUID addDocument(UUID datasetID, String documentName, String content);
}
