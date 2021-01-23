package shop;

import shop.kontrollZ.HistoriaHog;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Create new items
        Product item1 = new Product("Brie");
        Product item2 = new Product("Comté");
        Product item3 = new Product("Gryuere");
        Product item4 = new Product("Fikonmarmelad");
        Product item5 = new Product("Bröd");

        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(item1, 21.50, 1);
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(item2, 14.50, 1);
        ShoppingCartItem shoppingCartItem3 = new ShoppingCartItem(item3, 29.00, 1);
        ShoppingCartItem shoppingCartItem4 = new ShoppingCartItem(item4, 99.00, 1);
        ShoppingCartItem shoppingCartItem5 = new ShoppingCartItem(item5, 28.50, 1);

        cart.addCartItem(shoppingCartItem1);
        cart.addCartItem(shoppingCartItem2);
        cart.addCartItem(shoppingCartItem3);
        cart.addCartItem(shoppingCartItem4);
        cart.addCartItem(shoppingCartItem5);

        HistoriaHog stack = new HistoriaHog();

        cart.backa(stack);
        cart.framat(stack);
        cart.backa(stack);
        cart.backa(stack);
        cart.backa(stack);

        // Change quantity
        shoppingCartItem1.setQuantity(3);

        cart.backa(stack);
        cart.framat(stack);

        // Print receipt
        System.out.println(cart.receipt());

    }
}
