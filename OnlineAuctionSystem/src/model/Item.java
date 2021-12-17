package model;

import constants.ItemStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Item {

    private UUID itemId;
    private UUID sellerId;
    private UUID highestBidder;
    private Double highestBidPrice;
    private Double currentBidPrice;
    private List<UUID> bidders;
    private Date biddingTime;
    private ItemStatus status;
    private String name;

    public List<UUID> getBidders() {
        return bidders;
    }

    public void setBidders(List<UUID> bidders) {
        this.bidders = bidders;
    }

    public Date getBiddingTime() {
        return biddingTime;
    }

    public void setBiddingTime(Date biddingTime) {
        this.biddingTime = biddingTime;
    }

    public Item() {
        setItemId(UUID.randomUUID());
        bidders = new ArrayList<>();
        setCurrentBidPrice(0.0);
        setBiddingTime(new Date(Long.MAX_VALUE));
        setStatus(ItemStatus.NOT_SOLD);
    }

    public UUID getItemId() {
        return itemId;
    }

    private void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public UUID getSellerId() {
        return sellerId;
    }

    public void setSellerId(UUID sellerId) {
        this.sellerId = sellerId;
    }

    public UUID getHighestBidder() {
        return highestBidder;
    }

    public void setHighestBidder(UUID highestBidder) {
        this.highestBidder = highestBidder;
    }

    public Double getHighestBidPrice() {
        return highestBidPrice;
    }

    public void setHighestBidPrice(Double highestBidPrice) {
        this.highestBidPrice = highestBidPrice;
    }

    public Double getCurrentBidPrice() {
        return currentBidPrice;
    }

    public void setCurrentBidPrice(Double currentBidPrice) {
        this.currentBidPrice = currentBidPrice;
    }

    public void addBidder(UUID uuid){
        this.bidders.add(uuid);
    }

    public ItemStatus getStatus() {
        return this.status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
