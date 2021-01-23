package shop.kontrollZ;

public class HistoriaState {
    HistoriaInterface backa;
    HistoriaInterface framat;

    public HistoriaState(HistoriaInterface backa, HistoriaInterface framat) {
        this.backa = backa;
        this.framat = framat;
    }
}
