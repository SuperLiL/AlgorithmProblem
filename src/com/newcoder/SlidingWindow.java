package com.newcoder;
//考察的是栈和队列

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 题目：
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class SlidingWindow {
    //思路：创建一个双端队列，目的是头和尾都能删除，头删除是为了在滑动窗口中不能超过活动窗口的大小，尾删除是为了删除小的元素，队列的加入都是在队尾进行的
    public static void main(String[] args) {
    }
    public static ArrayList<Integer> maxArr(int[] num,int size){
        //最终返回结果
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) return res;
        int begin;
        //双端队列,里面存储最大值的下标
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            //表示在滑动窗口中的最久位置，当begin>=0时候才可以存储数据
            begin = i - size + 1;
            //如果q为空则直接加入数据
            if(q.isEmpty())
                q.add(i);
            //不为空判断队列中的数据是否该清除
            else if(begin > q.peekFirst())
                q.pollFirst();
            // 对于新的元素正式判断，如果不为空，并且队尾元素小于等于当前判断元素，那么移除队尾元素，直到当前元素小于队列元素。
            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            // 满足上述条件后，将当前元素加入到队列中。
            q.add(i);
            //若begin大于0开始输出结果
            if(begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
