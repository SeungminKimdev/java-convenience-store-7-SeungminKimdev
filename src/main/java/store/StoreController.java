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
        outputView.announcement();
        purchaseProduct();
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
                receipt.addPurchasedProduct(purchased.getName(), purchased.getQuantity(), purchased.getPrice());
            }
        }
    }
}
