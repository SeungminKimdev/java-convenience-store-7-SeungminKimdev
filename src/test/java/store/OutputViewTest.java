package store;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class OutputViewTest {
    OutputView outputView;
    List<Product> productList;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        outputView = new OutputView();
        productList = new ArrayList<>();
        productList.add(new Product("Test", "1000", "4", "프로모션"));
        productList.add(new Product("Test", "900", "0", "null"));

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void 정상_출력_테스트() {
        outputView.showProducts(productList);

        String capturedOutput = outputStreamCaptor.toString().trim();

        String expectedOutput =
                "- Test 1,000원 4개 프로모션\n" +
                        "- Test 900원 재고 없음";

        // 실제 출력된 결과와 예상 결과를 비교
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput);
    }
}