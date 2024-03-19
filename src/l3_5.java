import java.util.Scanner;

public class l3_5 {
    // 10
    // 1 3 2 4 5 6 7 8 9 10
    // yes

    // 7
    // 1 2 4 6 7 9 10
    // yes
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var n = in.nextInt();
        var array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = in.nextInt();
        }
        boolean result = isHeap(n, array);
        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isHeap(int n, int[] array) {
        for (int i = 1; i <= n; i++) {
            if ((!(2 * i <= n) || array[i] <= array[2 * i]) &&
                    (!(2 * i + 1 <= n) || array[i] <= array[2 * i + 1])) {
                continue;
            }
            return false;
        }
        return true;
    }
}
