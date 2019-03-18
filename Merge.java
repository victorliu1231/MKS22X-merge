import java.util.Arrays;

public class Merge{
    /*sort the array from least to greatest value. This is a wrapper function*/
    public static void mergesort(int[]data){
        mergeHelp(data,0,data.length - 1);
    }

    public static void mergeHelp(int[] data, int start, int end){
        if (start >= end){
            return;
        }
        int middle = (end - start) / 2 + start;
        mergeHelp(data, start, middle);
        mergeHelp(data, middle+1, end);
        merge(data, start, end, middle);
    }

    public static void merge(int[] data, int start, int end, int middle){
        if (end - start == 1){
            if (data[end] < data[start]){
                swap(data,end,start);
            }
        } else {
            int[] temp = new int[end-start+1];
            int firstAryIndexing = 0;
            int secondAryIndexing = 1;
            for (int i = 0; i < end-start+1; i++){
                int indexAtFirst = start+firstAryIndexing; //the index being checked at the first subarray
                int indexAtSecond = middle+secondAryIndexing; //the index being checked at the second subarray
                int sumOfIndexings = firstAryIndexing + secondAryIndexing;
                if (data[indexAtFirst] <= data[indexAtSecond]){
                    temp[sumOfIndexings - 1] = data[indexAtFirst];
                    if (i == end - start){
                        temp[sumOfIndexings] = data[indexAtSecond];
                    }
                    if (indexAtFirst == middle){
                        int counter = 0;
                        for (int in = indexAtSecond; in <= end; in++){
                            temp[sumOfIndexings + counter] = data[indexAtSecond + counter];
                            counter++;
                        }
                        for (int ind = 0; ind < temp.length; ind++){
                            data[start+ind] = temp[ind];
                        }
                        return;
                    } else {
                        firstAryIndexing++;
                    }
                } else {
                    temp[sumOfIndexings - 1] = data[indexAtSecond];
                    if (indexAtSecond == end){
                        int counter = 0;
                        for (int in = indexAtFirst; in <= middle; in++){
                            temp[sumOfIndexings + counter] = data[indexAtFirst + counter];
                            counter++;
                        }
                        for (int ind = 0; ind < temp.length; ind++){
                            data[start+ind] = temp[ind];
                        }
                        return;
                    } else {
                        secondAryIndexing++;
                    }
                }
            }
        }
    }

    public static void swap(int[] data, int a, int b){
        int storer = data[a];
        data[a] = data[b];
        data[b] = storer;
    }
}
