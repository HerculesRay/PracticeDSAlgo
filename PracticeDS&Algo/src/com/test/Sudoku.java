package com.test;

/*
input
5 3 0 0 7 0 0 0 0
6 0 0 1 9 5 0 0 0
0 9 8 0 0 0 0 6 0
8 0 0 0 6 0 0 0 3
4 0 0 8 0 3 0 0 1
7 0 0 0 2 0 0 0 6
0 0 0 0 0 0 2 8 0
0 0 0 4 1 9 0 0 5
0 0 0 0 8 0 0 0 0
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sudoku{
    int[][] game;
    Sudoku(int[][] game){
        this.game=game;
    }
    private boolean findPossible(int r,int c,int k){
        for(int i=0;i<9;i++){
            if(game[i][c]==k || game[r][i]==k)
                return false;
        }
        for(int i=(r/3)*3;i<(r/3)*3+3;i++){
            for(int j=(c/3)*3;j<(c/3)*3+3;j++){
                if(game[i][j]==k) return false;
            }
        }
        return true;
    }
    private boolean solve(){
        boolean isSelected=false;
        int row=-1;
        int col=-1;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(game[i][j]==0){
                    isSelected=true;
                    row=i;
                    col=j;
                    break;
                }
            }
            if(isSelected) break;
        }
        if(isSelected){
            for(int k=1;k<=9;k++){
                if(findPossible(row,col,k)){
                    game[row][col]=k;
                    if(!solve()){
                        game[row][col]=0;
                    }
                    else return true;
                }
            }
        }
        else return true;
        
        return false;
    }
    void printSol(){
        System.out.println("Solved Result:\n");
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(game[i][j]+" ");
                }
                System.out.println();
            }
    }

     public static void main(String []args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[][] split=new String[9][9];
        int[][] game=new int[9][9];
        for(int i=0;i<9;i++){
            split[i]=br.readLine().split(" ");
            for(int j=0;j<9;j++){
                game[i][j]=Integer.parseInt(split[i][j]);
            }
        }
        Sudoku sd=new Sudoku(game);
        if(sd.solve()){
            sd.printSol();
        }
        else{
            System.out.println("Can't Solve");
        }
     }
}
