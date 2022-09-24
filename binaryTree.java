import java.util.*;
public class binaryTree {

     /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> listoflist= new ArrayList<>();
        int counter = 0;
        if(root!=null)
            i_path(root, targetSum,listoflist, list,counter);
        return listoflist;
    }

public static void i_path(TreeNode node,int targetSum,List<List<Integer>> listoflist,List<Integer> list,int counter){
        if(isLeafNode(node)){
            
            counter+=node.val;
            if(counter==targetSum){
                list.add(node.val);
                System.out.println(list);
                listoflist.add((List<Integer>) ((ArrayList<Integer>) list).clone());
                list.remove(list.size()-1);
            }
        }else{
            counter+=node.val;
            list.add(node.val);
            
            if(node.left!=null){
                i_path(node.left,targetSum,listoflist,list,counter);
            }
            
            if(node.right!=null){
                i_path(node.right,targetSum,listoflist,list,counter);
            }
            
            list.remove(list.size()-1);
            
        }
    }


    public static boolean isLeafNode(TreeNode node){
        return node.left==null && node.right==null;
    }
}
