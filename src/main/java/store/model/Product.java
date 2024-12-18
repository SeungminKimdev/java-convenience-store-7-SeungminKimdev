package store.model;

public class Product {
    private final String name;
    private final int price;
    private int quantity;
    private final String promotion;

    public Product(String name, String price, String quantity, String promotion) {
        this.name = name;
        this.price = Integer.parseInt(price);
        this.quantity = Integer.parseInt(quantity);
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPromotion() {
        return promotion;
    }

    // 변동사항은 재고밖에 없기 때문에 set 사용
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
