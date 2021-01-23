package shop.rabatt;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

public class TreForTva implements StrategiMonster {
    String discount;

    @Override
    public BigDecimal rabatt(Set<ShoppingCartItem> items) {
        var sum = BigDecimal.ZERO;

        for (var item: items) {
            if(item.quantity() > 2 && item.quantity() < 4) {
                sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum).subtract(item.itemCost());
                discount = item.itemCost().toString();
            } else {
                sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
            }
        }

        return sum;
    }

    @Override
    public String rabattMangd() {
        return "-"+ discount;
    }

    @Override
    public String namn() {
        return "3 for 2";
    }

}
