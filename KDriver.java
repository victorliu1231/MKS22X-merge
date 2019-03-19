import java.util.Arrays;
//ratio should be at most 2.5-3.0
public class KDriver{
    public static void main(String[]args){
        System.out.println("Size\t\tMax Value\tmerge/mergeNonOptimized ratio ");
        int[]MAX_LIST = {1000000000,10};
        for(int MAX : MAX_LIST){
            for(int size = 31250; size < 2000001; size*=4){
            long qtime=0;
            long btime=0;
            //average of 5 sorts.
            for(int trial = 0 ; trial <=5; trial++){
                int []data1 = new int[size];
                int []data2 = new int[size];
                for(int i = 0; i < data1.length; i++){
                data1[i] = (int)(Math.random()*MAX);
                data2[i] = data1[i];
                }
                long t1,t2;
                t1 = System.currentTimeMillis();
                Merge.mergesort(data2);
                t2 = System.currentTimeMillis();
                qtime += t2 - t1;
                t1 = System.currentTimeMillis();
                Merge.mergesortNonOptimized(data1);
                t2 = System.currentTimeMillis();
                btime+= t2 - t1;
                if(!Arrays.equals(data1,data2)){
                System.out.println("FAIL TO SORT!");
                System.exit(0);
                }
            }
            System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
            }
            System.out.println();
        }
    }
}
