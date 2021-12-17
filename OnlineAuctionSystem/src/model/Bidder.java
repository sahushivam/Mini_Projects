package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bidder extends User {

    private List<UUID> userItemHistory; //list item for which he has registered

    public Bidder() {
        super();
        userItemHistory = new ArrayList<>();
    }
}
