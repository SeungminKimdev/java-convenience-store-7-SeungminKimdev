package store;

public class StoreController {
    private InputView inputView;
    private ProductManager productManager;

    public StoreController() {
        inputView = new InputView();
        productManager = new ProductManager();
    }

    private void purchaseProduct() {
        inputView.readItem();
    }
}
