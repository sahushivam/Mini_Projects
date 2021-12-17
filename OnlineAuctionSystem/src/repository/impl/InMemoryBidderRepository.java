package repository.impl;

import model.Bidder;
import model.Seller;
import repository.BidderRepository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBidderRepository implements BidderRepository {

    public static Map<UUID, Bidder> map = new ConcurrentHashMap<>();

    @Override
    public void registerBidder(Bidder bidder) {
        map.put(bidder.getId(),bidder);
    }

    @Override
    public String getBidder(UUID bidderid) {
        return map.get(bidderid).getName();
    }
}
