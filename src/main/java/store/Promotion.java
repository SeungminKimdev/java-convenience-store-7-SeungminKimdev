package store;

public class Promotion {
    private String name;
    private int buy;
    private int get;
    private String startDate;
    private String endDate;

    public Promotion(String name, String buy, String get, String start_date, String end_date) {
        this.name = name;
        this.buy = Integer.parseInt(buy);
        this.get = Integer.parseInt(get);
        this.startDate = start_date;
        this.endDate = end_date;
    }

    public String getName() {
        return name;
    }

    public int getBuy() {
        return buy;
    }

    public int getGet() {
        return get;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
