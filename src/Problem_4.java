import java.util.*;

class Portfolio{
    String text;
    int percent;

    Portfolio(String text,int percent){
        this.text = text;
        this.percent = percent;
    }
    public String toString(){
        return text+ " : " +percent+ "%";
    }
}
public class Problem_4 {
    static void mergeSort(Portfolio[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid - 1);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(Portfolio[] arr, int left, int mid, int right) {
        Portfolio[] temp = new Portfolio[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i].percent <= arr[j].percent) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    static void quickSort(Portfolio[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Portfolio[] arr, int low, int high) {
        int pivot = arr[high].percent;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].percent > pivot) {
                i++;
                Portfolio temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Portfolio temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        Portfolio[] portfolios = {
                new Portfolio("AAPL", 12),
                new Portfolio("TSLA", 8),
                new Portfolio("GOOG", 15)
        };
        mergeSort(portfolios, 0, portfolios.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(portfolios));

        quickSort(portfolios, 0, portfolios.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(portfolios));
    }
}

