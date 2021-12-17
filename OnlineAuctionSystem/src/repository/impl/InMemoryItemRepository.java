package repository.impl;

import exception.ItemNotFoundException;
import model.Item;
import repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryItemRepository implements ItemRepository {

    public static Map<UUID, Item> map = new ConcurrentHashMap<>();

    @Override
    public void registerItem(Item item) {
        map.put(item.getItemId(),item);
    }

    @Override
    public Item getItemFromRepo(UUID itemId) {
        if(map.containsKey(itemId))
            return map.get(itemId);
        throw new ItemNotFoundException("Item not found with Id" + itemId);
    }

    @Override
    public List<Item> getAllItems() {
        return new ArrayList<>(map.values());
    }
}
