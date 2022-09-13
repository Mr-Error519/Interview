import java.util.Scanner;

public class MeiTuanAut1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrNums = scanner.nextInt();
        int[][] cakes = new int[arrNums][2];

        for (int i = 0; i < arrNums; i++) {
            for (int j = 0; j < 2; j++) {
                cakes[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < arrNums; i++) {
            System.out.println(comPackageNums(cakes[i][0], cakes[i][1]));
        }
    }


    public static int comPackageNums(int x, int y){
        int morePackageNums = x > y ? x : y;
        int lessPackageNums = x <= y ? x : y;

        int a = morePackageNums / 2;
        int mod = morePackageNums % 2;
        int res = 0;

        if(lessPackageNums <= a){
            return lessPackageNums;
        }else{
            res += a;
            if(mod == 0){
                return res;
            }
            if(lessPackageNums - a >= 2){
                res +=1;
            }
            return res;
        }
    }
}
