import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class main{
    public static void main(String args[]){
        System.out.println("Testing data point");
        Scanner scanner = new Scanner(System.in);
        List<String> tokens = new ArrayList<>();
        while (!scanner.hasNext("eof")) {

            tokens.add(scanner.nextLine());
        }
        Iterator<String> it = tokens.iterator();
        while(it.hasNext())
            System.out.println(it.next());
        Solution solutiondebug = new Solution();
        int[] arr = {-1,0,1,2,3,4,5};
        int[] result = solutiondebug.sortedSquares(arr);
        System.out.println(Arrays.toString(result));
    }
}