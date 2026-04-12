import java.util.ArrayList;
import java.util.Arrays;

public class Problem_2 {
    static class Client {
        String name;
        int riskScore;
        double balance;

        Client(String name, int riskScore, double balance) {
            this.name = name;
            this.riskScore = riskScore;
            this.balance = balance;
        }

        public String toString() {
            return name + "(risk=" + riskScore + ", bal=$" + balance + ")";
        }
    }
    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    // Swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    swaps++;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Swaps: " + swaps);
    }
    static void insertionSort(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;
            while (j >= 0 && (arr[j].riskScore < key.riskScore ||
                    (arr[j].riskScore == key.riskScore && arr[j].balance < key.balance))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    static void printTopN(Client[] arr, int n) {
        System.out.println("\nTop " + n + " Highest Risk Clients:");
        for (int i = 0; i < n && i < arr.length; i++) {
            System.out.println("  " + (i + 1) + ". " + arr[i]);
        }
    }

    public static void main(String[] args) {
        Client[] clients = {
                new Client("ClientC", 80, 15000),
                new Client("ClientA", 20, 50000),
                new Client("ClientB", 50, 30000),
        };
        Client[] bubbleArr = Arrays.copyOf(clients, clients.length);
        System.out.println("=== Bubble Sort (Ascending) ===");
        System.out.println("Before: " + Arrays.toString(bubbleArr));
        bubbleSort(bubbleArr);
        System.out.println("After:  " + Arrays.toString(bubbleArr));

        Client[] insertArr = Arrays.copyOf(clients, clients.length);
        System.out.println("\n=== Insertion Sort (Descending) ===");
        System.out.println("Before: " + Arrays.toString(insertArr));
        insertionSort(insertArr);
        System.out.println("After:  " + Arrays.toString(insertArr));

        printTopN(insertArr, 3);
    }
}