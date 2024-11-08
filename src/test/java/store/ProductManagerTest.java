package store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductManagerTest {
    private ProductManager manager;

    @BeforeEach
    public void setUp() {
        manager = new ProductManager();
    }

    @Test
    public void 상품정보_찾기_기능() {
        Product testProduct = manager.findProduct("콜라");
        assertEquals("콜라",testProduct.getName());
        assertEquals(1000,testProduct.getPrice());
        assertEquals(10,testProduct.getQuantity());
        assertEquals("탄산2+1",testProduct.getPromotion());
    }

    @Test
    public void 프로모션_정보_찾기_기능() {
        Promotion testPromotion = manager.findPromotion("탄산2+1");
        assertEquals("탄산2+1", testPromotion.getName());
        assertEquals(2, testPromotion.getBuyProduct());
        assertEquals(1, testPromotion.getGetProduct());
        assertEquals(LocalDate.of(2024, 1, 1), testPromotion.getStartDate());
        assertEquals(LocalDate.of(2024, 12, 31), testPromotion.getEndDate());
    }
}