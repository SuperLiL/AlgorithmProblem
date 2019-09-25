package com.newcoder;

import java.util.Scanner;

public class Shangtang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(check(num));

    }
    public static int check(int num){
        if(num%3==0){
            int cout = num / 3;
            int pow = (int)Math.pow(3, num / 3);

            return pow+cout;
        }
        if(num==2){
            return 3;
        }
        int result=1;
        int cout=1;
        while (num>4){
            result*=3;
            num-=3;
            cout++;
        }
        if(num==4){
            cout++;
        }
        result=result*num+cout;
        return result;
    }
}
