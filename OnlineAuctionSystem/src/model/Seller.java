package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Seller extends User{

    private List<UUID> items;//list of item for which he is going to have auctions

    public Seller() {
        super();
        items = new ArrayList<>();
    }
}
