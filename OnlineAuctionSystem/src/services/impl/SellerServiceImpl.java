package services.impl;

import model.Item;
import model.Seller;
import repository.SellerRepository;
import repository.impl.InMemorySellerRepository;
import services.ItemService;
import services.SellerService;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SellerServiceImpl implements SellerService {

    ItemService itemService = new ItemServiceImpl();
    SellerRepository sellerRepository = InMemorySellerRepository.getInstance();

    @Override
    public void setBiddingDate(UUID itemId, Date biddingTime) {
        Item item = itemService.getItemFromRepo(itemId);
        item.setBiddingTime(biddingTime);
    }

    @Override
    public void seeHistory(UUID sellerId) {
        List<Item> itemList = itemService.getAllItems()
                .stream()
                .filter(item -> item.getSellerId().equals(sellerId))
                .collect(Collectors.toList());
        itemList.forEach(item -> System.out.println(item.getItemId() + " " + item.getStatus()));
    }

    @Override
    public Seller getSellerById(UUID sellerId) {
        return sellerRepository.getSellerById(sellerId);
    }

    @Override
    public boolean validateSeller(UUID fromString) {
        sellerRepository.getSellerById(fromString);
        return true;
    }
}
