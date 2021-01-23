package shop.rabatt;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

public class BilligastGratis implements StrategiMonster {

    String rabatt;
    double lagst = 0;

    @Override
    public BigDecimal rabatt(Set<ShoppingCartItem> items) {
        var summa = BigDecimal.ZERO;
        for(var item: items) {
            if(items.size() > 3 && lagst == 0 || item.itemCost().doubleValue() < lagst) {
                lagst = item.itemCost().doubleValue();
                rabatt = item.product().name();
            }
            summa = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(summa);
        }
        return summa.subtract((new BigDecimal(lagst)));
    }

    @Override
    public String rabattMangd() {
        String string = String.valueOf(lagst);
        return string;
    }

    @Override
    public String namn() {
        return "- 1x " + rabatt;
    }
}
