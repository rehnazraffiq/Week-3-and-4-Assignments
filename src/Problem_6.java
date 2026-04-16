import java.util.*;

public class Problem_6 {
    static void linearSearch(int[] arr, int key){
        int comp = 0;
        boolean found = false;

        for(int i = 0; i < arr.length; i++){
            comp++;
            if (arr[i] == key){
                found = true;
                break;
            }
        }
        System.out.println("\nLinear Search: ");
        System.out.println("Key found: " +found);
        System.out.println("Comparisons: " +comp);
    }
    static void binarySearch(int[] arr, int key){
        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1, comparison = 1;

        while(low <= high){
            comparison++;
            int mid = (low + high) / 2;
            if (arr[mid] == key){
                floor = ceil = arr[mid];
                break;
            }
            else if (arr[mid] < key){
                floor = arr[mid];
                low = mid + 1;
            }
            else{
                ceil = arr[mid];
                high = mid - 1;
            }
        }
        System.out.println("\nBinary Search: ");
        System.out.println("Floor: " +floor);
        System.out.println("Ceil: " +ceil);
        System.out.println("Comparisons: " +comparison);
    }
    public static void main(String[] args){
        int[] risks = {10, 25, 50, 100};
        System.out.println("Sorted risks: " +Arrays.toString(risks));
        linearSearch(risks, 30);
        binarySearch(risks, 30);
    }
}
