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
                if (data[start+firstAryIndexing] <= data[middle+secondAryIndexing]){
                    temp[firstAryIndexing + secondAryIndexing - 1] = data[start+firstAryIndexing];
                    if (i == end - start){
                        temp[firstAryIndexing+secondAryIndexing] = data[middle+secondAryIndexing];
                    }
                    if (start+firstAryIndexing == middle){
                        int counter = 0;
                        for (int in = middle+secondAryIndexing; in <= end; in++){
                            temp[firstAryIndexing+secondAryIndexing+counter] = data[middle+secondAryIndexing+counter];
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
                    temp[firstAryIndexing + secondAryIndexing - 1] = data[middle+secondAryIndexing];
                    if (middle+secondAryIndexing == end){
                        int counter = 0;
                        for (int in = start+firstAryIndexing; in <= middle; in++){
                            temp[firstAryIndexing+secondAryIndexing+counter] = data[start+firstAryIndexing+counter];
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