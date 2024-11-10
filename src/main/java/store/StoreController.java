package store;

import store.model.Product;
import store.model.ProductManager;
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
            inputView.isMembershipDiscountApplied();
            outputView.showReceipt(receipt);

            if (!checkAdditionalPurchase()) {
                break;
            }
        }
    }

    private void purchaseProduct() {
        String[] cleanedSplitInput = inputView.readItem().replaceAll("[\\[\\]]", "").split(",");
        for (String item : cleanedSplitInput) {
            String[] purchase = item.split("-");
            int purchaseAmount = Integer.parseInt(purchase[1]);
            Product purchased = productManager.findProduct(purchase[0]);
            // 한번에 구매 가능한 경우
            if (purchased.getQuantity() >= purchaseAmount) {
                purchased.setQuantity(purchased.getQuantity() - purchaseAmount);
                receipt.addPurchasedProduct(purchased.getName(), purchaseAmount, purchased.getPrice());
            }
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
