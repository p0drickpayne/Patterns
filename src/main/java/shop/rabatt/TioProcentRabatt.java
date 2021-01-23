package shop.rabatt;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

public class TioProcentRabatt implements StrategiMonster {

    String rabatt;

    @Override
    public BigDecimal rabatt(Set<ShoppingCartItem> items) {
        var summo = BigDecimal.ZERO;
        var allaVaror = BigDecimal.ZERO;

        for (var item: items) {
              allaVaror = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(allaVaror);
        }

        if(allaVaror.doubleValue() >= 500) {
            summo = allaVaror.multiply(BigDecimal.valueOf(0.90));
            BigDecimal x = allaVaror.multiply(BigDecimal.valueOf(0.10));
            rabatt = x.toString();
        } else {
            summo = allaVaror;
        }

        return summo;
    }

    @Override
    public String rabattMangd() {
        return "-" + rabatt;
    }

    @Override
    public String namn() {
        return "10% discount";
    }
}
