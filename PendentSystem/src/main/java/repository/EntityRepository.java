package repository;

import domain.Entity;

import java.util.HashMap;

public class EntityRepository {

    private final HashMap<String, Entity>  map;

    public EntityRepository(HashMap<String, Entity> map) {
        this.map = map;
    }

    public void addEntity(Entity entity) {
        map.put(entity.getId(), entity);
    }

    public Entity getEntityById(String id) {
        return map.get(id);
    }
}
