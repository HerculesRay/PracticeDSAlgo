package com.Backtracking;

public class KnightMoves{
    int[][] ch;
    KnightMoves(){
        this.ch=new int[8][8];
    }
    private void solve(int m,int n,int count){
        if(!isPossible(m,n)){
            return;
        }
        ch[m][n]=count++;
        if (count==65)
            return;
            
        int[] x={2,2,-2,-2,1,-1,1,-1};
        int[] y={-1,1,-1,-1,2,2,-2,-2};
        
        for(int k=0;k<8;k++){
            solve(m+x[k],n+y[k],count);
        }   
        return;
    }
    private boolean isPossible(int m,int n){
        if(m<0 || m>=8 || n<0 || n>=8 || ch[m][n]!=0)
            return false;
        else 
            return true;
    }
    private void printResult(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(ch[i][j]/10==0)
                System.out.print(0);
                System.out.print(ch[i][j]+"  ");
            }
            System.out.println();
        }
    }

     public static void main(String []args){
        KnightMoves kt=new KnightMoves();
        int count=1;
        kt.solve(0,0,count);
        kt.printResult();
     }
}

