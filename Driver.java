import java.util.Arrays;

public class Driver{
    public static void main(String[]args){
        int[] t1 = new int[]{-9,-10,2,4,-3,2,9,-10};
        System.out.println(Arrays.toString(t1));
        Merge.mergesort(t1);
        System.out.println(Arrays.toString(t1));
    }
}