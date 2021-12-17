import constants.CommandConstants;
import services.AdminService;
import services.BidderService;
import services.ItemService;
import services.SellerService;
import services.impl.AdminServiceImpl;
import services.impl.BidderServiceImpl;
import services.impl.ItemServiceImpl;
import services.impl.SellerServiceImpl;

import java.text.ParseException;
import java.util.Scanner;
import java.util.UUID;

import static constants.CommandConstants.*;
import static utils.AuctionUtility.getDateFromString;

public class Driver {

    private static final AdminService adminService;
    private static final BidderService bidderService;
    private static final ItemService itemService;
    private static final SellerService sellerService;


    static {
        adminService = new AdminServiceImpl();
        bidderService = new BidderServiceImpl();
        itemService = new ItemServiceImpl();
        sellerService = new SellerServiceImpl();
    }

    public static void main(String[] args) {

        Driver driver = new Driver();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Auction !!!");
        while(true) {
            System.out.println("Please enter the commands");
            String commandLine = sc.nextLine();
            String commands[] = commandLine.split(" ");
            switch (commands[0]) {
                case REGISTER_SELLER:
                    System.out.println(adminService.registerSeller(commands[1])); break;
                case REGISTER_BIDDER:
                    System.out.println(adminService.registerBidder(commands[1])); break;
                case REGISTER_FOR_ITEM_AUCTION:
                    bidderService.registerForItem(UUID.fromString(commands[1]),UUID.fromString(commands[2])); break;
                case REGISTER_ITEM_TO_SELL:
                    if(sellerService.validateSeller(UUID.fromString(commands[1]))) {
                        System.out.println(itemService.registerItem(UUID.fromString(commands[1])));
                    }
                    break;
                case SEE_SELLER_HISTORY:
                    sellerService.seeHistory(UUID.fromString(commands[1]));break;
                case SEE_BIDDER_HISTORY:
                    bidderService.seeBidderHistory(UUID.fromString(commands[1]));break;
                case SEE_UPCOMING_ITEM_AUCTIONS:
                    try {
                        bidderService.seeUpComingItemBids(getDateFromString(commands[1]));
                    } catch (ParseException e) {
                        System.out.println("Date in incorrect format");
                    }
                    break;
                case START_AUCTION:
                    adminService.startAuctionForItem(UUID.fromString(commands[1]));
                case EXIT: System.exit(0); break;
            }
        }
    }
}


//Non static -
//Static method - Class se associated

//Driver d = new Driver();
//Driver d1 = new Driver();
//