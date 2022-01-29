package repository.impl;

import model.Dataset;
import repository.DatasetRepo;

import java.util.HashMap;
import java.util.UUID;

public class InMemoryDatasetRepo implements DatasetRepo {

    public static HashMap<UUID, Dataset> map = new HashMap<>();

    @Override
    public UUID createDataset(String name) {
        Dataset dataset = new Dataset(name);
        map.put(dataset.getId(),dataset);
        return dataset.getId();
    }

    @Override
    public Dataset getDataset(UUID datasetID) {
        if(map.containsKey(datasetID)) {
            return map.get(datasetID);
        }
        throw new RuntimeException("Dataset Not Found");
    }
}
