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

    public static void swap(int[] data, int a, int b){
        int storer = data[a];
        data[a] = data[b];
        data[b] = storer;
    }
}