import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class l4_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var anagrams = new ArrayList<BinarySearchTree2>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            var tree = new BinarySearchTree2();
            String input = in.next();
            for (int j = 0; j < input.length(); j++) {
                tree.insert(input.charAt(j));
            }

            boolean isConsists = false;
            for (int j = 0; j < anagrams.size(); j++) {
                if (BinarySearchTree2.compareTrees(tree, anagrams.get(j))) {
                    isConsists = true;
                }
            }
            if (!isConsists) {
                anagrams.add(tree);
            }
        }

        for (BinarySearchTree2 anagram : anagrams) {
            var stack = new Stack<Character>();
            anagram.inorder(stack);
            System.out.println(stack);
        }

        System.out.println(anagrams.size());
    }
}


class TreeNode2 {
    char key;
    TreeNode2 left, right;

    public TreeNode2(char item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree2 {
    TreeNode2 root;

    public BinarySearchTree2() {
        root = null;
    }

    void insert(char key) {
        root = insertRec(root, key);
    }

    TreeNode2 insertRec(TreeNode2 root, char key) {
        if (root == null) {
            root = new TreeNode2(key);
            return root;
        }

        if (key <= root.key) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void inorder(Stack<Character> stack) {
        inorderRec(root, stack);
    }

    void inorderRec(TreeNode2 root, Stack<Character> stack) {
        if (root != null) {
            inorderRec(root.left, stack);
            stack.add(root.key);
            inorderRec(root.right, stack);
        }
    }

    static boolean compareTrees(BinarySearchTree2 treeFirst, BinarySearchTree2 treeSecond) {
        var first = new Stack<Character>();
        var second = new Stack<Character>();
        treeFirst.inorder(first);
        treeSecond.inorder(second);
        return first.equals(second);
    }
}