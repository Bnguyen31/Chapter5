import java.io.*;
import java.util.*;

public class NumberStats {

    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();

        // Reading numbers from Book1.csv
        try (Scanner input = new Scanner(new File("C:\\Users\\greyb\\IdeaProjects\\Chapter5\\src\\Book1.csv"))) {
            while (input.hasNextDouble()) {
                numbers.add(input.nextDouble());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return;
        }

        if (numbers.isEmpty()) {
            System.out.println("No data to process.");
            return;
        }

        // Calculating statistics for the average
        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        double min = Collections.min(numbers);
        double max = Collections.max(numbers);
        double average = sum / numbers.size();

        // Writing results to the stats.txt
        try (PrintWriter writer = new PrintWriter("stats.txt")) {
            writer.println("The sum of the numbers is: " + sum);
            writer.println("The lowest number is: " + min);
            writer.println("The highest number is: " + max);
            writer.println("The average of the numbers is: " + average);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
