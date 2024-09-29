import java.util.ArrayList;
import java.util.Collections;

/**
 * StatisticalLibrary provides statistical calculations including
 * mean, median, minimum, and maximum values for a list of numbers.
 *
 * <p>This class contains methods to compute various statistics
 * on a list of {@code Double} numbers.</p>
 *
 * <h2>Applied Style Guide Rules:</h2>
 * <ul>
 *   <li>5.2.2 Class Names</li>
 *   <li>7.4.1 Method Names</li>
 *   <li>7.4.2 Variable Names</li>
 *   <li>7.6.1 Comment Formatting</li>
 *   <li>7.6.2 Javadoc Formatting</li>
 * </ul>
 *
 * @author Van Minh Dao
 * @version V1.0.1
 */
public class StatisticalLibrary {

    /**
     * Calculates the mean of the provided list of numbers.
     *
     * @param numbers   The list of numbers to calculate the mean from.
     * @param minCutOff The minimum cutoff value for calculations.
     * @param applyCutOff Whether to apply the cutoff.
     * @return The mean of the numbers.
     * @throws IllegalArgumentException if the list is null or empty,
     *                                  or if no valid numbers are found after applying the cutoff.
     *
     * <p>If {@code applyCutOff} is {@code true}, only numbers greater than or
     * equal to {@code minCutOff} will be included in the mean calculation.
     * If {@code applyCutOff} is {@code false}, all numbers will be included.</p>
     */
    public static double getMean(ArrayList<Double> numbers, double minCutOff, boolean applyCutOff) {
        // Check for null or empty list
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("The list must not be null or empty.");
        }

        double sum = 0; // Accumulator for the sum of valid numbers.
        int count = 0;  // Count of valid numbers.

        for (double number : numbers) {
            if (!applyCutOff || number >= minCutOff) {
                sum += number;
                count++;
            }
        }

        // Check if count is zero to avoid division by zero
        if (count == 0) {
            throw new IllegalArgumentException("No valid numbers to calculate the mean after applying the cutoff.");
        }

        return sum / count; // Calculate the mean.
    }

    /**
     * Calculates the median of the provided list of numbers.
     *
     * @param numbers The list of numbers to calculate the median from.
     * @return The median of the numbers.
     * @throws IllegalArgumentException if the list is null or empty.
     *
     * <p>The method sorts the numbers and calculates the median:
     * if the list has an odd number of elements, the middle element is returned.
     * If the list has an even number of elements, the average of the two middle elements is returned.</p>
     */
    public static double getMedian(ArrayList<Double> numbers) {
        // Check for null or empty list
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("The list must not be null or empty.");
        }

        Collections.sort(numbers); // Sort the list of numbers.
        double median;

        // Calculate median based on whether the count is odd or even
        if (numbers.size() % 2 == 1) {
            median = numbers.get(numbers.size() / 2);
        } else {
            median = (numbers.get((numbers.size() / 2) - 1) + numbers.get(numbers.size() / 2)) / 2;
        }

        return median; // Return the calculated median.
    }

    /**
     * Finds the minimum value in the provided list of numbers.
     *
     * @param numbers The list of numbers to find the minimum from.
     * @return The minimum value.
     * @throws IllegalArgumentException if the list is null or empty.
     *
     * <p>The method iterates through the numbers and keeps track of the smallest value found.</p>
     */
    public static double getMin(ArrayList<Double> numbers) {
        // Check for null or empty list
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("The list must not be null or empty.");
        }

        double min = numbers.getFirst(); // Initialize min to the first element.

        // Iterate through the numbers to find the minimum value
        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
        }

        return min; // Return the found minimum value.
    }

    /**
     * Finds the maximum value in the provided list of numbers.
     *
     * @param numbers The list of numbers to find the maximum from.
     * @return The maximum value.
     * @throws IllegalArgumentException if the list is null or empty.
     *
     * <p>The method iterates through the numbers and keeps track of the largest value found.</p>
     */
    public static double getMax(ArrayList<Double> numbers) {
        // Check for null or empty list
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("The list must not be null or empty.");
        }

        double max = numbers.getFirst(); // Initialize max to the first element.

        // Iterate through the numbers to find the maximum value
        for (double number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max; // Return the found maximum value.
    }

    /**
     * The main method to execute the statistical calculations.
     *
     * @param args Command line arguments (not used).
     *
     * <p>This method creates a sample dataset of {@code Double} values
     * and calls the statistical methods to demonstrate their functionality.</p>
     */
    public static void main(String[] args) {
        ArrayList<Double> data = new ArrayList<>();
        Collections.addAll(data, 25.5, 29.4, 36.7, 43.1, 57.9, 88.3, 99.9, 100.0);

        // Output statistical results
        System.out.println("Mean (without cutoff): " + getMean(data, 0, false));
        System.out.println("Mean (with cutoff 30): " + getMean(data, 30, true));
        System.out.println("Median: " + getMedian(data));
        System.out.println("Minimum: " + getMin(data));
        System.out.println("Maximum: " + getMax(data));
    }
}
