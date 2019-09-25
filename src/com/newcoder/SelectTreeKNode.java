package com.newcoder;

import com.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 */
//思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
//     所以，按照中序遍历顺序找到第k个结点就是结果。
public class SelectTreeKNode {
    static ArrayList<TreeNode> treeNodes =new ArrayList<>();;
    public static void main(String[] args) {
        int[] arr={5,3,7,2,4,6,8};
        TreeNode treeNode = new CtreatTree().creatTree(arr);
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            // 将一个数组的值依次转换为Node节点
            treeNodes.add(new TreeNode(arr[i]));
        }

        TreeNode treeNode1 = KthNode(treeNode, 1);
        System.out.println(treeNode1.val);
    }
    public static TreeNode KthNode(TreeNode pRoot, int k) {
          inOrderTree(pRoot);
          for(int i=0;i<treeNodes.size();i++){
              System.out.println(treeNodes.get(i).val);
          }
        return treeNodes.get(k-1);
    }
    public static void inOrderTree(TreeNode root){
        if(root==null){
            return;
        }
        inOrderTree(root.left);
        treeNodes.add(root);
        inOrderTree(root.right);

    }

}
