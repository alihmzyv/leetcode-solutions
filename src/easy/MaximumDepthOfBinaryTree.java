package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepthBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode leftNode = deque.pollFirst();
                if (leftNode.left != null) {
                    deque.add(leftNode.left);
                }
                if (leftNode.right != null) {
                    deque.add(leftNode.right);
                }
            }
            level++;
        }
        return level;
    }

    public int maxDepthDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 1;
        Stack<TreeNodeWithDepth> stack = new Stack<>();
        stack.push(new TreeNodeWithDepth(root, 1));
        while (!stack.isEmpty()) {
            TreeNodeWithDepth node = stack.pop();
            if (node.node != null) {
                if (node.depth > depth) {
                    depth = node.depth;
                }
                stack.push(new TreeNodeWithDepth(node.node.left, depth + 1));
                stack.push(new TreeNodeWithDepth(node.node.right, depth + 1));
            }
        }
        return depth;
    }
}

class TreeNodeWithDepth {
    TreeNode node;
    int depth;

    public TreeNodeWithDepth(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
