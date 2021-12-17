package services;

import model.Item;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    UUID registerItem(UUID sellerId);
    Item getItemFromRepo(UUID itemId);
    List<Item> getAllItems();
}
