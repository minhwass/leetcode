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
class Solution {
    List<String> treePaths = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root, "");
        return treePaths;
    }
    
    public void binaryTreePaths(TreeNode node, String path){
        if(node != null){
            path = makeTreePath(node, path);
            
            //base case : if i'm a leaf =>  end  
            if(node.left == null && node.right == null){
                treePaths.add(path);
                return; 
            }

            //visit root.left
            binaryTreePaths(node.left, path);
            //root.right
            binaryTreePaths(node.right, path);
        }
    }
    
    public String makeTreePath(TreeNode node, String path){
        if(path.isEmpty()) return path += node.val;
        else{
            return path += "->" + node.val;
        }
    }
}