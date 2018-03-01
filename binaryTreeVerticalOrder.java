/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Coordinate {
        int col;
        TreeNode node;
        public Coordinate(int col, TreeNode node) {
            this.col = col;
            this.node = node;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        Queue<Coordinate> q = new LinkedList<>();
        
        q.offer(new Coordinate(0, root));
        
        while (!q.isEmpty()) {
            Coordinate cur = q.poll();
            map.computeIfAbsent(cur.col, x -> new ArrayList<Integer>()).add(cur.node.val);
            
            if (cur.node.left != null) {
                q.offer(new Coordinate(cur.col - 1, cur.node.left));
            }
            if (cur.node.right != null) {
                q.offer(new Coordinate(cur.col + 1, cur.node.right));
            }
        }
        
        
        for (int key : map.keySet()) {
            ans.add(new ArrayList<Integer>(map.get(key)));
        }
        return ans;
    }
}
