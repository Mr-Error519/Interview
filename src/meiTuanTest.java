import java.util.Scanner;

public class meiTuanTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int res = 0;
        for(int i=0;i < n; ++i) {
            arr[i]=sc.nextInt();
        }
        String str=sc.next();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if(str.charAt(i) == 'R'){
                colors[i] = 1;
            }else {
                colors[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(arr[i] == arr[j] && colors[i] != colors[j]){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}