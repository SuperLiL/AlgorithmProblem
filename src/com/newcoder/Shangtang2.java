package com.newcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Shangtang2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int picCout = in.nextInt();
        int findCout = in.nextInt();
        HashMap<Integer, Integer> pictures = new HashMap<>();
        ArrayList<Integer> indexs = new ArrayList<>();
        for(int i=0;i<picCout;i++){
            int index = in.nextInt();
            int emplo = in.nextInt();
            pictures.put(index,emplo);
        }
        for(int j=0;j<findCout;j++){
            int i = in.nextInt();
           // indexs.add(i);
            System.out.println(pictures.get(i));
        }
       // result(pictures,indexs);
    }
    public static void result(HashMap<Integer, Integer> pictures,ArrayList<Integer> indexs){
        for(int i=0;i<indexs.size();i++){
            System.out.println(pictures.get(indexs.get(i)));
        }
    }
}
