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
public class ChainReactionFinal {
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
    public static void insert(String [][] arr,int row,int col){
        int x=0,i=0,j=0,k=0,l=0;
        Scanner s = new Scanner(System.in);
        do{
            do{
            System.out.println("Player1 insert row and col index");
            i=s.nextInt();j=s.nextInt();
            }while(arr[i][j].equals("g1") || arr[i][j].equals("g2") || arr[i][j].equals("g3"));
            game(arr,i,j,row,col,0);
            for(int i1=0;i1<row;i1++){
                for(int j1=0;j1<col;j1++){
                    System.out.print(arr[i1][j1]+"\t");
                }System.out.println("");
            }
            do{
                System.out.println("Player2 insert row and col index");
                k=s.nextInt();l=s.nextInt();
            }while(i==k && j==l && l<col && k<row  || arr[k][l].equals("r1") || arr[k][l].equals("r2") || arr[k][l].equals("r3"));
            game(arr,k,l,row,col,1);
            for(int i1=0;i1<row;i1++){
                for(int j1=0;j1<col;j1++){
                    System.out.print(arr[i1][j1]+"\t");
                }System.out.println("");
            }
            System.out.println("Do you want to continue(0.Yes 1.No)");
            x=s.nextInt();
        }while(x!=1);
        for(int i1=0;i1<row;i1++){
            for(int j1=0;j1<col;j1++){
                System.out.print(arr[i1][j1]+"\t");
            }System.out.println("");
        }
    } 
    public static void game(String[][] arr,int i,int j,int row,int col,int flag){
        if(j>col-1 || i>row-1){
            System.out.println("Plz enter valid position:\t"+(row-1)+"\tto\t"+(col-1));
        }else{
            if((i==0 && j==0)||(i==0 && j==col-1)||(i==row-1 && j==0)||(i==row-1 && j==col-1)){
                game1(arr, i, j, row, col,flag);
            }else if((i==0 && j>=1 && j<=col-2)|| (i>=1 && i<=row-2 && j==0) || (i>=1 && i<=row-2 && j==col-1) || (i==row-1 && j>=1 && j<=col-2)){
                game2(arr, i, j, row, col,flag);
            }else if((i>=1 && j>=1 && i<=row-2 && j<=col-2)){
                game3(arr, i, j, row, col,flag);
            }
        }
    }
    public static void game1(String[][] arr,int i,int j,int row,int col,int flag){         
        if(i==0 && j==0){
            if(arr[i][j].equals("r1") || arr[i][j].equals("g1")){
                cornercell11(arr,i,j,row,col,flag);
                cornercell2(arr,i+1,j,row,col,flag);
                cornercell2(arr,i,j+1,row,col,flag);
                arrayisfull(arr,row,col);
            }else{cornercell11(arr,i,j,row,col,flag);}
        }else if(i==0 && j==col-1){
            if(arr[i][j].equals("r1") || arr[i][j].equals("g1")){
                cornercell11(arr,i,j,row,col,flag);
                cornercell2(arr, i, j-1,row,col,flag);
                cornercell2(arr, i+1, j,row,col,flag);
                arrayisfull(arr,row,col);
            }else{cornercell11(arr,i,j,row,col,flag);}
        }else if(i==row-1 && j==0){
            if(arr[i][j].equals("r1") || arr[i][j].equals("g1")){
                cornercell11(arr,i,j,row,col,flag);
                cornercell2(arr, i-1, j,row,col,flag);
                cornercell2(arr, i, j+1,row,col,flag);
                arrayisfull(arr,row,col);
            }else{cornercell11(arr,i,j,row,col,flag);}
        }else if(i==row-1 && j==col-1){
            if(arr[i][j].equals("r1") || arr[i][j].equals("g1")){
                cornercell11(arr,i,j,row,col,flag);
                cornercell2(arr, i-1, j,row,col,flag);
                cornercell2(arr, i, j-1,row,col,flag);
                arrayisfull(arr,row,col);
            }else{cornercell11(arr,i,j,row,col,flag);}
        }
    }
    
    public static void cornercell11(String[][] arr,int i,int j,int row,int col,int flag)
    { 
        if(flag==0){    
            switch (arr[i][j]) {
                case "0":
                    arr[i][j]="r1";
                    break;
                case "r1":
                case "g1":
                    arr[i][j]="0";
                    break;
            }
        }else{
            switch (arr[i][j]) {
                case "0":
                    arr[i][j]="g1";
                    break;
                case "g1":
                case "r1":
                    arr[i][j]="0";
                    break;
            }
        }
    }
    
