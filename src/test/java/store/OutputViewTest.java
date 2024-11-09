package store;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import store.model.Product;
import store.model.Receipt;
import store.view.OutputView;

class OutputViewTest {
    OutputView outputView;
    Receipt receipt;
    List<Product> productList;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        outputView = new OutputView();
        receipt = new Receipt();
        productList = new ArrayList<>();
    }

    @Test
    public void 상품목록_정상_출력_테스트() {
        System.setOut(new PrintStream(outputStreamCaptor));
        productList.add(new Product("Test", "1000", "4", "프로모션"));
        productList.add(new Product("Test", "900", "0", "null"));
        outputView.showProducts(productList);

        String capturedOutput = outputStreamCaptor.toString().trim();

        String expectedOutput =
                "- Test 1,000원 4개 프로모션\n" +
                        "- Test 900원 재고 없음";

        // 실제 출력된 결과와 예상 결과를 비교
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput);
    }

    @Test
    public void 영수증_정상_출력_테스트() {
        receipt.addPurchasedProduct("콜라", 5, 1000);
        receipt.addFreeProduct("콜라", 4);

        outputView.showReceipt(receipt);
    }
}