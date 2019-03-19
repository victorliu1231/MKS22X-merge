import java.util.Arrays;

public class Merge{
    /*sort the array from least to greatest value. This is a wrapper function*/
    public static void mergesort(int[]data){
        mergeHelp(data,0,data.length - 1);
    }

    private static void mergeHelp(int[] data, int start, int end){
        if (end - start <= 9){
            insertionSort(data, start, end);
        } else {
            int middle = (end - start) / 2 + start;
            mergeHelp(data, start, middle);
            mergeHelp(data, middle+1, end);
            merge(data, start, end, middle);
        }
    }

    public static void mergesortNonOptimized(int[]data){
        mergeHelpNonOptimized(data,0,data.length - 1);
    }

    private static void mergeHelpNonOptimized(int[] data, int start, int end){
        if (start >= end){
            swap(data, start, end);
        }
        int middle = (end - start) / 2 + start;
        mergeHelp(data, start, middle);
        mergeHelp(data, middle+1, end);
        merge(data, start, end, middle);
    }

    private static void merge(int[] data, int start, int end, int middle){
        if (end - start == 1){
            if (data[end] < data[start]){
                swap(data,end,start);
            }
        } else {
            int[] temp = new int[end-start+1];
            int firstAryIndexing = start;
            int secondAryIndexing = middle+1;
            for (int i = start; i < end+1; i++){
                int sumOfIndices = firstAryIndexing + secondAryIndexing - start - middle;
                if (data[firstAryIndexing] <= data[secondAryIndexing]){
                    temp[sumOfIndices - 1] = data[firstAryIndexing];
                    if (i == end - start){
                        temp[sumOfIndices] = data[secondAryIndexing];
                    }
                    else if (firstAryIndexing == middle){
                        int counter = 0;
                        for (int in = secondAryIndexing; in <= end; in++){
                            temp[sumOfIndices+counter] = data[secondAryIndexing+counter];
                            counter++;
                        }
                        i = end + 1;
                    } else {
                        firstAryIndexing++;
                    }
                } else {
                    temp[sumOfIndices - 1] = data[secondAryIndexing];
                    if (secondAryIndexing == end){
                        int counter = 0;
                        for (int in = firstAryIndexing; in <= middle; in++){
                            temp[sumOfIndices+counter] = data[firstAryIndexing+counter];
                            counter++;
                        }
                        i = end + 1;
                    } else {
                        secondAryIndexing++;
                    }
                }
            }
            for (int ind = 0; ind < temp.length; ind++){
                data[start+ind] = temp[ind];
            }
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

    private static void swap(int[] data, int a, int b){
        int storer = data[a];
        data[a] = data[b];
        data[b] = storer;
    }
}
