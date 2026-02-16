import org.junit.jupiter.api.Test;

class BusTest {

    @Test
    void testAddBusNeuSollTrueLiefern() {
        try {
            LinienBus t = new LinienBus("Alex", 30);
            LinienBus neuerBus = new LinienBus("Susi", 40);
            t.addBusse(neuerBus);
            System.out.println("Funktioniert.");
        } catch (BusException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testAddBusNullUebergebenSollExceptionLiefern() {
        try {
            LinienBus t = new LinienBus("Alex", 30);
            t.addBusse(null);
        } catch (BusException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testSetPlaetzeZuWenigSollExceptionLiefern() {
        try {
            new LinienBus("Werner", 15);
        } catch (BusException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testReadBusseFromFileSollFunktionieren() {
        try {
            LinienBus t = new LinienBus("Anker", 20);
            t.importBusse("busse.txt");
            System.out.println("Import erfolgreich.");
        } catch (BusException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testMaxSitzeSollKorrektesObjektLiefern() {
        try {
            LinienBus t = new LinienBus("Anker", 20);
            t.addBusse(new LinienBus("Klein", 25));
            t.addBusse(new ReiseBus("Gross", 120, true));
            Bus max = t.maxSitze();
            System.out.println("Größter Bus: " + max.getFahrer());
        } catch (BusException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testReiseBusToStringSollteAnhaengerAnzeigen() {
        try {
            ReiseBus r = new ReiseBus("Susi", 80, true);
            String output = r.toString();
            if (output.contains("true")) {
                System.out.println("ReiseBus toString zeigt Anhänger korrekt an.");
            }
        } catch (BusException e) {
            System.out.println(e.getMessage());
        }
    }

}