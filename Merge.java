import java.util.Arrays;

public class Merge{
    /*sort the array from least to greatest value. This is a wrapper function*/
    public static void mergesort(int[]data){
        int[] temp = new int[data.length];
        mergesortHelp(data,0,data.length - 1, temp);
    }

    private static void mergesortHelp(int[] data, int start, int end, int[] temp){
        if (end - start <= 47){
            insertionSort(data, start, end);
        } else {
            if (start >= end) return;
            int middle = (end + start) / 2;
            mergesortHelp(data, start, middle, temp);
            mergesortHelp(data, middle+1, end, temp);
            merge(data, start, end, middle, temp);
        }
    }

    private static void merge(int[] data, int start, int end, int middle, int[] temp){
        int firstAryIndexing = start;
        int secondAryIndexing = middle+1;
        for (int i = start; i < end; i++){
            if (data[firstAryIndexing] <= data[secondAryIndexing]){
                temp[i] = data[firstAryIndexing];
                if (i == end-1){
                    temp[end] = data[secondAryIndexing];
                }
                else if (firstAryIndexing == middle){
                    while (secondAryIndexing < end + 1){
                        temp[secondAryIndexing] = data[secondAryIndexing];
                        secondAryIndexing++;
                    }
                    i = end;
                } else {
                    firstAryIndexing++;
                }
            } else if (data[firstAryIndexing] > data[secondAryIndexing]){
                temp[i] = data[secondAryIndexing];
                if (i == end - 1){
                    temp[end] = data[firstAryIndexing];
                }
                else if (secondAryIndexing == end){
                    while (i < end){
                        temp[i+1] = data[firstAryIndexing];
                        firstAryIndexing++;
                        i++;
                    }
                } else {
                    secondAryIndexing++;
                }
            }
        }
        for (int ind = start; ind < end+1; ind++){
            data[ind] = temp[ind];
        }
    }

    private static void insertionSort(int[] ary, int start, int end){
      int storer = ary[start];
      boolean madeSwaps = false;
      for (int n = start+1; n < end+1; n++){ //loops through whole thing, starting with the unsorted part
        storer = ary[n]; //the value that wants to be sorted
        int i = n;
        while (i > start && storer < ary[i-1]){ //looping through sorted part and finding out where to place it
          ary[i] = ary[i-1]; //while looping, shifting over the elements to make room for the storer
          i--;
          madeSwaps = true;
        }
        if (madeSwaps){ //only if the while loop runs will you actually edit the sorted part
          ary[i] = storer;
        }
        madeSwaps = false; //resets the boolean so next pass has a clean slate
      }
    }
}
