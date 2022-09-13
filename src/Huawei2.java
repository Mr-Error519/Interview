import java.util.Scanner;

public class Huawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int k=sc.nextInt();
        int[][] arr=new int[n][m];
        int len=0;
        for(int i=0;i<k;i++){
            int k1=sc.nextInt();
            int k2=sc.nextInt();
            arr[k1][k2]=-1;
        }
        int[] res=new int[n*m];
        dfs(arr,x1,y1,new boolean[n][m],x2,y2,0,res);
        for(int i=0;i<res.length;i++){
            if(res[i]!=0){
                System.out.println(res[i]+" "+i);
                return;
            }
        }

    }
    public static void dfs(int[][] arr,int i,int j,boolean[][] flag,int x2,int y2,int step,int[] res){

        if(i<0||j<0||i>=flag.length||j>=flag[0].length)return;
        if(arr[i][j]==-1)return;
        if(flag[i][j])return;
        flag[i][j]=true;
        if(i==x2&&j==y2){
            res[step]++;
            flag[i][j]=false;
            return;
        }
        dfs(arr,i-1,j,flag,x2,y2,step+1,res);
        dfs(arr,i+1,j,flag,x2,y2,step+1,res);
        dfs(arr,i,j-1,flag,x2,y2,step+1,res);
        dfs(arr,i,j+1,flag,x2,y2,step+1,res);
        flag[i][j]=false;
    }
}
