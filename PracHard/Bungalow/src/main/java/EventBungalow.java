public class EventBungalow extends Bungalow {

    private int personen;
    private char ausstattung;

    public EventBungalow(int nummer, boolean frei, double grundpreis, int personen, char ausstattung) {
        super(nummer, frei, grundpreis);
        setPersonen(personen);
        setAusstattung(ausstattung);
    }

    public EventBungalow(String zeile) throws ResortException {
        super(zeile);
        String daten[] = zeile.split(";");
        if (daten.length != 6){
            throw new ResortException("Datensatz inkompatibel.");
        }
        try {
            setPersonen(Integer.parseInt(daten[4]));
        } catch (NumberFormatException e) {
            throw new ResortException("Keine gültige Zahl für Personen", e);
        }
        setAusstattung(daten[5].charAt(0));
    }

    public int getPersonen() {
        return personen;
    }

    public void setPersonen(int personen) {
        this.personen = personen;
    }

    public char getAusstattung() {
        return ausstattung;
    }

    public void setAusstattung(char ausstattung) {
        this.ausstattung = ausstattung;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventBungalow{");
        sb.append("personen=").append(personen);
        sb.append(", ausstattung=").append(ausstattung);
        sb.append('}');
        return super.toString() + " " + sb.toString();
    }
}