    public static void game2(String[][] arr,int i,int j,int row,int col,int flag){
        if(i==0 && j>=1 && j<=col-2){
            if(arr[i][j].equals("r2") || arr[i][j].equals("g2")){
                cornercell22(arr, i, j,row,col,flag); 
                cornercell2(arr,i,j-1,row,col,flag);
                cornercell2(arr,i,j+1,row,col,flag);
                cornercell3(arr, i+1, j, row, col,flag);
                arrayisfull(arr,row,col);
            }else{
                cornercell22(arr, i, j,row,col,flag); 
            }
        }else if(i>=1 && i<=row-2 && j==0){
            if(arr[i][j].equals("r2") || arr[i][j].equals("g2")){
                cornercell22(arr, i, j,row,col,flag); 
                cornercell2(arr, i-1, j, row, col,flag);
                cornercell2(arr, i+1, j, row, col,flag);
                cornercell3(arr, i, j+1, row, col,flag);
                arrayisfull(arr,row,col);
            }else{
                cornercell22(arr, i, j,row,col,flag); 
            }
        }else if(i>=1 && i<=row-2 && j==col-1){
            if(arr[i][j].equals("r2") || arr[i][j].equals("g2")){
                cornercell22(arr, i, j,row,col,flag); 
                cornercell2(arr, i-1, j, row, col,flag);
                cornercell2(arr, i+1, j, row, col,flag);
                cornercell3(arr, i, j-1, row, col,flag);
                arrayisfull(arr,row,col);
            }else{
                cornercell22(arr, i, j,row,col,flag); 
            }
        }else if(i==row-1 && j>=1 && j<=col-2){
            if(arr[i][j].equals("r2") || arr[i][j].equals("g2")){
                cornercell22(arr, i, j,row,col,flag); 
                cornercell2(arr, i, j-1,row,col,flag);
                cornercell2(arr, i, j+1,row,col,flag);
                cornercell3(arr, i-1, j,row,col,flag);
                arrayisfull(arr,row,col);
            }else{
                cornercell22(arr, i, j,row,col,flag); 
            }
        }
    }
    
