import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{

    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(3);
        objects.add(6);
        objects.add(9);
        objects.add(12);
        Main main = new Main();
        main.longestGeometricSeqLength(objects);
        objects.sort((o1, o2) -> o1 - o2);
    }
    public int longestGeometricSeqLength (ArrayList<Integer> nums) {
        // write code here
        int len = nums.size();
        int res = 0;
        List<Map<Double,Integer>> list = new ArrayList<>();
        HashMap<Double,Integer> map = new HashMap<>();
        map.put(0.0,0);
        list.add(0,map);
        for (int i = 1; i < len; i++) {
            HashMap<Double,Integer> tmpMap = new HashMap<>();
            list.add(tmpMap);
            for (int j = 0; j < i; j++) {
                double q = nums.get(i) / nums.get(j);
                if(list.get(j).containsKey(q)){
                    tmpMap.put(q,list.get(j).get(q) +1 );
                }else{
                    tmpMap.put(q,2);
                }
                res = Math.max(res,tmpMap.get(q));
            }
        }
        return res;
    }
}




//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double mod = 1e9 + 7;
//        String str = sc.nextLine();
//        int len = str.length();
//        int[][] dp = new int[200000][9];
//        for (int i = 1; i <= len ; i++) {
//            int m = (str.charAt(i-1) - '0') % 9;
//            for (int j = 0; j < 9; j++) {
//                dp[i][j] = (int)((dp[i - 1][j]+dp[i - 1][(j - m + 9) % 9]) % mod);
//            }
//            dp[i][m] = (int)((dp[i][m] + 1) % mod);
//        }
//        System.out.println(dp[str.length()][0]);
//    }
//}

