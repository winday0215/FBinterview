 // level order
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        if (root == null) {
            return null;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur != null) {
                sb.append(cur.val + ",");
                q.offer(cur.left);
                q.offer(cur.right);
            } else {
                sb.append("#,");
            }
        }
        sb.deleteCharAt(sb.length() -1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.startsWith("#")) {
            return null;
        }
        String[] strs = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int i = 0;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                continue;
            }
            if (!strs[i+1].equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(strs[i+1]));
                q.offer(cur.left);
            } else {
                cur.left = null;
                q.offer(cur.left);
            }
            if (!strs[i+2].equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(strs[i+2]));
                q.offer(cur.right);
            } else {
                cur.right = null;
                q.offer(cur.right);
            }
            i += 2;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


//preorder
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode x, StringBuilder sb){
        if (x == null) {
            sb.append("#,");
        } else {
            sb.append(x.val + ",");
            serialize(x.left, sb);
            serialize(x.right, sb);
        }
    }
 
// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;

        int[] t = {0};
        String[] arr = data.split(",");

        return helper(arr, t);
    }

    public TreeNode helper(String[] arr, int[] t){
        if(arr[t[0]].equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));

        t[0]=t[0]+1;
        root.left = helper(arr, t);
        t[0]=t[0]+1;
        root.right = helper(arr, t);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
