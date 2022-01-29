package service;

import model.Document;

import java.util.List;
import java.util.UUID;

public interface SearchService {

    List<String> searchQuery(String query, UUID datasetId);
}
