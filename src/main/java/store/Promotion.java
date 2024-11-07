package store;

public class Promotion {
    private String name;
    private int buyProduct;
    private int getProduct;
    private String startDate;
    private String endDate;

    public Promotion(String name, String buy, String get, String start_date, String end_date) {
        this.name = name;
        this.buyProduct = Integer.parseInt(buy);
        this.getProduct = Integer.parseInt(get);
        this.startDate = start_date;
        this.endDate = end_date;
    }

    public String getName() {
        return name;
    }

    public int getBuyProduct() {
        return buyProduct;
    }

    public int getGetProduct() {
        return getProduct;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
