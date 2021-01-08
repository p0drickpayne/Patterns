package shop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {

    final ShoppingCart shoppingCart = new ShoppingCart();

    void putSomeItemsInShoppingCart() {
        shoppingCart.addCartItem(new ShoppingCartItem(new Product("Milk"), 9.99, 2));
        shoppingCart.addCartItem(new ShoppingCartItem(new Product("Bread"), 3.0, 3));
        shoppingCart.addCartItem(new ShoppingCartItem(new Product("Butter"), 44.95, 1));
    }

    @Test
    void payingFullPrice() {
        putSomeItemsInShoppingCart();
        assertThat(shoppingCart.streamCartItems().mapToInt(ShoppingCartItem::quantity).sum()).isEqualTo(6);
        assertThat(shoppingCart.calculatePrice()).isEqualTo(BigDecimal.valueOf(73.93));
    }
}
