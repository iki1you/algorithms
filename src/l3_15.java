import java.util.Scanner;

public class l3_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] wires = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            wires[i] = in.nextInt();
            result = Math.max(result, wires[i]);
        }
        result = getWiresL(k, n, wires, result);
        System.out.println(result);
    }

    private static int getWiresL(int k, int n, int[] wires, int result) {
        int sum = 0;
        while (sum < k) {
            sum = 0;
            for (int i = 0; i < n; i++) {
                sum += wires[i] / result;
            }
            result--;
        }
        return result + 1;
    }
}
