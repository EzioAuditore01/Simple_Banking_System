import java.util.Scanner;

class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    Scanner scanner = new Scanner(System.in);
    String input = (scanner.nextLine());



    public static double convertStringToDouble(String input) {

        try {
            Double.parseDouble(input);
        } catch (Exception e) {
            return 0;
        }

        return Double.parseDouble(input);
    }




}