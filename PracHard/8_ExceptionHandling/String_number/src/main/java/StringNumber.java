public class StringNumber {
    private String userInput;

    public StringNumber(String userInput){
        setUserInput(userInput);
    }

    public String setUserInput(String userInput) throws NullPointerException {
        try {
            if (userInput.contains("e")){
                System.out.println("e has been found");
            } else {
                throw new RuntimeException("e was NOT found");
            }
        }
        catch (NullPointerException e) {

        }
        return this.userInput;
    }
}
