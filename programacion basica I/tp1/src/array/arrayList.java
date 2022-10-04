package array;
import java.util.*;

public class arrayList {
    public static void main(String args[]) {

        String[] array = new String[5];
        array[0] = "1";
        array[1] = "2";
        array[2] = "3";
        array[3] = "4";
        array[4] = "5";
         
        System.out.println("array inicial:\n"+ Arrays.toString(array)); 
                         
        int N = array.length;
        array = Arrays.copyOf(array, N + 1);
        array[N] = "6";
        
        int A= array.length;
        array = Arrays.copyOf(array, A + 1);
        array[A] = "7";
        
        System.out.println("array modificado:\n"+ Arrays.toString(array)); 
    }
}