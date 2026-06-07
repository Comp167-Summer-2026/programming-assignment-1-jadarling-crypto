import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("Enter a temperature (or 'stop' to quit)");
            String tempInput = scnr.nextLine().trim();

            if (tempInput.equalsIgnoreCase("stop")) {
                running = false;
            } else {
                boolean valid = true;
                boolean decimalUsed = false;
                boolean digitFound = false;
                int start = 0;

                if (tempInput.startsWith("-")) start = 1;

                for (int i = start; i < tempInput.length(); i++) {
                    char ch = tempInput.charAt(i);

                    if (ch == '.') {
                        if (decimalUsed) valid = false;
                        decimalUsed = true;
                    } else if (Character.isDigit(ch)) {
                        digitFound = true;
                    } else {
                        valid = false;
                    }
                }

                if (!digitFound) valid = false;

                if (!valid) {
                    System.out.println("Invalid input. Please enter a numeric temperature.");
                } else {

                    double temperature = Double.parseDouble(tempInput);

                    boolean validUnit = false;
                    String unit = "";

                    while (!validUnit) {
                        System.out.println("Enter unit (C or F):");
                        unit = scnr.nextLine().trim().toUpperCase();

                        if (unit.equals("C") || unit.equals("F")) {
                            validUnit = true;
                        } else {
                            System.out.println("Invalid unit. Please enter C or F.");
                        }
                    }

                    double result = convertTemperature(temperature, unit);

                    if (unit.equals("C")) {
                        System.out.printf("%.2f°C is equal to %.2f°F\n", temperature, result);
                    } else {
                        System.out.printf("%.2f°F is equal to %.2f℃\n", temperature, result);
                    }
                }
            }
        }

        scnr.close();
    }

    public static double convertTemperature(double temperature, String unit) {
        if (unit.equals("C")) {
            return (temperature * 9.0 / 5.0) + 32.0;
        } else {
            return (temperature - 32.0) * 5.0 / 9.0;
        }
    }
}
// I went back and tuned some things because I think that I made it a litte too complex and I think this fixes it
