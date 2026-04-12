import java.util.ArrayList;

public class Problem_1 {
    static class Transaction {
        String id;
        double fee;
        String time;

        Transaction(String id, double fee, String time) {
            this.id = id;
            this.fee = fee;
            this.time = time;
        }

        public String toString() {
            return id + ":$" + fee + "@" + time;
        }
    }

    static void bubbleSort(ArrayList<Transaction> list) {
        int n = list.size();
        int passes = 0, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            passes++;
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }

            if (!swapped) {break; }
        }
    }

    static void insertionSort(ArrayList<Transaction> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).fee > key.fee) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    static void flagOutliers(ArrayList<Transaction> list) {
        System.out.println("\nHigh-fee Outliers (> $50):");
        boolean found = false;
        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.println("  WARNING: " + t);
                found = true;
            }
        }
        if (!found) System.out.println("  None found.");
    }

    public static void main(String[] args) {

        ArrayList<Transaction> small = new ArrayList<>();
        small.add(new Transaction("id1", 10.5, "10:00"));
        small.add(new Transaction("id2", 25.0, "09:30"));
        small.add(new Transaction("id3",  5.0, "10:15"));

        System.out.println("=== Bubble Sort ===");
        System.out.println("Before: " + small);
        bubbleSort(small);
        System.out.println("After:  " + small);
        flagOutliers(small);

        ArrayList<Transaction> medium = new ArrayList<>();
        medium.add(new Transaction("id1", 10.5, "10:00"));
        medium.add(new Transaction("id2", 25.0, "09:30"));
        medium.add(new Transaction("id3",  5.0, "10:15"));
        medium.add(new Transaction("id4", 75.0, "08:45")); // outlier

        System.out.println("\n=== Insertion Sort ===");
        System.out.println("Before: " + medium);
        insertionSort(medium);
        System.out.println("After:  " + medium);
        flagOutliers(medium);
    }
}