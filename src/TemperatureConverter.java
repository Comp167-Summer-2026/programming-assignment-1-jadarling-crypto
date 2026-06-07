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
                boolean validTemp = true;
                boolean decimalUsed = false;
                boolean digitFound = false;
                int start = 0;

                if (tempInput.startsWith("-")) start = 1;

                for (int i = start; i < tempInput.length(); i++) {
                    char ch = tempInput.charAt(i);

                    if (ch == '.') {
                        if (decimalUsed) validTemp = false;
                        decimalUsed = true;
                    } else if (Character.isDigit(ch)) {
                        digitFound = true;
                    } else {
                        validTemp = false;
                    }
                }

                if (!digitFound) validTemp = false;

                if (!validTemp) {
                    System.out.println("Invalid input. Please enter a numeric temperature.");
                } else {
                    double temperature = Double.parseDouble(tempInput);
                    boolean validUnit = false;
                    String unit = "";

                    while (!validUnit) {
                        System.out.println("Enter unit (C or F):");
                        unit = scnr.nextLine().trim();

                        if (unit.equalsIgnoreCase("C") || unit.equalsIgnoreCase("F")) {
                            validUnit = true;
                        } else {
                            System.out.println("Invalid unit. Please enter C or F.");
                        }
                    }
                    double result = convertTemperature(temperature, unit);

                    if (unit.equalsIgnoreCase("C")) {
                        System.out.printf("%.2f\u00B0C is equal to %.2f\u00B0F\n", temperature, result);
                    } else {
                        System.out.printf("%.2f\u00B0F is equal to %.2f\u00B0C\n", temperature, result);
                    }
                }
            }
        }

        scnr.close();
    }

    public static double convertTemperature(double temperature, String unit) {
        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9.0 / 5.0) + 32.0;
        } else {
            return (temperature - 32.0) * 5.0 / 9.0;
        }
    }
}
