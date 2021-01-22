package shop.rabatt;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class IngenRabatt implements StrategiMonster {
    @Override
    public BigDecimal rabatt(ArrayList<ShoppingCartItem> items) {
        var sum = BigDecimal.ZERO;

        for (var item: items) {
            sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }

        return sum;
    }

    @Override
    public String rabattMangd() {
        return "";
    }

    @Override
    public String namn() {
        return "";
    }
}
