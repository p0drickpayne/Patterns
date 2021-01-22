package shop.rabatt;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Rabatt {
    private StrategiMonster strategiMonster;

    public ArrayList<ShoppingCartItem> items = new ArrayList<>();

    //public Discount(DiscountInterface discountInterface) {
       // this.discountInterface = discountInterface;
    //}

    public Rabatt(ArrayList<ShoppingCartItem> shoppingCart) {
        this.items = shoppingCart;
    }

    public BigDecimal kollaRabatt(StrategiMonster strategiMonster) {
        this.strategiMonster = strategiMonster;
        BigDecimal summa = this.strategiMonster.rabatt(items);

        return summa;
    }

    public StrategiMonster bestDiscount() {
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
