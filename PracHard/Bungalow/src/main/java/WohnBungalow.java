public class WohnBungalow extends Bungalow {
    private int betten;
    private char kategorie;
    private boolean meerblick;

    public WohnBungalow(int nummer, boolean frei, double grundpreis, int betten, char kategorie, boolean meerblick) {
        super(nummer, frei, grundpreis);
        setBetten(betten);
        setKategorie(kategorie);
        setMeerblick(meerblick);
    }

    public WohnBungalow(String zeile) throws ResortException {
        super(zeile);
        String daten[] = zeile.split(";");

        if (daten.length != 7){
            throw new ResortException("Daten inkompatibel.");
        }

        try {
            setBetten(Integer.parseInt(daten[4]));
        } catch (NumberFormatException e) {
            throw new ResortException("Anzahl Betten ist keine Zahl.", e);
        }
        setKategorie(daten[5].charAt(0));
        setMeerblick(Boolean.parseBoolean(daten[6]));
    }

    public int getBetten() {
        return betten;
    }

    public void setBetten(int betten) {
        this.betten = betten;
    }

    public char getKategorie() {
        return kategorie;
    }

    public void setKategorie(char kategorie) {
        this.kategorie = kategorie;
    }

    public boolean isMeerblick() {
        return meerblick;
    }

    public void setMeerblick(boolean meerblick) {
        this.meerblick = meerblick;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WohnBungalow{");
        sb.append("betten=").append(betten);
        sb.append(", kategorie=").append(kategorie);
        sb.append(", meerblick=").append(meerblick);
        sb.append('}');
        return super.toString() + " " + sb.toString();
    }
}
