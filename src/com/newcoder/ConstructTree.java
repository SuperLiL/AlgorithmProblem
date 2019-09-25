package com.newcoder;

import com.pojo.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 */
public class ConstructTree {
    public static void main(String[] args) {
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode treeNode = new ConstructTree().reConstructBinaryTree(pre, in);
        new CtreatTree().preOrderSelect(treeNode);
    }
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    /**
     *
     * @param pre 前序遍历数组
     * @param startPre  子序列中前序第一个元素
     * @param endPre    子序列中前序的尾坐标
     * @param in        完整的中序遍历
     * @param startIn   子序列-中序开始节点
     * @param endIn     子序列-中序结束节点尾坐标
     * @return
     */
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        //如果符合以下条件，说明子树已经便利结束
        if(startPre>endPre||startIn>endIn)
            return null;
        //每次递归进入遇到的startPre都是跟节点
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                //找到前序的节点在中序对应位置后，将它分为两个树，中序节点比较好分：左左子树(startIn,i-1) 右子树(i+1,endIn)
                //对于前序分成两个子树是根据中序所包含的个数来划分的 左子树（startPre+1,startPre+i-startIn）右子树（startPre+1+i-startIn，endPre）
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
        return root;
    }
}
