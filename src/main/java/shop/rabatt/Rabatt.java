package shop.rabatt;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Rabatt {
    private StrategiMonster strategiMonster;

    public Set<ShoppingCartItem> items = new HashSet<>();

    //public Discount(DiscountInterface discountInterface) {
       // this.discountInterface = discountInterface;
    //}

    public Rabatt(Set<ShoppingCartItem> shoppingCart) {
        this.items = shoppingCart;
    }

    public BigDecimal kollaRabatt(StrategiMonster strategiMonster) {
        this.strategiMonster = strategiMonster;
        BigDecimal summa = this.strategiMonster.rabatt(items);

        return summa;
    }

    public StrategiMonster bastaRabatt() {
        StrategiMonster nuvarandeRabatt = new IngenRabatt();

        ArrayList<StrategiMonster> arr = new ArrayList<StrategiMonster>();
        arr.add(new TreForTva());
        arr.add(new BilligastGratis());
        arr.add(new TioProcentRabatt());
        arr.add(new IngenRabatt());

        for(StrategiMonster discount: arr) {
            double kollaRabatt = discount.rabatt(items).doubleValue();

            if(nuvarandeRabatt.rabatt(items).doubleValue() > kollaRabatt) {
                nuvarandeRabatt = discount;
            }
        }

        return nuvarandeRabatt;
    }

    public String getName() {
        return strategiMonster.namn();
    }

    public String getDiscount() {
        return strategiMonster.rabattMangd();
    }
}
