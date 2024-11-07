package store;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PromotionTest {
    private Promotion promotion;

    @BeforeEach
    public void setUp() {
        promotion = new Promotion("Test", "2", "4", "2024-10-14","2024-11-19");
    }

    @Test
    public void 생성자_활용_초기화_테스트() {
        assertEquals("Test", promotion.getName());
        assertEquals(2, promotion.getBuyProduct());
        assertEquals(4, promotion.getGetProduct());
        assertEquals(LocalDate.of(2024, 10, 14), promotion.getStartDate());
        assertEquals(LocalDate.of(2024, 11, 19), promotion.getEndDate());
    }
}