package store.model;

import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Promotion {
    private String name;
    private int buyProduct;
    private int getProduct;
    private LocalDate startDate;
    private LocalDate endDate;

    public Promotion(String name, String buy, String get, String start_date, String end_date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.name = name;
        this.buyProduct = Integer.parseInt(buy);
        this.getProduct = Integer.parseInt(get);
        this.startDate = LocalDate.parse(start_date, formatter);
        this.endDate = LocalDate.parse(end_date, formatter);
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean checkUsableDate() {
        LocalDate currentDate = DateTimes.now().toLocalDate();
        return ((currentDate.isEqual(startDate) || currentDate.isAfter(startDate)) &&
                (currentDate.isEqual(endDate) || currentDate.isBefore(endDate)));
    }
}
