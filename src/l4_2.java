import java.util.Scanner;
import java.util.Stack;

public class l4_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        var foundTrees = new BinarySearchTree[n];
        for (int i = 0; i < n; i++) {
            var tree = new BinarySearchTree();
            for (int j = 0; j < m; j++) {
                tree.insert(in.nextInt());
            }
            foundTrees[i] = tree;
        }

        for (int i = 0; i < k; i++) {
            var tree = new BinarySearchTree();
            for (int j = 0; j < m; j++) {
                tree.insert(in.nextInt());
            }

            boolean result = false;
            for (int j = 0; j < n; j++) {
                if (BinarySearchTree.compareTrees(tree, foundTrees[j])) {
                    result = true;
                    break;
                }
            }

            if (result) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}


class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key <= root.key) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void inorder(Stack<Integer> stack) {
        inorderRec(root, stack);
    }

    void inorderRec(TreeNode root, Stack<Integer> stack) {
        if (root != null) {
            inorderRec(root.left, stack);
            stack.add(root.key);
            inorderRec(root.right, stack);
        }
    }

    static boolean compareTrees(BinarySearchTree treeFirst, BinarySearchTree treeSecond) {
        var first = new Stack<Integer>();
        var second = new Stack<Integer>();
        treeFirst.inorder(first);
        treeSecond.inorder(second);
        return first.equals(second);
    }
}
