import javax.security.auth.Refreshable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Resort {
    private String name;
    private List<Bungalow> bungalows;

    public Resort(String name) {
        setName(name);
        // Die Liste muss initialisiert werden
        this.bungalows = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnzahlBungalows(){
        return bungalows.size();
    }

    public boolean addBungalow(Bungalow bungalow) throws ResortException {
        if (bungalow == null){
            throw new ResortException("Der übergebene Wart darf nicht Null sein.");
        }

        // Check if Bungalow already exists
        for (Bungalow b : bungalows){
            if (bungalow.getNummer() == b.getNummer()){
                throw new ResortException("Nummer existiert bereits");
            }
        }
        bungalows.add(bungalow);
        return true;
    }

    public boolean removeBungalow(Bungalow bungalow){
        if (bungalow == null){
            return false;
        }
        for (Bungalow b : bungalows){
            if (bungalow.getNummer() == b.getNummer()){
                bungalows.remove(b);
                return true;
            }
        }
        return false;
    }

    public void save(){

    }

    public void load(){

    }

    public void exportBungalows(String filename){

    }

    public List<Bungalow> importBungalows(String filename) throws ResortException {
        if (filename == null){
            throw new ResortException("Datei nicht gefunden.");
        }

        //FileReader fr;
        String zeile;
        //List<Bungalow> imported = new ArrayList<>();

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            zeile = br.readLine();
            while (zeile != null){
                if (zeile.startsWith("W")){
                    addBungalow(new WohnBungalow(zeile));
                } else {
                    if (zeile.startsWith("E")){
                        addBungalow(new EventBungalow(zeile));
                    }
                }
                zeile = br.readLine();
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            throw new ResortException("Datei nicht gefunden.");
        } catch (IOException e) {
            throw new ResortException("Nicht lesbar.");
        }

        for (Bungalow b : bungalows){
            System.out.println(b.toString());
        }
        return bungalows;
    }

}
