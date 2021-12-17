package services;

import java.util.UUID;

public interface AdminService {

    UUID registerSeller(String name);

    UUID registerBidder(String name);

    void startAuctionForItem(UUID itemId);
}
