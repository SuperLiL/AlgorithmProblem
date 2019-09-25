package com.newcoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * 假设有N个人要玩游戏，每轮游戏必须选出一个人当裁判，剩下的N-1个人作为玩家。
 * 现在第i个人要求作为玩家进行至少Ai轮游戏，那么至少需要进行多少轮游戏才能满足所有人的要求？
 */
public class Aqi {
    static int qunjusum=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         int cout = in.nextInt();
         qunjusum=cout;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum=0;
        for(int i=0;i<cout;i++){
            int a = in.nextInt();
            sum+=a;
            arrayList.add(a);
            //Math.pow(a,a);
        }
        System.out.println(computer(arrayList,sum));
    }
    public static int computer(ArrayList<Integer> arrayList,int sum){

        Collections.sort(arrayList);
        int sum1 = arrayList.get(0) + arrayList.get(1);

        if(sum1-arrayList.get(arrayList.size()-1)>0){
            return arrayList.get(arrayList.size()-1)+sum1-arrayList.get(arrayList.size()-1);
        }else {
            return arrayList.get(arrayList.size()-1);
        }

    }
}
