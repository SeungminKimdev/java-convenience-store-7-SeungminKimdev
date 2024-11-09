package store.view;

import java.util.List;
import store.model.Product;

public class OutputView {
    public void showProducts(List<Product> products) {
        for (Product product : products) {
            printProducts(product);
        }
    }

    private void printProducts(Product product) {
        String name = product.getName();
        int price = product.getPrice();
        int quantity = product.getQuantity();
        String promotion = product.getPromotion();

        String formattedPrice = String.format("%,d원", price);

        if (quantity == 0) {
            System.out.printf("- %s %s 재고 없음", name, formattedPrice);
        } else {
            System.out.printf("- %s %s %d개", name, formattedPrice, quantity);
        }

        if (!promotion.equals("null")) {
            System.out.printf(" %s", promotion);
        }

        System.out.println();
    }
}
