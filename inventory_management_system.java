import java.util.Scanner;

interface ProductItem {
    String getName();
    int getQuantity();
    void setName(String name);
    void setQuantity(int quantity);
}

class Product implements ProductItem {
    String name;
    int quantity;

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String n) {
        name = n;
    }

    public void setQuantity(int q) {
        quantity = q;
    }
}

class Inventory {
    Product[] products;
    int productCount;

    Inventory() {
        products = new Product[20];
        productCount = 0;
    }

    void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
            System.out.println("Added product: " + product.getName());
        } else {
            System.out.println("Inventory is full, cannot add more products.");
        }
    }

    void showInventory() {
        System.out.println("Inventory contains:");
        for (int i = 0; i < productCount; i++) {
            System.out.println("Product: " + products[i].getName() + ", Quantity: " + products[i].getQuantity());
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        // Add products to inventory
        System.out.print("Enter the number of products to add to the inventory: ");
        int numberOfProducts = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfProducts; i++) {
            Product product = new Product();
            System.out.print("Enter product name: ");
            product.setName(scanner.nextLine());
            System.out.print("Enter product quantity: ");
            product.setQuantity(scanner.nextInt());
            scanner.nextLine(); // Consume newline
            inventory.addProduct(product);
        }

        // Show inventory
        inventory.showInventory();

        scanner.close();
    }
}
