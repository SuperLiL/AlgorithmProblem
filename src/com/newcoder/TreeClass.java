package com.newcoder;

import com.pojo.TreeNode;

public class TreeClass {
    static int index=0;
    /**
     *题目：二叉搜索树的第K个节点
     * @param root
     * @return
     * 二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
     *      所以，按照中序遍历顺序找到第k个结点就是结果。
     */
    public static TreeNode findKNodeBaseOrderTree(TreeNode root,int k){
        if(root != null){ //中序遍历寻找第k个
            //中序遍历的顺序  左-根-右
            TreeNode node = findKNodeBaseOrderTree(root.left,k);
            //以下为中序对根节点的操作
            //1、如果node不为空则代表
            if(node != null)
                return node;
            //若果为空，说明是个叶子节点
            index ++;
            if(index == k)
                return root;
            node = findKNodeBaseOrderTree(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr ={5,3,7,2,4,6,8};
        TreeNode treeNode = new CtreatTree().creatTree(arr);
        findKNodeBaseOrderTree(treeNode,4);
    }
}
