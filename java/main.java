import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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
            
    }
}