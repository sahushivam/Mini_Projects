package repository;

import model.Bidder;

import java.util.UUID;

public interface BidderRepository {

    void registerBidder(Bidder bidder);

    String getBidder(UUID highestBidder);
}
