package shop;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ShoppingCart {

    private final Set<ShoppingCartItem> items = new HashSet<>();

    public void addCartItem(ShoppingCartItem item){
        items.add(item);
    }

    public Stream<ShoppingCartItem> streamCartItems(){
        return items.stream();
    }

    public BigDecimal calculatePrice(){
        var sum = BigDecimal.ZERO;

        for (var item: items) {
            sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }
        return sum;
    }

    public void undo(){
        //Undo the latest change to the ShoppingCart
    }

    public void redo(){
        //Redo the latest change to the ShoppingCart
    }
}
