import java.util.Scanner;

public class l4_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] V = new int[n];
        for (int i = 0; i < n; i++) {
            V[i] = in.nextInt();
        }

        int[] sumArray = new int[n];
        calculate(V, sumArray);

        boolean actual = true;
        int code, first, second;
        for (int i = 0; i < m; i++) {
            code = in.nextInt();
            first = in.nextInt();
            second = in.nextInt();
            if (code == 2) {
                actual = false;
                V[first] = second;
                continue;
            }
            if (!actual) {
                calculate(V, sumArray);
                actual = true;
            }
            if (code == 1) {
                System.out.println(getSum(sumArray, first, second));
            }
        }
    }

    public static int getSum(int[] array, int L, int R) {
        if (L == 0) {
            return array[R];
        }
        return array[R] - array[L - 1];
    }

    public static void calculate(int[] inArray, int[] outArray) {
        outArray[0] = inArray[0];
        for (int i = 1; i < outArray.length; i++) {
            outArray[i] = outArray[i - 1] + inArray[i];
        }
    }
}
