package store.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Product> purchasedProducts;
    private List<Product> freeProducts;
    private int totalPurchaseAmount;
    private int totalPurchasePrice;
    private int promotionDiscount;
    private int membershipDiscount;

    public Receipt() {
        this.purchasedProducts = new ArrayList<>();
        this.freeProducts = new ArrayList<>();
        this.totalPurchaseAmount = 0;
        this.totalPurchasePrice = 0;
        this.promotionDiscount = 0;
        this.membershipDiscount = 0;
    }

    public void addPurchasedProduct(String productName, int quantity, int price) {
        Product product = new Product(productName, Integer.toString(price), Integer.toString(quantity),"null");
        purchasedProducts.add(product);
        totalPurchaseAmount += quantity;
        totalPurchasePrice += quantity * price;
    }

    public void addFreeProduct(String productName, int quantity) {
        Product product = new Product(productName, "0", Integer.toString(quantity), "null");
        freeProducts.add(product);
    }

    public void addPromotionDiscount(int promotionDiscount) {
        this.promotionDiscount += promotionDiscount;
    }

    public void addMembershipDiscount(int membershipDiscount) {
        this.membershipDiscount += membershipDiscount;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public List<Product> getFreeProducts() {
        return freeProducts;
    }

    public int getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public int getTotalPurchasePrice() {return totalPurchasePrice;}

    public int getPromotionDiscount() {
        return promotionDiscount;
    }

    public int getMembershipDiscount() {
        return membershipDiscount;
    }
}
