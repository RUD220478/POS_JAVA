public class Bungalow {

    private int nummer;
    private boolean frei;
    private double grundpreis;

    public Bungalow(int nummer, boolean frei, double grundpreis) {
        setNummer(nummer);
        setFrei(frei);
        setGrundpreis(grundpreis);
    }

    public Bungalow(String zeile) throws ResortException{
        String daten[];
        if (zeile == null){
            throw new ResortException("Ungültige Datenzeile.");
        }
        daten = zeile.split(";");
        if (daten.length < 4){
            throw new ResortException("Unvollständige Daten.");
        }
        try {
            setNummer(Integer.parseInt(daten[1]));
            setGrundpreis(Double.parseDouble(daten[3]));
        } catch (NumberFormatException e) {
            throw new ResortException("Daten ungültig.");
        }
        setFrei(Boolean.parseBoolean(daten[2]));
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public boolean isFrei() {
        return frei;
    }

    public void setFrei(boolean frei) {
        this.frei = frei;
    }

    public double getGrundpreis() {
        return grundpreis;
    }

    public void setGrundpreis(double grundpreis) {
        this.grundpreis = grundpreis;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bungalow{");
        sb.append("nummer=").append(nummer);
        sb.append(", frei=").append(frei);
        sb.append(", grundpreis=").append(grundpreis);
        sb.append('}');
        return sb.toString();
    }
}
