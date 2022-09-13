import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class meituanTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int yCounts = sc.nextInt();
        int lCounts = sc.nextInt();
        int[][] yArr = new int[yCounts][2];
        int[][] lArr = new int[lCounts][2];
        int res = 0;

        for (int i = 0; i < yCounts; ++i) {
            yArr[i][0] = sc.nextInt();
        }
        for (int i = 0; i < yCounts; ++i) {
            yArr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < lCounts; ++i) {
            lArr[i][0] = sc.nextInt();
        }
        for (int i = 0; i < lCounts; ++i) {
            lArr[i][1] = sc.nextInt();
        }
        Arrays.sort(yArr,(o1, o2) -> o1[0]-o2[0]);
        Arrays.sort(lArr,(o1, o2) -> o1[0]-o2[0]);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < yCounts; ++i) {
            for (int j = yArr[i][0]; j <= yArr[i][1]; ++j) {
                set.add(j);
            }
        }
        for (int i = 0; i < lCounts; ++i) {

            for (int j = lArr[i][0]; j <= lArr[i][1]; ++j) {
                if (!set.add(j)) {
                    res++;
                }
                ;
            }
        }
        System.out.println(res);
    }
}

