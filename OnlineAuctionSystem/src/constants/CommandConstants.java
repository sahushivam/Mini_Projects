package constants;

public class CommandConstants {

    /*
    Online auction system:
        1. User has to register for auction
        2. User can be part of multiple auctions
        3. Item put for auction
        4. User needs to bid an amount for the item
        5. Admin/owner needs to add items for auction
        6. There would be an owner for the auction
        7. User and seller can see history of all its previous auctions
        8. Item status after bidding
        9. Minimum value at which he wants to sell the item is set by the seller. If not given then default is zero
        10. User can see upcoming auctions
     */
    public static final String REGISTER_SELLER = "register_seller";
    public static final String REGISTER_BIDDER = "register_bidder";
    public static final String REGISTER_ITEM_TO_SELL = "register_item";
    public static final String REGISTER_FOR_ITEM_AUCTION = "register_user_for_item_auction";
    public static final String SEE_SELLER_HISTORY = "seller_history";
    public static final String SEE_BIDDER_HISTORY = "bidder_history";
    public static final String SEE_UPCOMING_ITEM_AUCTIONS = "upcoming_item_auctions";
    public static final String START_AUCTION = "start_auction_for_item";
    public static final String EXIT = "exit";
}
