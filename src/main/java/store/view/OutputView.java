package store.view;

import java.util.List;
import store.model.Product;
import store.model.Receipt;

public class OutputView {
    public void announcement() {
        System.out.println("안녕하세요. W편의점입니다.");
        System.out.println("현재 보유하고 있는 상품입니다.");
        System.out.println();
    }

    public void showProducts(List<Product> products) {
        for (Product product : products) {
            printProducts(product);
        }
        System.out.println();
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

    public void showReceipt(Receipt receipt) {
        List<Product> purchasedProducts = receipt.getPurchasedProducts();
        List<Product> freeProducts = receipt.getFreeProducts();

        System.out.println();
        System.out.println("==============W 편의점================");
        System.out.println("상품명\t\t\t\t수량\t\t\t금액");
        for (Product product : purchasedProducts) {
            System.out.printf("%-15s\t%-3d\t\t\t%,d\n", product.getName(), product.getQuantity(), product.getPrice() * product.getQuantity());
        }
        System.out.println("=============증\t\t정===============");
        for (Product product : freeProducts) {
            System.out.printf("%-15s\t%d\n", product.getName(), product.getQuantity());
        }
        System.out.println("====================================");
        int totalPurchaseAmount = receipt.getTotalPurchaseAmount();
        int totalPurchasePrice = receipt.getTotalPurchasePrice();
        int promotionDiscount = receipt.getPromotionDiscount();
        int membershipDiscount = receipt.getMembershipDiscount();
        System.out.printf("총구매액\t\t\t\t%d\t\t\t%,d\n", totalPurchaseAmount, totalPurchasePrice);
        System.out.printf("행사할인\t\t\t\t\t\t\t%s\n", "-" + String.format("%,d", promotionDiscount));
        System.out.printf("멤버십할인\t\t\t\t\t\t\t%s\n", "-" + String.format("%,d", membershipDiscount));
        System.out.printf("내실돈\t\t\t\t\t\t\t%,d\n", (totalPurchasePrice - promotionDiscount - membershipDiscount));
        System.out.println();
    }
}
