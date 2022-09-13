import java.util.Scanner;

public class TestWangYi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int nums = Integer.parseInt(num);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int[][] edge = new int[nums + 1][nums + 1];
        for (int i = 0; i < nums-1; i++) {
            String[] s = sc.nextLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            edge[a][b] = 1;
            edge[b][a] = 1;
        }

        int sumPath = 0;
        boolean[] visit = new boolean[nums + 1];

        System.out.println( dfs(1, 0, chars, visit, 0, edge));
    }
    public static int dfs(int index, int lastIndex, char[] s, boolean[] visit, int sum, int[][] path){
        visit[index] = true;
        if(index != 1){
            if(s[index-1] != s[lastIndex-1]){
                sum--;
            }else{
                sum++;
            }
        }else {
            sum = 1;
        }

        for (int i = 1; i <= s.length; i++) {
            if(path[index][i] != 0 && !visit[i]){
                sum += dfs(i, index, s, visit, sum, path);
            }
        }
        return Math.abs(sum);
    }
}
