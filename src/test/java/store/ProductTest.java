package store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("Test", "1000", "4", "프로모션");
    }

    @Test
    public void 생성자_활용_초기화_테스트() {
        assertEquals("Test", product.getName());
        assertEquals(1000, product.getPrice());
        assertEquals(4, product.getQuantity());
        assertEquals("프로모션", product.getPromotion());
    }

    @Test
    public void 상품_갯수_줄이기_테스트() {
        product.setQuantity(5);
        assertEquals(5, product.getQuantity());
    }
}