class Solution {
    int postIndex;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder,
                           int left, int right) {

        if (left > right) {
            return null;
        }

        // Last element of postorder = root
        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        int index = inorderMap.get(rootValue);

        // IMPORTANT: build RIGHT first
        root.right = build(inorder, postorder, index + 1, right);

        // Then build LEFT
        root.left = build(inorder, postorder, left, index - 1);

        return root;
    }
}