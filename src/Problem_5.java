import java.util.*;

public class Problem_5 {
    static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1, comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First index = " +first);
        System.out.println("Last index = " +last);
        System.out.println("Comparisons = " +comparisons);
    }

    static int binarySearch(String[] arr, String target, int[] comp) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            comp[0]++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                return mid;
            }
            else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int countOccurrences(String[] arr, int index, String target, int[] comp) {
        if (index == -1) return 0;

        int count = 1;

        int i = index - 1;
        while (i >= 0 && arr[i].equals(target)) {
            comp[0]++;
            count++;
            i--;
        }

        i = index + 1;
        while (i < arr.length && arr[i].equals(target)) {
            comp[0]++;
            count++;
            i++;
        }

        return count;
    }

    public static void main(String[] args) {

        String[] logs = {"accA", "accB", "accB", "accC"}; // sorted
        linearSearch(logs, "accB");

        int[] comparisons = {0};
        int index = binarySearch(logs, "accB", comparisons);
        int count = countOccurrences(logs, index, "accB", comparisons);

        System.out.println("\nBinary Search:");
        System.out.println("Found index = " + index);
        System.out.println("Count = " + count);
        System.out.println("Comparisons = " + comparisons[0]);
    }
}