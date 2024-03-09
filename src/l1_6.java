import java.util.Scanner;
public class l1_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = in.nextInt();
        }
        System.out.println(getMinDifference(n - 1, 0, 0, array));
    }
    public static int getMinDifference(int i, int sum1, int sum2, int[] arr){
        if (i == -1)
            return Math.abs(sum1 - sum2);
        return Math.min(
                getMinDifference(i - 1, sum1 + arr[i], sum2, arr),
                getMinDifference(i - 1, sum1, sum2 + arr[i], arr)
        );
    }
}