package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Dataset {

    private UUID id;
    private String name;
    Map<String, List<DocumentWordFrequency>> map1;

    public Map<String, List<DocumentWordFrequency>> getMap1() {
        return map1;
    }

    public void setMap1(Map<String, List<DocumentWordFrequency>> map1) {
        this.map1 = map1;
    }

    public Dataset(String name){
        setId();
        setName(name);
        this.map1 = new HashMap<>();
    }

    public UUID getId() {
        return id;
    }

    private void setId() {
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
