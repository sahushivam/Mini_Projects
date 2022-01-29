package service.impl;

import model.Dataset;
import repository.DatasetRepo;
import repository.impl.InMemoryDatasetRepo;
import service.DatasetService;

import java.util.UUID;

public class DatasetServiceImpl implements DatasetService {

    DatasetRepo datasetRepo = new InMemoryDatasetRepo();

    @Override
    public UUID createDataset(String name) {
        return datasetRepo.createDataset(name);
    }

    @Override
    public Dataset getDataset(UUID datasetID) {
        return datasetRepo.getDataset(datasetID);
    }
}
