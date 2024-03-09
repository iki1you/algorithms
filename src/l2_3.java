import java.util.*;

public class l2_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var n = in.nextInt();
        int[][] rect = new int[n][2];

        for (int i = 0; i < n; i++) {
            rect[i][0] = in.nextInt();
            rect[i][1] = in.nextInt();
        }

        var rectEnum = Graham(rect, n);
        double sum = 0;
        for (int i = 0; i < rectEnum.size() - 1; i++){
            sum += Distance(rect[rectEnum.get(i)], rect[rectEnum.get(i + 1)]);
        }
        sum += Distance(rect[rectEnum.get(0)], rect[rectEnum.get(rectEnum.size() - 1)]);
        System.out.println(Math.round(sum * 100) / 100.0);
    }

    public static double Distance(int[] a, int[] b){
        return Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
    }

    public static Stack<Integer> Graham(int[][] rect, int n) {
        var P = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            P.add(i);
        }
        for (int i = 0; i < n; i++){
            if (rect[P.get(i)][0] < rect[P.get(0)][0]){
                Collections.swap(P, 0, i);
            }
        }
        for (int i = 2; i < n; i++){
            int j = i;
            while (j > 1 && rotate(rect[P.get(0)], rect[P.get(j - 1)], rect[P.get(j)]) < 0) {
                Collections.swap(P, j, j - 1);
                j -= 1;
            }
        }
        var stack = new Stack<Integer>();
        stack.add(P.get(0));
        stack.add(P.get(1));
        for (int i = 2; i < n; i++){
            while (rotate(rect[stack.get(stack.size() - 2)], rect[stack.get(stack.size() - 1)], rect[P.get(i)]) < 0){
                stack.pop();
            }
            stack.add(P.get(i));
        }
        return stack;
    }

    public static int rotate(int[] a, int[] b, int[] c){
        return (b[0] - a[0]) * (c[1] - b[1]) - (b[1] - a[1]) * (c[0] - b[0]);
    }
}
