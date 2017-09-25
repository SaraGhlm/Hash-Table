package searchbyphonenumber;

import java.util.Random;

public class QuickSort {
    
    int start;
    int end;
    int[] queryArray;

    public QuickSort(int start, int end, int[] queryArray) {
        this.start = start;
        this.end = end;
        this.queryArray = queryArray;
    }

    public int[] getArray() {
        quickSort(start, end);
        return queryArray;
    }

    private void quickSort(int p, int r) {
        if (p < r) {
            int q = randomizedPartition(p, r);
            quickSort(p, q - 1);
            quickSort(q + 1, r);
        }
    }

    private int randomizedPartition(int p, int r) {
        Random rand = new Random();
        int i = rand.nextInt(r - p + 1) + p;
        int temp = queryArray[i];
        queryArray[i] = queryArray[r];
        queryArray[r] = temp;
        return partition(p, r);
    }

    private int partition(int p, int r) {
        int x = queryArray[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (queryArray[j] <= x) {
                i++;
                int temp = queryArray[i];
                queryArray[i] = queryArray[j];
                queryArray[j] = temp;
            }
        }
        int temp = queryArray[i + 1];
        queryArray[i + 1] = queryArray[r];
        queryArray[r] = temp;
        return i + 1;
    }
}
