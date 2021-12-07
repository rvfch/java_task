package cz.acamar.tasks;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Task2 {

    /**
     * Task 2. Squares of a sorted array.
     * <p>
     * Given an integer array sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order.
     * <p>
     * Example input: [-4,-1,0,3,10]
     * Expected output: [0,1,9,16,100]
     * <p>
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     *
     * @param input - an integer array sorted in non-decreasing order
     * @return - an array of the squares of each number sorted in non-decreasing order
     */

    // simplest example with java stream API
    public static int[] squaresOfSortedArray(int[] input) {
        // check if array exists
        if (input != null && input.length > 0) {
            // using Stream API box array to Integer array, then square every number using map, sort and map back to int array
            // Java Stream API's using dual-pivot quicksort algorithm, it's fastest one for large arrays
            return Arrays.stream(input).boxed().map(x -> x * x).sorted().mapToInt(i -> i).toArray();
        }
        return new int[] {};
    }

    // second solution, which I know from university, it needs smaller time to do same thing
    public static int[] squaresOfSortedArray2(int[] input) {
        if (input != null && input.length > 0) {
            int left = 0, right = input.length - 1;

            int[] res = new int[input.length];
            for (int i = input.length -1; i >= 0; i--) {
                // sort and square
                if (Math.abs(input[left]) > input[right]) {
                    // square
                    res[i] = input[left] * input[left];
                    left++;
                } else {
                    // square
                    res[i] = input[right] * input[right];
                    right--;
                }
            }
            return res;
        }
        return new int[] {};
    }


    public static void main(String[] args) {
        int[] arr = new int[] { -4, -2, -1, 0, 1, 2, 3, 4 };

        // measure time of 1st algorithm
        System.out.println("1st algorithm: ");
        //
        Instant start = Instant.now();
        System.out.println(Arrays.toString(squaresOfSortedArray(arr)));
        Instant end = Instant.now();
        //
        System.out.println("Time spent: " + Duration.between(start, end).toMillis() + "ms");

        // measure time of 2st algorithm
        System.out.println("2st algorithm: ");
        //
        Instant start2 = Instant.now();
        System.out.println(Arrays.toString(squaresOfSortedArray2(arr)));
        Instant end2 = Instant.now();
        //
        System.out.println("Time spent: " + Duration.between(start, end).toMillis() + "ms");

        // As we can see, both takes same time in millis.

    }
}
