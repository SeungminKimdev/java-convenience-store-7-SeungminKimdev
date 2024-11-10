package store;

import store.model.Product;
import store.model.ProductManager;
import store.model.Promotion;
import store.model.Receipt;
import store.view.InputView;
import store.view.OutputView;

public class StoreController {
    private InputView inputView;
    private OutputView outputView;
    private ProductManager productManager;
    private Receipt receipt;

    public StoreController() {
        inputView = new InputView();
        outputView = new OutputView();
        productManager = new ProductManager();
        receipt = new Receipt();
    }

    public void openStore() {
        while (true) {
            outputView.announcement();
            outputView.showProducts(productManager.getProducts());
            purchaseProduct();
            outputView.showReceipt(receipt);

            if (!checkAdditionalPurchase()) {
                break;
            }
        }
    }

    private void purchaseProduct() {
        int notPromotionPrice = 0;
        String[] cleanedSplitInput = inputView.readItem().replaceAll("[\\[\\]]", "").split(",");
        for (String item : cleanedSplitInput) {
            String[] purchase = item.split("-");
            int purchaseAmount = Integer.parseInt(purchase[1]);
            Product purchased = productManager.findProduct(purchase[0]);
            // 한번에 구매 가능한 경우
            if (purchased.getQuantity() >= purchaseAmount) {
                purchased.setQuantity(purchased.getQuantity() - purchaseAmount);
                receipt.addPurchasedProduct(purchased.getName(), purchaseAmount, purchased.getPrice());
                if (purchased.getPromotion().equals("null")) {
                    notPromotionPrice += purchaseAmount * purchased.getPrice();
                    continue;
                }
                Promotion promotion = productManager.findPromotion(purchased.getPromotion());
                if (!promotion.checkUsableDate()) {
                    notPromotionPrice += purchaseAmount * purchased.getPrice();
                    continue;
                }
                int buyProduct = promotion.getBuyProduct();
                int getProduct = promotion.getGetProduct();
                int promotionProduct = purchaseAmount / (buyProduct + getProduct);
                receipt.addFreeProduct(purchased.getName(),promotionProduct);
                receipt.addPromotionDiscount(promotionProduct * purchased.getPrice());
                System.out.println(buyProduct);
                System.out.println(getProduct);
                System.out.println(promotionProduct);
                continue;
            }
            System.out.println("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.");
        }

        if (checkMembershipDiscountApplied()) {
            // 멤버십 할인 적용 기능
            final double DISCOUNT_RATE = 0.3;
            final int MAX_DISCOUNT = 8000;
            int discountAmount = (int) (notPromotionPrice * DISCOUNT_RATE) + receipt.getPromotionDiscount();
            if (discountAmount > MAX_DISCOUNT) {
                discountAmount = MAX_DISCOUNT;
            }
            receipt.setMembershipDiscount(discountAmount);
        }
    }


    private boolean checkMembershipDiscountApplied() {
        String input = inputView.isMembershipDiscountApplied();
        while (true) {
            if (input.equals("Y") || input.equals("N")) {
                return input.equals("Y");
            }
            System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.\n");
            input = inputView.isMembershipDiscountApplied();
        }
    }

    private boolean checkAdditionalPurchase() {
        String input = inputView.isAdditionalPurchase();
        while (true) {
            if (input.equals("Y") || input.equals("N")) {
                return input.equals("Y");
            }
            System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.\n");
            input = inputView.isAdditionalPurchase();
        }
    }
}
