package repository;

import model.Dataset;

import java.util.UUID;

public interface DatasetRepo {

    UUID createDataset(String name);

    Dataset getDataset(UUID datasetID);
}
