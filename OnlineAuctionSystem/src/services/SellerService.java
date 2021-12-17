package services;

import model.Seller;

import java.util.Date;
import java.util.UUID;

public interface SellerService {

    void setBiddingDate(UUID itemId, Date biddingTime);
    void seeHistory(UUID sellerId);
    Seller getSellerById(UUID sellerId);
    boolean validateSeller(UUID fromString);
}
