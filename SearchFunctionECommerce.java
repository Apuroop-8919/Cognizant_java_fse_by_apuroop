import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String toString() {
            return "ProductID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productName) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = productName.compareToIgnoreCase(products[mid].productName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) right = mid - 1;
            else left = mid + 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Shoes", "Fashion"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Tablet", "Electronics")
        };

        String searchTerm = "Phone";
        Product resultLinear = linearSearch(products, searchTerm);
        System.out.println("Linear Search Result: " + (resultLinear != null ? resultLinear : "Not Found"));

        Product resultBinary = binarySearch(products, searchTerm);
        System.out.println("Binary Search Result: " + (resultBinary != null ? resultBinary : "Not Found"));
    }
}
