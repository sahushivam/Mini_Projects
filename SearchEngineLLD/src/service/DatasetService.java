package service;

import model.Dataset;

import java.util.UUID;

public interface DatasetService {

    UUID createDataset(String name);

    Dataset getDataset(UUID datasetID);
}
