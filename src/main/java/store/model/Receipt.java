package store.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Product> purchasedProducts;
    private List<Product> freeProducts;
    private int totalPurchaseAmount;
    private int promotionDiscount;
    private int membershipDiscount;

    public Receipt() {
        this.purchasedProducts = new ArrayList<>();
        this.freeProducts = new ArrayList<>();
        this.totalPurchaseAmount = 0;
        this.promotionDiscount = 0;
        this.membershipDiscount = 0;
    }

    public void addPurchasedProduct(String productName, int quantity, int price) {
        Product product = new Product(productName, Integer.toString(quantity), Integer.toString(price), "null");
        purchasedProducts.add(product);
    }

    public void addFreeProduct(String productName, String quantity) {
        Product product = new Product(productName, quantity, "0", "null");
        freeProducts.add(product);
    }

    public void addTotalPurchaseAmount(int totalPurchaseAmount) {
        this.totalPurchaseAmount += totalPurchaseAmount;
    }

    public void addPromotionDiscount(int promotionDiscount) {
        this.promotionDiscount -= promotionDiscount;
    }

    public void addMembershipDiscount(int membershipDiscount) {
        this.membershipDiscount -= membershipDiscount;
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

    public int getPromotionDiscount() {
        return promotionDiscount;
    }

    public int getMembershipDiscount() {
        return membershipDiscount;
    }
}
