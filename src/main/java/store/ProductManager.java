package store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();
    private List<Promotion> promotions = new ArrayList<>();

    public ProductManager() {
        loadProducts();
        loadPromotions();
    }

    private void loadProducts() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/products.md"))) {
            String line;

            if ((line = br.readLine()) != null) {
                // 첫 줄 건너뛰기
            }
            
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] productInfo = line.split(",");
                    products.add(new Product(productInfo[0], productInfo[1], productInfo[2], productInfo[3]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽을 수 없습니다.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("products 파일에 형식이 맞지 않는 값이 있습니다.");
        }
    }

    private void loadPromotions() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/promotions.md"))) {
            String line;

            if ((line = br.readLine()) != null) {
                // 첫 줄 건너뛰기
            }

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] promotionInfo = line.split(",");
                    promotions.add(new Promotion(promotionInfo[0], promotionInfo[1], promotionInfo[2], promotionInfo[3], promotionInfo[4]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽을 수 없습니다.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("products 파일에 형식이 맞지 않는 값이 있습니다.");
        }
    }

    public Product findProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        throw new IllegalArgumentException("상품이 없습니다.");
    }

    public Promotion findPromotion(String promotionName) {
        for (Promotion promotion : promotions) {
            if (promotion.getName().equals(promotionName)) {
                return promotion;
            }
        }
        throw new IllegalArgumentException("없는 프로모션입니다.");
    }
}
