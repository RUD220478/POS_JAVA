import org.junit.jupiter.api.Test;

class ResortTest {

    @Test
    void testAddBungalowNeuSollTrueLiefern() {
        Resort t = new Resort("Austria");
        EventBungalow bungalow = new EventBungalow(3, true, 700, 8, 'x');
        try {
            t.addBungalow(bungalow);
        } catch (ResortException e) {
            System.out.println(e.getMessage());;
        }
        System.out.println("Funktioniert.");
    }

    @Test
    void testAddBungalowNullUebergebenSollFalseLiefern() {
        Resort t = new Resort("Deutschland");
        WohnBungalow bungalow = null;
        try {
            t.addBungalow(bungalow);
        } catch (ResortException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testAddBungalowBestehtBereitsSollFalseLiefern() {
        Resort t = new Resort("Italien");
        Bungalow bungalow1 = new EventBungalow(3,true,800,12,'y');
        Bungalow bungalow2 = new EventBungalow(3,false,500,13,'z');
        try {
            t.addBungalow(bungalow1);
            t.addBungalow(bungalow2);
        } catch (ResortException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testReadBungalowFromFileSollFunktionieren() {
        // System.out.println(System.getProperty("user.dir"));
        Resort t = new Resort("ResortAusDatei");
        try {
            t.importBungalows("src/test/java/data_for_import.csv");
        } catch (ResortException e) {
            System.out.println(e.getMessage());
        }
    }
}