package repository;

import java.util.UUID;

public interface DocumentRepo {

    UUID addDocument(UUID datasetID, String documentName, String content);
}
