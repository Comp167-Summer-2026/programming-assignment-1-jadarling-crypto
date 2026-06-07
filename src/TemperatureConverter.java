import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Enter a temperature (or 'stop' to quit)");
            String input = scnr.nextLine().trim();

            if (input.toLowerCase().equals("stop")) {
                running = false;
            } else {

                String numberPart = "";
                String leftoverPart = "";
                int i = 0;

                if (i < input.length() && input.charAt(i) == '-') {
                    numberPart += input.charAt(i);
                    i++;
                }

                while (i < input.length() && (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.')) {
                    numberPart += input.charAt(i);
                    i++;
                }

                leftoverPart = input.substring(i).trim();

                Scanner lineScanner = new Scanner(numberPart);

                if (lineScanner.hasNextDouble()) {
                    double temperature = lineScanner.nextDouble();
                    String unit = "";

                    if (!leftoverPart.isEmpty()) {
                        unit = leftoverPart.toUpperCase();

                        if (unit.equals("C") || unit.equals("F")) {
                            double result = convertTemperature(temperature, unit);
                            if (unit.equals("C")) {
                                System.out.printf("%.2f\u00B0C is equal to %.2f\u00B0F\n", temperature, result);
                            } else {
                                System.out.printf("%.2f\u00B0F is equal to %.2f\u00B0C\n", temperature, result);
                            }
                        } else {
                            System.out.println("Invalid unit. Please enter C or F.");
                        }

                    } else {
                        boolean validUnit = false;
                        while (!validUnit) {
                            System.out.println("Enter unit (C or F):");
                            unit = scnr.nextLine().trim().toUpperCase();

                            if (unit.equals("C") || unit.equals("F")) {
                                validUnit = true;
                                double result = convertTemperature(temperature, unit);
                                if (unit.equals("C")) {
                                    System.out.printf("%.2f\u00B0C is equal to %.2f\u00B0F\n", temperature, result);
                                } else {
                                    System.out.printf("%.2f\u00B0F is equal to %.2f\u00B0C\n", temperature, result);
                                }
                            } else {
                                System.out.println("Invalid unit. Please enter C or F.");
                            }
                        }
                    }

                } else {
                    System.out.println("Invalid input. Please enter a numeric temperature.");
                }

                lineScanner.close();
            }
        }

        scnr.close();
        System.out.println("Goodbye!");
    }

    public static double convertTemperature(double temperature, String unit) {
        if (unit.equals("C")) {
            return (temperature * 9.0 / 5.0) + 32;
        } else {
            return (temperature - 32) * 5.0 / 9.0;
        }
    }
}
