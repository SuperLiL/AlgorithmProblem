package com.newcoder;

import java.util.Scanner;

public class Shangtang4 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int m = in.nextInt();
        int n =in.nextInt();
        int[][] arr =new int[m+1][n+1];
        int k = in.nextInt();
        for(int i=0;i<k;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            arr[x][y]=-1;
        }

        System.out.println(result(arr,m+1,n+1));
    }
    public static int result(int[][] arr,int m,int n){
        int num =0;
        if(m>1)
            num+=result(arr,m-1,n);
        if(n>1)
            num+=result(arr,m,n-1);
        return num;
    }
}
