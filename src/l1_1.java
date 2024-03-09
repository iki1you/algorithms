import java.util.*;

public class l1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        var A = new HashSet<Integer>();
        var B = new HashSet<Integer>();
        while (a != 0) {
            A.add(a);
            a = in.nextInt();
        }
        a = in.nextInt();
        while (a != 0) {
            B.add(a);
            a = in.nextInt();
        }
        var output = symmetricDifference(A, B);
        if (output.length == 0){
            System.out.println(0);
        }
        else {
            System.out.println(Arrays.toString(output));
        }
    }
    public static int[] symmetricDifference(HashSet<Integer> setA, HashSet<Integer> setB){
        var result = new ArrayList<Integer>();
        var tempSet = new HashSet<Integer>();
        tempSet.addAll(setA);
        tempSet.addAll(setB);
        for (int elem : tempSet) {
            if (setA.contains(elem) && setB.contains(elem))
                continue;
            result.add(elem);
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            arr[i] = result.get(i);
        }
        QuickSort(arr, 1, arr.length - 1);
        return arr;
    }

    public static void QuickSort(int[] arr, int p, int r){
        if (p < r) {
            int q = Partition(arr, p, r);
            QuickSort(arr, p, q - 1);
            QuickSort(arr, q + 1, r);
        }
    }

    public static int Partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if (arr[j] <= x){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}