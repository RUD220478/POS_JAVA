public class ReiseBus extends Bus {

    private boolean anhaenger;

    public ReiseBus(String fahrer, int plaetze, boolean anhaenger) throws BusException {
        super(fahrer, plaetze);
        setAnhaenger(anhaenger);
    }

    public boolean hatAnhaenger() {
        return anhaenger;
    }

    public void setAnhaenger(boolean anhaenger) {
        this.anhaenger = anhaenger;
    }

    @Override
    public double getUmsatz() {
        if (anhaenger == true){
            return getPlaetze() * 50 + 400;
        } else {
            return getPlaetze() * 50;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReiseBus{");
        sb.append("anhaenger=").append(anhaenger);
        sb.append('}');
        return super.toString() + " " + sb.toString();
    }
}
