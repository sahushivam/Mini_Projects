package services.impl;

import model.Item;
import services.BidderService;
import services.ItemService;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BidderServiceImpl implements BidderService {

    ItemService itemService = new ItemServiceImpl();

    @Override
    public void registerForItem(UUID bidderId, UUID itemId) {
        Item item = itemService.getItemFromRepo(itemId);
        item.addBidder(bidderId);
    }

    @Override
    public void seeUpComingItemBids(Date date) {
        List<Item> items = itemService.getAllItems()
                .stream()
                .filter(item -> item.getBiddingTime().after(date))
                .collect(Collectors.toList());
        items.forEach(item -> System.out.println(item.getItemId()+ " Highest Bidder: "+item.getHighestBidder() + " Item Status: "+ item.getStatus()));
    }

    @Override
    public void seeBidderHistory(UUID bidderId) {

    }
}
