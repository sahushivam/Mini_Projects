import service.DatasetService;
import service.DocumentService;
import service.SearchService;
import service.impl.DatasetServiceImpl;
import service.impl.DocumentServiceImpl;
import service.impl.SearchServiceImpl;

import java.util.List;
import java.util.UUID;

public class Driver {

    public static void main(String[] args) {

        DatasetService datasetService = new DatasetServiceImpl();
        DocumentService documentService = new DocumentServiceImpl();
        SearchService searchService = new SearchServiceImpl();

        UUID fruits = datasetService.createDataset("Fruits");
        UUID flowers = datasetService.createDataset("Flowers");

        documentService.addDocument(fruits, "Doc-1", "Apple Oranges Grapes");
        documentService.addDocument(fruits, "Doc-2", "Watermellon Mango");
        documentService.addDocument(flowers, "Doc-2", "Rose Lotus");

        List<String> list = searchService.searchQuery("Apple", fruits);
        for(String word:list) {
            System.out.println(word);
        }
    }
}
