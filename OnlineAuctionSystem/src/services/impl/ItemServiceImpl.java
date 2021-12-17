package services.impl;

import model.Item;
import model.Seller;
import repository.ItemRepository;
import repository.SellerRepository;
import repository.impl.InMemoryItemRepository;
import services.ItemService;
import services.SellerService;

import java.util.List;
import java.util.UUID;

public class ItemServiceImpl implements ItemService {

    ItemRepository repository = new InMemoryItemRepository();

    @Override
    public UUID registerItem(UUID sellerId) { //seller
        Item item = new Item();
        item.setSellerId(sellerId);
        repository.registerItem(item);
        return item.getItemId();
    }

    @Override
    public Item getItemFromRepo(UUID itemId) {
        return repository.getItemFromRepo(itemId);
    }

    @Override
    public List<Item> getAllItems() {
        return repository.getAllItems();
    }
}
