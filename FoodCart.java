import java.util.Scanner;
class Item {
    String name;
    double price;
    int time;
    String allergyInfo;
    Item(String name, double price, int time, String allergyInfo) {
        this.name = name;
        this.price = price;
        this.time = time;
        this.allergyInfo = allergyInfo;
    }
}
class FoodDelivery {
    Item[] cart = new Item [0];
    double totalPrice = 0;
    int totalTime = 0;
    void addItem(Item item) {
        Item[] newCart = new Item[cart.length + 1];
        for (int i = 0; i < cart.length; i++) {
            newCart[i] = cart[i];
        }
        newCart[cart.length] = item;
        cart = newCart;
        totalPrice = totalPrice +item.price;
        totalTime = totalTime +item.time;
        System.out.println(item.name + " added to cart.\nItem Price: Rs. " + item.price + "\nAllergy Information: "+ item.allergyInfo + ".\nTotal Price: Rs." + totalPrice + "\nTotal Time: " + formatTime(totalTime));
    }
    void viewCart() {
        if (cart.length == 0) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("\nItems in your cart:");
        for (Item i : cart) {
            System.out.println(i.name + " : Rs." + i.price + " Time Taken: "+i.time+" min");
        }
        System.out.println("Total Price: Rs." + totalPrice);
        System.out.println("Total Delivery Time: " + formatTime(totalTime));
    }
    void checkout() {
        if (cart.length == 0) {
            System.out.println("Your cart is empty. Add some items before checkout.");
            return;
        }
        System.out.println("\nCheckout");
        viewCart();  
        System.out.println("Do you want to confirm your order? (yes/no)");
        Scanner sc = new Scanner(System.in);
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            System.out.println("Order Confirmed! It will be delivered in " + formatTime(totalTime));
        } else {
            System.out.println("Order Cancelled. You can continue shopping.");
        }
    }
    
    String formatTime(int minutes) {
        if (minutes < 60) {
            return minutes + " minutes";
        } else {
            int hours = minutes / 60;
            int mins = minutes % 60;
            return hours + " hr " + mins + " min";
        }
    }
}
public class FoodCart{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Item i1 = new Item("Burger", 350,30,"Contains gluten, dairy");
        Item i2 = new Item("Pizza", 400,45,"Contains cheese, gluten");
        Item i3 = new Item("Roti", 12.50,10,"Contains gluten");
        Item i4 = new Item("Paneer Butter Masala",400,45,"Contains dairy, nuts");
 

        FoodDelivery cart = new FoodDelivery();
        while (true){
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Burger");
            System.out.println("2. Add Pizza");
            System.out.println("3. Add Roti");
            System.out.println("4. Add Panner Butter Masala");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("Choose an option: ");
            System.out.println();
            int choice = sc.nextInt();
            switch(choice){
                case 1:
					cart.addItem(i1);
					break;
                case 2:
					cart.addItem(i2);
					break;
                case 3:
					cart.addItem(i3);
					break;
                case 4:
                    cart.addItem(i4);
                    break;
                case 5:
					cart.viewCart();
					break;
                case 6:
                    cart.checkout();
                    System.out.println("Thank you for visiting!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
