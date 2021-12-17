package services;

import java.util.Date;
import java.util.UUID;


public interface BidderService {

    void registerForItem(UUID bidderId, UUID itemId);
    void seeUpComingItemBids(Date date);
    void seeBidderHistory(UUID bidderId);
}