    public static void cornercell2(String[][] arr,int i,int j,int row,int col,int flag)
    { 
        if(flag==0){
            if(i<row && j<col && i>=0 && j>=0){
                switch (arr[i][j]) {
                    case "0":
                        arr[i][j]="r1";
                        break;
                    case "r1":
                    case "g1":
                        if((i==0 && j==0)||(i==0 && j==col-1)||(i==row-1 && j==0)||(i==row-1 && j==col-1)){
                            game1(arr, i, j, row, col,flag);
                        }else{// if((i==0 && j>=1 && j<=col-2)|| (i>=1 && i<=row-2 && j==0) || (i>=1 && i<=row-2 && j==col-1) || (i==row-1 && j>=1 && j<=col-2)){
                            arr[i][j]="r2";
                        }   break; 
                    case "r2":
                    case "g2":
                        game2(arr, i, j, row, col, flag);
                        break;
                }
            }
        }else{
            if(i<row && j<col && i>=0 && j>=0){
                switch (arr[i][j]) {
                    case "0":
                        arr[i][j]="g1";
                        break;
                    case "g1":
                    case "r1":
                        if((i==0 && j==0)||(i==0 && j==col-1)||(i==row-1 && j==0)||(i==row-1 && j==col-1)){
                            game1(arr, i, j, row, col,flag);
                        }else{// if((i==0 && j>=1 && j<=col-2)|| (i>=1 && i<=row-2 && j==0) || (i>=1 && i<=row-2 && j==col-1) || (i==row-1 && j>=1 && j<=col-2)){
                            arr[i][j]="g2";
                        }   break; 
                    case "g2":
                    case "r2":
                        game2(arr, i, j, row, col, flag);
                        break;
                }
            }
        }
    }
    public static void cornercell22(String[][] arr,int i,int j,int row,int col,int flag)
    { 
        if(flag==0){
            if(i<row && j<col && i>=0 && j>=0){
                switch (arr[i][j]) {
                    case "0":
                        arr[i][j]="r1";
                        break;
                    case "r1":
                    case "g1":
                        arr[i][j]="r2";
                        break;
                    case "r2":
                    case "g2": 
                        arr[i][j]="0";
                        break;
                }
            }
        }else{
            if(i<row && j<col && i>=0 && j>=0){
                switch (arr[i][j]) {
                    case "0":
                        arr[i][j]="g1";
                        break;
                    case "g1":
                    case "r1":
                        arr[i][j]="g2";
                        break;
                    case "g2":
                    case "r2": 
                        arr[i][j]="0";
                        break;
                }
            }
        }
    }
    public static void game3(String[][] arr,int i,int j,int row,int col,int flag){            
        if(i>=1 && j>=1 && i<=row-2 && j<=col-2){
            if(arr[i][j].equals("r3") || arr[i][j].equals("g3")){
                cornercell33(arr, i, j,row,col,flag); 
                cornercell3(arr, i-1, j,row,col,flag);
                cornercell3(arr, i+1, j,row,col,flag);
                cornercell3(arr, i, j-1,row,col,flag);
                cornercell3(arr, i, j+1,row,col,flag);
                arrayisfull(arr,row,col);
            }else{
                cornercell33(arr, i, j,row,col,flag); 
            }
        }
    return;
    }
    public static void cornercell3(String[][] arr,int i,int j,int row,int col,int flag){
        if(flag==0){
            if(i<row && j<col && i>=0 && j>=0){
                switch (arr[i][j]) {
                    case "0":
                        arr[i][j]="r1";
                        break;
                    case "r1":
                    case "g1":
                        if((i==0 && j==0)||(i==0 && j==col-1)||(i==row-1 && j==0)||(i==row-1 && j==col-1)){
                            game1(arr, i, j, row, col,flag);
                        }else{
                            arr[i][j]="r2";
                        }   break;
                    case "r2":
                    case "g2":
                        if((i==0 && j>=1 && j<=col-2)|| (i>=1 && i<=row-2 && j==0) || (i>=1 && i<=row-2 && j==col-1) || (i==row-1 && j>=1 && j<=col-2)){
                            game2(arr, i, j, row, col,flag);
                        }else{
                            arr[i][j]="r3";
                        }   break;
                    case "r3":
                    case "g3":
                        game3(arr, i, j, row, col, flag);
                        break;
                }
            }
        }else{
            if(i<row && j<col && i>=0 && j>=0){
                switch (arr[i][j]) {
                    case "0":
                        arr[i][j]="g1";
                        break;
                    case "g1":
                    case "r1":
                        if((i==0 && j==0)||(i==0 && j==col-1)||(i==row-1 && j==0)||(i==row-1 && j==col-1)){
                            game1(arr, i, j, row, col,flag);
                        }else{
                            arr[i][j]="g2";
                        }   break;
                    case "g2":
                    case "r2":
                        if((i==0 && j>=1 && j<=col-2)|| (i>=1 && i<=row-2 && j==0) || (i>=1 && i<=row-2 && j==col-1) || (i==row-1 && j>=1 && j<=col-2)){
                            game2(arr, i, j, row, col,flag);
                        }else{
                            arr[i][j]="g3";
                        }   break;
                    case "g3":
                    case "r3":
                        game3(arr, i, j, row, col, flag);
                        break;
                }
            }
        }
        
    }
    public static void cornercell33(String[][] arr,int i,int j,int row,int col,int flag){ 
        if(flag==0){
            if(i<row && j<col && i>=0 && j>=0){
                switch (arr[i][j]) {
                    case "0":
                        arr[i][j]="r1";
                        break;
                    case "r1":
                    case "g1":
                        arr[i][j]="r2";
                        break;               
                    case "r2":
                    case "g2":
                        arr[i][j]="r3";
                        break;
                    case "r3":
                    case "g3":
                        arr[i][j]="0";
                        break;
                }
            }
        }else{
            if(i<row && j<col && i>=0 && j>=0){
                switch (arr[i][j]) {
                    case "0":
                        arr[i][j]="g1";
                        break;
                    case "g1":
                    case "r1":
                        arr[i][j]="g2";
                        break;
                    case "g2":
                    case "r2":
                        arr[i][j]="g3";
                        break;
                    case "g3":
                    case "r3":
                        arr[i][j]="0";
                        break;
                }
            }
        }
    }
    public static void arrayisfull(String[][] arr,int row,int col)
    {     
        int c=0,c1=0,b=0;
        boolean check=true,check1=true;
//        Scanner s=new Scanner(System.in);
//        do{
//            for(int i1=0;i1<row;i1++){
//                    for(int j1=0;j1<col;j1++){
//                       if(arr[i1][j1].equals("0")){
//                           check=false;
//                       }                         System.out.print(arr[i1][j1]+"\t");
//                    }System.out.println("");
//            }
//            System.out.println("Continue");
//            b=s.nextInt();
//        }while(b==1);
        for(int i1=0;i1<row;i1++){
            for(int j1=0;j1<col;j1++){
                if(arr[i1][j1].equals("r1") || arr[i1][j1].equals("r2") || arr[i1][j1].equals("r3")){
                    c++;
                }else if(arr[i1][j1].equals("g1") || arr[i1][j1].equals("g2") || arr[i1][j1].equals("g3")){
                    check=false;               
                }
            }
        }
        if(check){
            System.out.println("Player1 is win");
            for(int i1=0;i1<row;i1++){
                for(int j1=0;j1<col;j1++){
                    System.out.print(arr[i1][j1]+"\t");
                }System.out.println("");
            }
            exit(0);
        }
        
        for(int i1=0;i1<row;i1++){
            for(int j1=0;j1<col;j1++){
                if(arr[i1][j1].equals("g1") || arr[i1][j1].equals("g2") || arr[i1][j1].equals("g3")){
                    c1++;
                }else if(arr[i1][j1].equals("r1") || arr[i1][j1].equals("r2") || arr[i1][j1].equals("r3")){
                    check1=false;               
                }
            }
        }
        if(check1){
            System.out.println("Player2 is win");
            for(int i1=0;i1<row;i1++){
                for(int j1=0;j1<col;j1++){
                    System.out.print(arr[i1][j1]+"\t");
                }System.out.println("");
            }
            exit(0);
        }
        return;
    }
}




