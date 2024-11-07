package store;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PromotionTest {
    private Promotion promotion;

    @BeforeEach
    public void setUp() {
        promotion = new Promotion("Test", "2", "4", "2024_10_14","2024_11_19");
    }

    @Test
    public void 생성자_활용_초기화_테스트() {
        assertEquals("Test", promotion.getName());
        assertEquals(2, promotion.getBuyProduct());
        assertEquals(4, promotion.getGetProduct());
        assertEquals("2024_10_14", promotion.getStartDate());
        assertEquals("2024_11_19", promotion.getEndDate());
    }
}