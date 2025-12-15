import java.util.jar.JarEntry;

public class Methods {
    private String value;
    public void validate(String value){
        try {
            int number = Integer.parseInt(value);
            System.out.println("Ok, number = " + number);
        } catch (NumberFormatException e) {
            System.out.println("NOT a number");
        }
    }

}
