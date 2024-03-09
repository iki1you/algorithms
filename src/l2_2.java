import java.util.*;

public class l2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var n = in.nextInt();
        var k = in.nextInt();
        var priority = new int[k];
        for (int i = 0; i < k; i++) {
            priority[i] = in.nextInt() - 1;
        }
        var names = new String[n];
        var data = new int[n][k];
        for (int i = 0; i < n; i++) {
            names[i] = in.next();
            for (int j = 0; j < k; j++) {
                data[j][i] = in.nextInt();
            }
        }
        var res = SortPriority(names, data, priority);
        System.out.println(res);
    }

    public static ArrayList<String> SortPriority(String[] names, int[][] data, int[] priority) {
        var result = new ArrayList<>(List.of(names));
        for (int i = 0; i < data[0].length; i++) {
            for (int j = i + 1; j < data[0].length; j++) {
                if (!IsRight(data, i, j, 0, priority)) {
                    Collections.swap(result, i, j);
                }
            }
        }
        return result;
    }

    public static boolean IsRight(int[][] data, int ind1, int ind2, int col, int[] priority) {
        if (col >= data[0].length) {
            return true;
        }
        if (data[priority[col]][ind1] < data[priority[col]][ind2]) {
            return false;
        }
        if (data[priority[col]][ind1] > data[priority[col]][ind2]) {
            return true;
        }
        return IsRight(data, ind1, ind2, col + 1, priority);
    }
}
    // var dataPermutations = Permutations(new ArrayList<>(), new int[n], n, n, data[priority[0] - 1]);
    //for (int[] i: dataPermutations){
    //            System.out.println(Arrays.toString(i));
    //        }
    //public static ArrayList<int[]> Permutations(ArrayList<int[]> result, int[] array, int n, int k, int[] sortData) {
    //    if (k == 0)
    //    {
    //        result.add(array);
    //        return result;
    //    }
    //    for (int i = 0; i < n; i++){
    //        if (array[i] == 0) {
    //            int[] temp = array.clone();
    //            temp[i] = k;
    //            Permutations(result, temp, n, k - 1, sortData);
    //        }
    //    }
    //    return result;
    //}
