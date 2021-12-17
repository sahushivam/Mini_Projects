package services.impl;

import constants.ItemStatus;
import model.Bidder;
import model.Item;
import model.Seller;
import repository.BidderRepository;
import repository.SellerRepository;
import repository.impl.InMemoryBidderRepository;
import repository.impl.InMemorySellerRepository;
import services.AdminService;
import services.ItemService;

import java.util.Scanner;
import java.util.UUID;

public class AdminServiceImpl implements AdminService {

    SellerRepository sellerRepository = InMemorySellerRepository.getInstance();
    BidderRepository bidderRepository = new InMemoryBidderRepository();
    ItemService itemService = new ItemServiceImpl();

    @Override
    public UUID registerSeller(String name) {
        Seller seller = new Seller();
        seller.setName(name);
        sellerRepository.registerSeller(seller);
        return seller.getId();
    }

    @Override
    public UUID registerBidder(String name) {
        Bidder bidder = new Bidder();
        bidder.setName(name);
        bidderRepository.registerBidder(bidder);
        return bidder.getId();
    }

    @Override
    public void startAuctionForItem(UUID itemId) {
        System.out.println("Starting bid for item " + itemId);
        System.out.println("Press q to quit");
        Item item = itemService.getItemFromRepo(itemId);
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter the user Id and amount");
            String[] inputs = sc.nextLine().split(" ");
            if(inputs.length<2) {
                break;
            }
            if(validateBid(item, inputs)) {
                item.setCurrentBidPrice(Double.parseDouble(inputs[1]));
                item.setHighestBidder(UUID.fromString(inputs[0]));
            }
            if(item.getStatus().equals(ItemStatus.SOLD) || item.getStatus().equals(ItemStatus.NO_BIDDERS_FOR_MIN_PRICE)) {
                break;
            }
        }
        item.setStatus(ItemStatus.SOLD);
        System.out.println("Item sold to :" + bidderRepository.getBidder(item.getHighestBidder()));
    }

    private boolean validateBid(Item item, String[] inputs) {
        if(Double.parseDouble(inputs[1])< item.getCurrentBidPrice()) {
            System.out.println("Bid is less than current bid");
            return false;
        }
        else if(!item.getBidders().contains(UUID.fromString(inputs[0]))) {
            System.out.println("user not registered for bidding on this item");
            return false;
        }
        return true;
    }
}
