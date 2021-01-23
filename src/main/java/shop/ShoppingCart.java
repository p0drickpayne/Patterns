package shop;

import shop.rabatt.*;
import shop.kontrollZ.HistoriaHog;
import shop.kontrollZ.HistoriaState;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShoppingCart {

    private final Set<ShoppingCartItem> items = new HashSet<>();

    public void addCartItem(ShoppingCartItem item){
        items.add(item);
        addToStack(item);
    }
    public void addToStack(ShoppingCartItem item) {
        HistoriaHog.addState(new HistoriaState(() -> {
            items.remove(item);
        }, () -> {
            items.add(item);
        }));
    }

    public Stream<ShoppingCartItem> stream(){
        return items.stream();
    }

    public Kvitto calculatePrice(){
        System.out.println("calculateprice");
        Rabatt rabatt = new Rabatt(items);
        StrategiMonster bastaRabatt = rabatt.bastaRabatt();
        BigDecimal addedDiscount = rabatt.kollaRabatt(bastaRabatt);
        System.out.println("calculateprice");
        Kvitto kvitto = new Kvitto(addedDiscount, rabatt.getName(), rabatt.getDiscount());
        System.out.println("calculateprice");
        return kvitto;
    }


    public class Kvitto {
        BigDecimal summa = BigDecimal.ZERO;
        String namn;
        String rabatt;

        public Kvitto(BigDecimal summa, String namn, String rabatt){
            this.summa = summa;
            this.namn = namn;
            this.rabatt = rabatt;
        }
    }

    public void backa(HistoriaHog hog){
        hog.backa();
    }

    public void framat(HistoriaHog hog){
        hog.framat();
    }

    public String receipt() {
        System.out.println("reciept");
        String line = "--------------------------------\n";
        StringBuilder sb = new StringBuilder();
        sb.append(line);
        var list = items.stream()
                .sorted(Comparator.comparing(item -> item.product().name()))
                .collect(Collectors.toList());
        for (var each : list) {
            sb.append(String.format("%-4s %-18s % 8.2f\n",  each.quantity() + "x", each.product().name(), each.itemCost()));
        }
        sb.append(line);

        if(calculatePrice().namn != "") {
            sb.append(String.format("%-24s %7s \n", calculatePrice().namn, calculatePrice().rabatt));
        }

        sb.append(String.format("%24s% 8.2f", "TOTAL:", calculatePrice().summa));
        return sb.toString();
    }
}

