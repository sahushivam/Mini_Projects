package repository;

import model.Item;

import java.util.List;
import java.util.UUID;

public interface ItemRepository {

    void registerItem(Item item);

    Item getItemFromRepo(UUID itemId);

    List<Item> getAllItems();
}
