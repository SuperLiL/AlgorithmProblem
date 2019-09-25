package com.newcoder;

public class TryFinally {
    public int demo(){
        int x;
        int u;
        try{
             x=1;
            return x;
        }catch (Exception e){
            x=2;
            return x;
        }finally {
            x=3;
        }
    }
}
