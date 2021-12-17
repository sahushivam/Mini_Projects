package repository;

import model.Seller;

import java.util.UUID;

public interface SellerRepository {

    void registerSeller(Seller seller);
    Seller getSellerById(UUID sellerId);
}
