package hot100.m079;

public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        char[] target = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board,target,visit,direction,0,i,j)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,char[] target,boolean[][] visit,int[][] direction,int index,int x,int y){
        if(index==target.length-1&&board[x][y]==target[index]) return true;
        if(board[x][y]==target[index]){
            visit[x][y]=true;
            for(int[] dir:direction){
                int newX = x+dir[0];
                int newY = y+dir[1];
                if(newX>=0&&newX<=board.length&&newY>=0&&newY<=board[0].length&&!visit[newX][newY]){
                    if(dfs(board,target,visit,direction,index+1,newX,newY)) return true;
                }
            }
            visit[x][y]=false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        Solution solution = new Solution();
        solution.exist(chars,"SEE");

    }
}
