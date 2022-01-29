package service.impl;

import model.Dataset;
import model.DocumentWordFrequency;
import repository.DocumentRepo;
import repository.impl.InMemoryDocumentRepo;
import service.DatasetService;
import service.DocumentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DocumentServiceImpl implements DocumentService {

    DocumentRepo documentRepo = new InMemoryDocumentRepo();
    DatasetService datasetService = new DatasetServiceImpl();

    @Override
    public UUID addDocument(UUID datasetID, String documentName, String content) {
        Dataset dataset = datasetService.getDataset(datasetID);
        insertWordFrequency(dataset, documentName, content);
        return documentRepo.addDocument(datasetID,documentName,content);
    }

    private void insertWordFrequency(Dataset dataset, String documentName, String content) {
        Map<String, List<DocumentWordFrequency>> map1 = dataset.getMap1();
        Map<String, Integer> wordFrequency = new HashMap<>();
        String [] words = content.split(" ");
        for(String word:words) {
            if(wordFrequency.containsKey(word)) {
                Integer freq = wordFrequency.get(word);
                wordFrequency.put(word, freq+1);
            }
            else
                wordFrequency.put(word,1);
        }

        for (Map.Entry<String,Integer> entry : wordFrequency.entrySet()) {
            String word = entry.getKey();
            Integer freq = entry.getValue();
            if(map1.containsKey(word)) {
                List<DocumentWordFrequency> documentWordFrequencies = map1.get(word);
                DocumentWordFrequency documentWordFrequency = new DocumentWordFrequency(freq, documentName);
                documentWordFrequencies.add(documentWordFrequency);
            }
        }
        dataset.setMap1(map1);
    }
}
