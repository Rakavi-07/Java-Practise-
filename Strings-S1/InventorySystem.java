class Product {
    // Instance variables
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String supplierName;
    private String category;

    // Static variables
    private static int productCounter = 0;
    private static int totalProducts = 0;
    private static double totalInventoryValue = 0;
    private static int lowStockCount = 0;
    private static String[] categories = new String[50]; // track categories
    private static int categoryCount = 0;

    // Constructor
    public Product(String productName, double price, int quantity, String supplierName, String category) {
        this.productId = generateProductId();
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.category = category;

        totalProducts++;
        if (!categoryExists(category)) {
            categories[categoryCount++] = category;
        }
    }

    // Generate product ID
    private static String generateProductId() {
        productCounter++;
        return String.format("P%03d", productCounter); // P001, P002...
    }

    // Check if category already exists
    private static boolean categoryExists(String category) {
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }

    // Instance methods
    public void addStock(int qty) {
        if (qty > 0) {
            quantity += qty;
            System.out.println(qty + " units added to " + productName);
        } else {
            System.out.println("Invalid stock addition!");
        }
    }

    public void reduceStock(int qty) {
        if (qty <= 0) {
            System.out.println("Quantity must be positive!");
        } else if (qty > quantity) {
            System.out.println("Not enough stock to reduce!");
        } else {
            quantity -= qty;
            System.out.println(qty + " units sold from " + productName);
        }
    }

    public boolean isLowStock() {
        return quantity < 10;
    }

    public double calculateProductValue() {
        return price * quantity;
    }

    public void updatePrice(double newPrice) {
        if (newPrice > 0) {
            price = newPrice;
            System.out.println("Price updated for " + productName);
        } else {
            System.out.println("Invalid price!");
        }
    }

    public void displayProductInfo() {
        System.out.println("Product ID    : " + productId);
        System.out.println("Name          : " + productName);
        System.out.println("Price         : " + price);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Supplier      : " + supplierName);
        System.out.println("Category      : " + category);
        System.out.println("Value         : " + calculateProductValue());
        System.out.println("Low Stock?    : " + (isLowStock() ? "Yes" : "No"));
        System.out.println("----------------------------------");
    }

    // Static methods
    public static void calculateTotalInventoryValue(Product[] products) {
        totalInventoryValue = 0;
        for (Product p : products) {
            if (p != null) {
                totalInventoryValue += p.calculateProductValue();
            }
        }
        System.out.println("Total Inventory Value: " + totalInventoryValue);
    }

    public static void findLowStockProducts(Product[] products) {
        System.out.println("=== Low Stock Products (<10 units) ===");
        lowStockCount = 0;
        for (Product p : products) {
            if (p != null && p.isLowStock()) {
                p.displayProductInfo();
                lowStockCount++;
            }
        }
        if (lowStockCount == 0) {
            System.out.println("No products are in low stock.");
        }
    }

    public static void generateInventoryReport(Product[] products) {
        System.out.println("=== Inventory Report ===");
        for (Product p : products) {
            if (p != null) {
                p.displayProductInfo();
            }
        }
        calculateTotalInventoryValue(products);
        findLowStockProducts(products);
        System.out.println("Total Products: " + totalProducts);
        System.out.print("Categories: ");
        for (int i = 0; i < categoryCount; i++) {
            System.out.print(categories[i] + (i < categoryCount - 1 ? ", " : ""));
        }
        System.out.println();
    }

    // Search product by name
    public static Product searchProduct(Product[] products, String name) {
        for (Product p : products) {
            if (p != null && p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}


public class InventorySystem {
    public static void main(String[] args) {
        // Create products (array of products)
        Product[] products = new Product[5];
        products[0] = new Product("Laptop", 55000, 15, "Dell Supplier", "Electronics");
        products[1] = new Product("Mouse", 500, 8, "HP Supplier", "Accessories");
        products[2] = new Product("Keyboard", 1200, 20, "Logitech Supplier", "Accessories");
        products[3] = new Product("Phone", 30000, 5, "Samsung Supplier", "Electronics");
        products[4] = new Product("Chair", 2500, 50, "Ikea Supplier", "Furniture");

        // Display inventory
        Product.generateInventoryReport(products);

        // Stock management
        products[0].reduceStock(2);
        products[1].addStock(20);
        products[3].reduceStock(3);

        // Update price
        products[2].updatePrice(1500);

        // Search product
        System.out.println("\n=== Search Result ===");
        Product found = Product.searchProduct(products, "Phone");
        if (found != null) {
            found.displayProductInfo();
        } else {
            System.out.println("Product not found!");
        }

        // Final report
        Product.generateInventoryReport(products);
    }
}
