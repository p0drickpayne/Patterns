package shop.kontrollZ;

import java.util.Stack;

public class HistoriaHog {
    static Stack<HistoriaState> framHog = new Stack<>();
    static Stack<HistoriaState> bakatHog = new Stack<>();

    public void backa() {
        if(bakatHog.size() > 0) {
            framHog.push(bakatHog.peek());
            bakatHog.pop().backa.executeCommand();
        }
    }

    public void framat() {
        if(framHog.size() > 0) {
            bakatHog.push(framHog.peek());
            framHog.pop().framat.executeCommand();
        }
    }

    public static void addState(HistoriaState state) {
        bakatHog.push(state);
        framHog.clear();
    }
}
