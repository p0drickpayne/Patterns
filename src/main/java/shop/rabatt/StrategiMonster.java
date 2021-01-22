package shop.rabatt;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface StrategiMonster {
    BigDecimal rabatt(ArrayList<ShoppingCartItem> items);
    String rabattMangd();
    String namn();
}
