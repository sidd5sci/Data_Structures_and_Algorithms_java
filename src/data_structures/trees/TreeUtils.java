package data_structures.trees;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class TreeUtils {
//
//
//    public int maxDepth(data_structures.trees.Node root) {
//        if(root == null)
//            return 0;
//
//        int lh=0,rh=0;
//
//        if(root.left != null){
//            lh = maxDepth(root.left);
//        }
//        if(root.right != null){
//            rh = maxDepth(root.right);
//        }
//
//        return (lh>rh?lh+1:rh+1);
//
//    }
//
//    public Boolean isSameTree(data_structures.trees.Node p, data_structures.trees.Node q){
//        boolean flag = false;
//        if(p == null && q == null){
//            return true;
//        }
//        if( (p == null && q != null) || (p != null && q == null)) {
//            return false;
//        }
//
//        if(p.val == q.val){
//            flag = true;
//        }
//
//
//        if(isSameTree(p.left,q.left) == true){
//            if(isSameTree(p.right,q.right)== true){
//                if(flag)return true;
//                else return false;
//            }else{
//                return false;
//            }
//        }else{
//            return false;
//        }
//    }
//
//    public TreeNode invertTree(TreeNode root) {
//        if(root == null) return null;
//
//        // System.out.println("Before"+root.left.val);
//        TreeNode node = root.left;
//        root.left= root.right;
//        root.right = node;
//        // System.out.println("After"+root.left.val);
//        invertTree(root.left);
//        invertTree(root.right);
//        return root;
//
//    }
//
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if(root == null) return new ArrayList<>();
//
//        List<TreeNode> nodes = new ArrayList<TreeNode>();
//        List<List<Integer>> values2 = new ArrayList<>();
//        nodes.add(root);
//        levelOrderTraversal(nodes,values2);
//
//        return values2;
//    }
//
//    public void levelOrderTraversal(List<TreeNode> nodes,List<List<Integer>> values2){
//        if(nodes == null || nodes.size() == 0)return ;
//
//        List<TreeNode> newNodes = new ArrayList<>();
//        List<Integer> values = new ArrayList<Integer>();
//
//
//        for (TreeNode node : nodes) {
//            if (node != null) {
//                // System.out.print(" "+node.val);
//                values.add(node.val);
//                newNodes.add(node.left);
//                newNodes.add(node.right);
//            }
//        }
//        if(values.size() > 0 )
//            values2.add(values);
//
//        levelOrderTraversal(newNodes,values2);
//
//    }
//
//
//
//
//
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        String s = "";
//        if(root == null) {
//            s += "null,";
//            return s;
//        }
//
//        // pre fix order
//        s += root.val+",";
//        s += serialize(root.left);
//        s += serialize(root.right);
//
//        return s;
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if(data == null) return null;
//
//        Int1 myInt = new Int1(0);
//        data = data.substring(0,data.length()-1);
//        TreeNode root = this.deserialize1(data.split(",",-2),myInt);
//        return root;
//    }
//
//
//    private TreeNode deserialize1(String str[],Int1 myInt){
//
//        if(myInt.getInt()  >= str.length)return null;
//
//        if(str[myInt.getInt()].equals("null"))return null;
//
//        TreeNode node = new TreeNode(Integer.parseInt(str[myInt.getInt()]));
//        myInt.index++;
//        node.left = this.deserialize3(str,myInt );
//        myInt.index++;
//        node.right = this.deserialize3(str,myInt );
//
//
//        return node;
//
//    }
//
//    class Int1{
//        public int index;
//        public Int1(int index){this.index=index;}
//        public int getInt(){return index;}
//        public void setInt(int index){this.index=index;}
//    }
//
//    // Your Codec object will be instantiated and called as such:
//    // Codec ser = new Codec();
//    // Codec deser = new Codec();
//    // TreeNode ans = deser.deserialize(ser.serialize(root));
//
}
