import java.util.Scanner;
class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
class ShoppingCart {
    Product[] cart = new Product[0];
    void addProduct(Product product) {
        Product[] newCart = new Product[cart.length + 1];
        for (int i = 0; i < cart.length; i++) {
            newCart[i] = cart[i];
        }
        newCart[cart.length] = product;
        cart = newCart;
        System.out.println(product.name + " added to cart.");
    }
    void viewCart() {
        if (cart.length == 0) {
            System.out.println("Your cart is empty.");
            return;
        }
        double total = 0;
        System.out.println("\nItems in your cart:");
        for (Product p : cart) {
            System.out.println("- " + p.name + " : Rs." + p.price);
            total += p.price;
        }
        System.out.println("Total: Rs." + total);
    }
}
public class ShoppingCart{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Phone", 25000);
        Product p3 = new Product("Headphones", 2000);
        ShoppingCart cart = new ShoppingCart();
        while (true){
            System.out.println("\n=== Shopping Menu ===");
            System.out.println("1. Add Laptop");
            System.out.println("2. Add Phone");
            System.out.println("3. Add Headphones");
            System.out.println("4. View Cart");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
					cart.addProduct(p1);
					break;
                case 2:
					cart.addProduct(p2);
					break;
                case 3:
					cart.addProduct(p3);
					break;
                case 4:
					cart.viewCart();
					break;
                case 5:
                    System.out.println("Thank you for shopping!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
