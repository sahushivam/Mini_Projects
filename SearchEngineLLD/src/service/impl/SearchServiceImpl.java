package service.impl;

import model.Dataset;
import model.DocumentWordFrequency;
import service.DatasetService;
import service.SearchService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SearchServiceImpl implements SearchService {

    DatasetService datasetService = new DatasetServiceImpl();

    @Override
    public List<String> searchQuery(String query, UUID datasetId) {
        Dataset dataset = datasetService.getDataset(datasetId);
        Map<String, List<DocumentWordFrequency>> map1 = dataset.getMap1();

        String [] queryWords = query.split(" ");
        List<String> documents = new ArrayList<>();

        for(String word:queryWords) {
            if(map1.containsKey(word)) {
                List<DocumentWordFrequency> documentWordFrequencies = map1.get(word);
                for (DocumentWordFrequency documentWordFrequency : documentWordFrequencies) {
                    int frequency = documentWordFrequency.getFrequency();
                    String documentName = documentWordFrequency.getDocumentName();
                    documents.add(documentName);
                }
            }
        }
        return documents;
    }
}
/*< word, document, boolean >-*  this is my query*/