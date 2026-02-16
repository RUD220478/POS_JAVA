import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Bus {

    private String fahrer;
    private int plaetze;
    private ArrayList<Bus> busse;

    public Bus(String fahrer, int plaetze) throws BusException {
        setFahrer(fahrer);
        setPlaetze(plaetze);
        this.busse = new ArrayList<>();
    }

    public boolean addBusse(Bus bus) throws BusException {
        if (bus == null) {
            throw new BusException("Übergebener Bus ist null");
        } else {
            busse.add(bus);
            return true;
        }

    }

    public Bus maxSitze() throws BusException{
        if (busse.size() > 0){
            int max = 0;
            Bus groessterBus = null;
            for (Bus e : busse){
                if (e.getPlaetze() > max){
                    max = e.getPlaetze();
                    groessterBus = e;
                }
            }
            return groessterBus;
        } else {
            throw new BusException("Übergebene Liste ist leer.");
        }
    }

    public abstract double getUmsatz();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bus{");
        sb.append("fahrer='").append(fahrer).append('\'');
        sb.append(", plaetze=").append(plaetze);
        sb.append('}');
        return sb.toString();
    }

    public String getFahrer() {
        return fahrer;
    }

    public void setFahrer(String fahrer) {
        this.fahrer = fahrer;
    }

    public int getPlaetze() {
        return plaetze;
    }

    public void setPlaetze(int plaetze) throws BusException{
        if (plaetze < 20){
            throw new BusException("Anzahl Plätze muss mindestens 20 sein.");
        } else {
            this.plaetze = plaetze;
        }
    }

    public void importBusse(String filename) throws BusException {
        if (filename == null || filename.isEmpty()) {
            throw new BusException("Dateiname ungültig");
        } else {
            String zeile;
            String[] daten;
            try {
                FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr);
                zeile = br.readLine();
                while (zeile != null) {
                    daten = zeile.split(";");
                    if (zeile.startsWith("L")) {
                        addBusse(new LinienBus(daten[1], Integer.parseInt(daten[2])));
                    } else {
                        if (zeile.startsWith("R")) {
                            boolean anhaenger = daten[3].equals("Y");
                            addBusse(new ReiseBus(daten[1], Integer.parseInt(daten[2]), anhaenger));
                        }
                    }
                    zeile = br.readLine();
                }
                br.close();
                fr.close();
            } catch (FileNotFoundException e) {
                throw new BusException("Datei nicht gefunden");
            } catch (IOException e) {
                throw new BusException("Datei kann nicht gelesen werden.");
            }

        }
    }
}
