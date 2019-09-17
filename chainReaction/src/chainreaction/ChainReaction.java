/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainreaction;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ChainReaction {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String arr[][] = new String[10][10];int row,col;
        System.out.println("Enter the row value");row = s.nextInt();
        System.out.println("Enter the column value");col = s.nextInt();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j]="0";
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j]+"\t");
            }System.out.println("");
        }
        insert(arr,row,col);
    }
    public static void insert(String [][] arr,int row,int col)
    {
        int x=0,i=0,j=0;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("insert row and col index");
            i=s.nextInt();j=s.nextInt();
            game(arr,i,j,row,col);
            x=s.nextInt();
        }while(x==1);
        for(int i1=0;i1<row;i1++){
            for(int j1=0;j1<col;j1++){
                System.out.print(arr[i1][j1]+"\t");
            }System.out.println("");
        }
    }
    
    public static void game(String[][] arr,int i,int j,int row,int col)
    {
        if(i>col-1 || j>row-1){
            System.out.println("Plz enter valid position\t"+(row-1)+"to\t"+(col-1));
        }else{
            if((i==0 && j==0)||(i==0 && j==col-1)||(i==row-1 && j==0)||(i==row-1 && j==col-1)){
                game1(arr, i, j, row, col);
            }else if((i==0 && j>=1 && j<=col-2)|| (i>=1 && i<=row-2 && j==0) || (i>=1 && i<=row-2 && j==col-1) || (i==row-1 && j>=1 && j<=col-2)){
                game2(arr, i, j, row, col);
            }else{
                game3(arr, i, j, row, col);
            }
        }
    }
    public static void game1(String[][] arr,int i,int j,int row,int col ){            
        if(i==0 && j==0){
            if(arr[i][j].equals("r1")){
                cornercell1(arr,i,j,row,col);
                game2(arr,i+1,j,row,col);
                game2(arr,i,j+1,row,col);
            }else{cornercell1(arr,i,j,row,col);}
            
        }else if(i==0 && j==col-1){
            if(arr[i][j].equals("r1")){
                cornercell1(arr,i,j,row,col);
                game2(arr, i, j-1,row,col);
                game2(arr, i+1, j,row,col);
            }else{cornercell1(arr,i,j,row,col);}
        }else if(i==row-1 && j==0){
            if(arr[i][j].equals("r1")){
                cornercell1(arr,i,j,row,col);
                game2(arr, i-1, j,row,col);
                game2(arr, i, j+1,row,col);
            }else{cornercell1(arr,i,j,row,col);}
        }else if(i==row-1 && j==col-1){
            if(arr[i][j].equals("r1")){
                cornercell1(arr,i,j,row,col);
                game2(arr, i-1, j,row,col);
                game2(arr, i, j-1,row,col);
            }else{cornercell1(arr,i,j,row,col);}
        }
    }
    public static void game2(String[][] arr,int i,int j,int row,int col){
        if(i==0 && j>=1 && j<=col-2){
            if(arr[i][j].equals("r2")){
                cornercell2(arr, i, j,row,col); 
                cornercell2(arr,i,j-1,row,col);
                cornercell2(arr,i,j+1,row,col);
                game3(arr, i+1, j, row, col);
            }else{
                cornercell2(arr, i, j,row,col); 
            }
        }else if(i>=1 && i<=row-2 && j==0){
            if(arr[i][j].equals("r2")){
                cornercell2(arr, i, j,row,col);
                cornercell2(arr, i-1, j, row, col);
                cornercell2(arr, i+1, j, row, col);
                game3(arr, i, j+1, row, col);
            }else{
                cornercell2(arr, i, j,row,col); 
            }
        }else if(i>=1 && i<=row-2 && j==col-1){
            if(arr[i][j].equals("r2")){
                cornercell2(arr, i, j,row,col); 
                cornercell2(arr, i-1, j, row, col);
                cornercell2(arr, i+1, j, row, col);
                game3(arr, i, j-1, row, col);
            }else{
                cornercell2(arr, i, j,row,col); 
            }
        }else if(i==row-1 && j>=1 && j<=col-2){
            if(arr[i][j].equals("r2")){
                cornercell2(arr, i, j,row,col);
                cornercell2(arr, i, j-1,row,col);
                cornercell2(arr, i, j+1,row,col);
                game3(arr, i-1, j,row,col); 
            }else{
                cornercell2(arr, i, j,row,col); 
            }
        }
    }
    public static void game3(String[][] arr,int i,int j,int row,int col ){            
        if(arr[i][j].equals("r3")){
            cornercell3(arr, i, j,row,col);
            cornercell3(arr, i-1, j,row,col);
            cornercell3(arr, i, j+1,row,col);
            cornercell3(arr, i, j-1,row,col);
            cornercell3(arr, i+1, j,row,col);  
        }else{
            cornercell3(arr, i, j,row,col); 
        }
    
    }
    public static void cornercell1(String[][] arr,int i,int j,int row,int col){ 
        arrayisfull(arr,row,col);
        if(arr[i][j].equals("0")){
            arr[i][j]="r1";                        
        }else if(arr[i][j].equals("r1")){
            arr[i][j]="0";
        }
    }
    public static void cornercell2(String[][] arr,int i,int j,int row,int col)
    { 
       arrayisfull(arr,row,col);
        if(i<row && j<col && i>=0 && j>=0)
        {
            if(arr[i][j].equals("0")){
                arr[i][j]="r1";      
            }else if(arr[i][j].equals("r1")){
                if((i==0 && j==0)||(i==0 && j==col-1)||(i==row-1 && j==0)||(i==row-1 && j==col-1)){
                    game1(arr, i, j, row, col);
                }else if((i==0 && j>=1 && j<=col-2)|| (i>=1 && i<=row-2 && j==0) || (i>=1 && i<=row-2 && j==col-1) || (i==row-1 && j>=1 && j<=col-2)){
                    arr[i][j]="r2";
                }
            }else if(arr[i][j].equals("r2")){
                arr[i][j]="0";
                return;
            } 
        }
    }
    public static void cornercell3(String[][] arr,int i,int j,int row,int col)
    { 
        arrayisfull(arr,row,col);
        if(i<row && j<col && i>=0 && j>=0)
        {
            if(arr[i][j].equals("0")){
                arr[i][j]="r1";                        
            }else if(arr[i][j].equals("r1")){
                if((i==0 && j==0)||(i==0 && j==col-1)||(i==row-1 && j==0)||(i==row-1 && j==col-1)){
                    game1(arr, i, j, row, col);
                }else{
                    arr[i][j]="r2";
                }
            }else if(arr[i][j].equals("r2")){
                if((i==0 && j>=1 && j<=col-2)|| (i>=1 && i<=row-2 && j==0) || (i>=1 && i<=row-2 && j==col-1) || (i==row-1 && j>=1 && j<=col-2)){
                    game2(arr, i, j, row, col);
                }else{                
                    arr[i][j]="r3";
                }
            }else if(arr[i][j].equals("r3")){
                arr[i][j]="0";
            }
        }
    }
    public static void arrayisfull(String[][] arr,int col,int row)
    {
        boolean check=true;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j].equals("0")){
                    check=false;
                }
            }
        }
        if(check){
            System.out.println("Array is full");
            for(int i1=0;i1<row;i1++){
                for(int j1=0;j1<col;j1++){
                    System.out.print(arr[i1][j1]+"\t");
                }System.out.println("");
            }
            exit(0);
        }else{
            return;
        }
    }
}


