import java.util.Scanner;
import java.util.Stack;

public class l4_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        var tree = new BinarySearchTree();
        for (int i = 0; i < m; i++) {
            tree.insert(in.nextInt());
        }
        var stack = new Stack<Integer>();
        System.out.println(tree.search(9));
    }
}