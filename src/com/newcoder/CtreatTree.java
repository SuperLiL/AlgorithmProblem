package com.newcoder;

import com.pojo.TreeNode;
import java.util.LinkedList;

/**
 * 根据数组创建一个完全二叉树，树有以下性质：
 * 1、父节点数组下标从0到 「n/2」 -1，但是遍历时要小于n/2-1，因为最后一个父节点可能没有右孩子，当n/2-1为奇数时才有右孩子，为偶数时只有左孩子。
 * 2、结点左孩子下标为2n+1，右孩子下标为2n+2
 */

/**
 * 树通过链表来完成每个树的左右树
 */
public class CtreatTree {
    //想一下这里声明public和private对于方法createTree有什么影响，目前猜想是不是需要一个get方法。
    public static LinkedList<TreeNode> treeNodeList=null;

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        CtreatTree tree = new CtreatTree();
        TreeNode treeNodes = tree.creatTree(arr);
        tree.preOrderSelect(treeNodes);

    }
    public TreeNode creatTree(int[] arr){
        treeNodeList=new LinkedList<>();
        // 将一个数组的值依次转换为Node节点
        for(int i=0;i<arr.length;i++){
            treeNodeList.add( new TreeNode(arr[i]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for(int parentIndex=0;parentIndex<arr.length/2-1;parentIndex++){
            //为节点添加左孩子
            treeNodeList.get(parentIndex).left=treeNodeList.get(2*parentIndex+1);
            //为节点添加右孩子
            treeNodeList.get(parentIndex).right=treeNodeList.get(2*parentIndex+2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = arr.length / 2 - 1;
        // 左孩子
        treeNodeList.get(lastParentIndex).left = treeNodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (arr.length % 2 == 1) {
            treeNodeList.get(lastParentIndex).right = treeNodeList
                    .get(lastParentIndex * 2 + 2);
        }
        return treeNodeList.get(0);
    }
    /**
     * 先序遍历
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     * @param treeNode 遍历的节点
     */
    public void preOrderSelect(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        System.out.println(treeNode.val);
        preOrderSelect(treeNode.left);
        preOrderSelect(treeNode.right);
    }
}
