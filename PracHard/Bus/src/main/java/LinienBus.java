public class LinienBus extends Bus {

    public LinienBus(String fahrer, int plaetze) throws BusException {
        super(fahrer, plaetze);
    }

    @Override
    public double getUmsatz() {
        return getPlaetze() * 2.5;
    }


}
