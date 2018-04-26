private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxChildLen = 0;
        int curLen = 0;
        for (int i = 0; i < root.child.size(); i++) {
            curLen = helper(root.child.get(i));
            maxLen = Math.max(maxChildLen + curLen + 1, maxLen);
            maxChildLen = Math.max(maxChildLen, curLen);
        }
        return curLen + 1;
}
