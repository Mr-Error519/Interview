package niuke.双指针.bm87;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int ia = m-1;
        int ib = n-1;
        int ip = m+n-1;

        while(ip>=0){
            if(ib<0) break;
            if(ia<0){
                A[ip] = B[ib];
                --ib;
                --ip;
                continue;
            }
            if(A[ia]>B[ib]){
                A[ip] = A[ia];
                --ia;
            }else{
                A[ip] = B[ib];
                --ib;
            }
            --ip;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{4,5,6,0,0,0};
        int[] B = new int[]{1,2,3};
        solution.merge(A,3,B,3);
    }
}
