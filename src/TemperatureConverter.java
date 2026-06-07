import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("Enter a temperature (or 'stop' to quit");
            String input = scnr.nextLine().trim();
            if(input.toLowerCase().equals("stop")){
                    running = false;
            }else {
                Scanner lineScanner = new Scanner(input);

                if(lineScanner.hasNextDouble()){
                    double temperature = lineScanner.nextDouble();

                    System.out.println("Enter unit (C or F):");
                    String unit = scnr.nextLine().trim().toUpperCase();

                    if(unit.equals("C") || unit.equals("F")){
                        double result =  convertTemperature(temperature, unit);

                        if(unit.equals("C")){
                            System.out.printf("%.2f°c is equal to %.2f°F%n", temperature, result);

                        }else{
                            System.out.printf("%.2f°F is equal to %.2f°C%n", temperature, result);
                        }
                    }else {
                        System.out.println("Invalid unit Please enter C or F");
                    }
                }else {
                    System.out.println("Invalid please. enter a numeric temperature");
                }
                lineScanner.close();
            }
        }
        scnr.close();
    }



    public static double convertTemperature(double temperature, String unit) {
        if(unit.equals("C")){
            return (temperature * 9.0/5.0) + 32;
        }else {
            return (temperature - 32) * 5.0/9.0;
        }
    }

}
