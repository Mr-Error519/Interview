import java.text.ParseException;
import java.util.*;

public class Testcainiao {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'T'){
                list.add(i);
            }
        }
        if(list.size() % 2 == 1){
            System.out.println(0);
        }
        int pos = list.size() - 1;
        int res = 1;
        for (int i = 1; i < pos; i += 2) {
            res *= list.get(i + 1) - list.get(i);
        }
        System.out.println(res);
    }

}
