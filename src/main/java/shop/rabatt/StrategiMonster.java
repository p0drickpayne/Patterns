package shop.rabatt;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface StrategiMonster {
    BigDecimal rabatt(Set<ShoppingCartItem> items);
    String rabattMangd();
    String namn();
}
