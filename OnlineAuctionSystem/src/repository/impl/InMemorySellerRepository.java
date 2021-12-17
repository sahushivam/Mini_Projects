package repository.impl;

import exception.UserNotFound;
import model.Seller;
import repository.SellerRepository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemorySellerRepository implements SellerRepository {

    public static Map<UUID, Seller> map = new ConcurrentHashMap<>();

    private static InMemorySellerRepository inMemorySellerRepository;

    public static InMemorySellerRepository getInstance() {
        if(inMemorySellerRepository == null) {
            inMemorySellerRepository = new InMemorySellerRepository();
        }
        return inMemorySellerRepository;
    }
    private InMemorySellerRepository() {
    }


    @Override
    public void registerSeller(Seller seller) {
        map.put(seller.getId(),seller);
    }

    @Override
    public Seller getSellerById(UUID sellerId) {
        if(map.containsKey(sellerId)) {
        return map.get(sellerId);   }
        throw new UserNotFound();
    }
}
