package trees;

import com.sun.source.tree.Tree;

public class MinTree {
    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int d) {
            data = d;
        }
    }

    TreeNode root;

    public void createMinimalBST(int[] arr) {
        root = createMinimalBST(arr, 0, arr.length - 1);
    }

    TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (end < start)
            return null;

        int mid = (start + end) / 2;
        TreeNode newNode = new TreeNode(arr[mid]);
        newNode.left = createMinimalBST(arr, start, mid - 1);
        newNode.right = createMinimalBST(arr, mid + 1, end);
        return newNode;
    }

    public void printInOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if(node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        MinTree minTree = new MinTree();
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        minTree.createMinimalBST(sortedArr);
        minTree.printInOrder();
    }
}
