package temp;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        String s = in.nextLine();
        String[] words = s.split(" ");
        int sum = 0;
        for (int i = 0; i < words.length; ++i){
            sum += words[i].length();
        }
        System.out.println(String.format("%.2f", (float)sum / words.length));



    }
}
