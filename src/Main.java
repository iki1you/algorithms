import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//  5
//  9 10
//  9,30 11
//  10 11,30
//  12 13,30
//  11 13,20
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[][] array = new double[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = in.nextDouble();
            array[i][1] = in.nextDouble();
        }
        QuickSort(array, 1, array.length - 1);
        var result = selectElems(array);
        for (var i: result) {
            System.out.println(i[0] + " " + i[1]);
        }
    }

    public static ArrayList<double[]> selectElems(double[][] arr) {
        var result = new ArrayList<double[]>();
        if (arr.length > 0) {
            result.add(arr[0]);
        }
        for (int i = 1; i < arr.length; i++) {
            if (result.get(result.size() - 1)[1] <= arr[i][0]) {
                result.add(arr[i]);
            }
        }
        return result;
    }

    public static void QuickSort(double[][] arr, int p, int r){
        if (p < r) {
            int q = Partition(arr, p, r);
            QuickSort(arr, p, q - 1);
            QuickSort(arr, q + 1, r);
        }
    }

    public static int Partition(double[][] arr, int p, int r) {
        double[] x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if (compare(x, arr[j])){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    public static void swap(double[][] arr, int i, int j){
        double[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean compare(double[] timeA, double[] timeB) {
        return timeA[1] >= timeB[1];
    }
}


//class Node {
//    public LinkedList<String> value = new LinkedList<String>();
//
//    public Node(String value) {
//        this.value.add(value);
//    }
//}
//
//class MyHashTable {
//    public int size = 1000000;
//    private Node[] array;
//
//
//    MyHashTable() {
//        array = new Node[size];
//    }
//
//    public void Put(String string) {
//        int key = getHash(string);
//        if (array[key] != null) {
//            array[key].value.add(string);
//        } else {
//            array[key] = new Node(string);
//        }
//    }
//
//    public LinkedList<String> Get(int hash) {
//        if (array[hash] == null || hash > size) {
//            throw new KeyAlreadyExistsException();
//        }
//        return array[hash].value;
//    }
//
//    public void Delete(int hash) {
//        if (array[hash] == null || hash > size) {
//            throw new KeyAlreadyExistsException();
//        }
//        array[hash].value.clear();
//    }
//
//    int getHash(String s) {
//        int h = 0;
//        for (int i = 0; i < s.length(); i++) {
//            h = (h * 31 + (int)s.charAt(i)) % 7;
//        }
//        System.out.println(h);
//        return h;
//    }
//}

//class RedBlackTree {
//    private static final boolean RED = true;
//    private static final boolean BLACK = false;
//
//    class Node {
//        int key;
//        boolean color;
//        Node left, right, parent;
//
//        public Node(int key) {
//            this.key = key;
//            color = RED;
//            left = right = parent = null;
//        }
//    }
//    private Node root;
//    public RedBlackTree() {
//        root = null;
//    }
//
//    private  boolean isRed(Node node) {
//        if (node == null) {
//            return false;
//        }
//        return node.color == RED;
//    }
//
//    private Node rotateLeft(Node h) {
//        //TODO
//        return h;
//    }
//
//    private Node rotateRight(Node h) {
//        //TODO
//        return h;
//    }
//
//    private void flipColors(Node h) {
//        h.color = RED;
//        h.left.color = h.right.color = BLACK;
//    }
//
//    public void insert(int key) {
//        root = insert(root, key);
//        root.color = BLACK;
//    }
//
//    private Node insert(Node h, int key) {
//        //TODO
//        return h;
//    }
//
//    public Node search(int key) {
//        //TODO
//        return new Node(2);
//    }
//
//    public void delete(int key) {
//        root = delete(root, key);
//    }
//
//    private Node delete(Node h, int key) {
//        //TODO
//        return h;
//    }
//
//    private  Node deleteMin(Node h) {
//        if (h.left == null) return h.right;
//        h.left = deleteMin(h.left);
//        return h;
//    }
//
//    private Node findMin(Node node) {
//        Node current = node;
//        while (current.left != null) current = current.left;
//        return current;
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        var n = in.nextInt();
//        var m = in.nextInt();
//
//        var k1 = in.nextInt();
//        int[][] keyOne = new int[k1][4];
//        for (int i = 0; i < k1; i++){
//            keyOne[i] = new int[] {in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
//        }
//
//        var k2 = in.nextInt();
//        int[][] keyTwo = new int[k2][4];
//        for (int i = 0; i < k2; i++){
//            keyTwo[i] = new int[] {in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
//        }
//
//        Integer maxCount = getMaxCount(n, m, keyOne, keyTwo);
//
//        System.out.println(maxCount);
//    }
//
//    private static Integer getMaxCount(int n, int m, int[][] keyOne, int[][] keyTwo) {
//        int maxCount = 0;
//        for (float i = -n - 1; i <= n + 1; i = (float) (i + 0.5)){
//            for (float j = -m - 1; j <= m + 1; j = (float) (j + 0.5)){
//                int count = 0;
//                for (int[] first: keyOne) {
//                    for (int[] second: keyTwo){
//                        if (first[0] + i < second[2] && first[2] + i > second[0] && first[1] + j < second[3] && first[3] + j > second[1])
//                        {
//                            count++;
//                        }
//                    }
//                }
//                maxCount = Math.max(count, maxCount);
//                if (maxCount == Math.max(n, m)){
//                    return maxCount;
//                }
//            }
//        }
//        return maxCount;
//    }
//}

// import java.util.Scanner;
//
// public class Main {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         var n = in.nextInt();
//         var m = in.nextInt();
//
//         var k1 = in.nextInt();
//         int[][] keyOne = new int[k1][4];
//         for (int i = 0; i < k1; i++){
//             keyOne[i] = new int[] {in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
//         }
//
//         var k2 = in.nextInt();
//         int[][] keyTwo = new int[k2][4];
//         for (int i = 0; i < k2; i++){
//             keyTwo[i] = new int[] {in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
//         }
//
//         int maxCount = 0;
//         for (float i = -n - 1; i <= n + 1; i = (float) (i + 0.5)){
//             for (float j = -m - 1; j <= m + 1; j = (float) (j + 0.5)){
//                 int count = 0;
//                 for (int[] first: keyOne) {
//                     for (int[] second: keyTwo){
//                         if (first[0] + i < second[2] && first[2] + i > second[0] && first[1] + j < second[3] && first[3] + j > second[1])
//                         {
//                             count++;
//                         }
//                     }
//                 }
//                 maxCount = Math.max(count, maxCount);
//                 if (maxCount == Math.max(n, m)){
//                     System.out.println(maxCount);
//                     return;
//                 }
//             }
//         }
//
//         System.out.println(maxCount);
//     }
// }


//import java.util.Objects;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        var n = in.nextLine();
//        var k = in.nextLine();
//        var m = in.nextLine();
//
//        LongNumber first = new LongNumber(n);
//        LongNumber second = new LongNumber(m);
//        if (Objects.equals(k, "+")) {
//            System.out.println(first.plus(second).toString());
//        } else if (Objects.equals(k, "-")) {
//            System.out.println(first.minus(second).toString());
//        }
//    }
//}
//
//class LongNumber {
//    int arraySize = 130;
//    long base = 1000000000;
//    int size = 9;
//    long[] shardedNumber;
//    LongNumber (String input) {
//        int lengthString = input.length();
//        int length = lengthString / size + (lengthString % size != 0 ? 1: 0);
//        shardedNumber = new long[arraySize];
//        for (int i = length - 1; i >= 0; i--){
//            shardedNumber[arraySize - (length - i)] = Long.parseLong(
//                    input.substring(Math.max(0, lengthString - (length - i) * size), lengthString - (length - i - 1) * size));
//        }
//    }
//
//    LongNumber (long[] first) {
//        shardedNumber = first;
//    }
//
//    static long get(long[] shardedNumber, int index){
//        if (shardedNumber.length > index){
//            return shardedNumber[index];
//        }
//        return 0;
//    }
//
//    LongNumber plus(LongNumber other){
//        long[] result = new long[arraySize];
//
//        for (int i = shardedNumber.length - 1; i >= 1; i--){
//            long a = get(shardedNumber, i) + get(other.shardedNumber, i);
//            result[i] = a;
//        }
//
//        for (int i = shardedNumber.length - 1; i >= 1; i--){
//            if (result[i] > base){
//                result[i - 1] += 1;
//                result[i] -= base;
//            }
//        }
//
//        return new LongNumber(result);
//    }
//
//    LongNumber minus(LongNumber other){
//        long[] result = new long[arraySize];
//        for (int i = shardedNumber.length - 1; i >= 1; i--){
//            long a = get(shardedNumber, i) - get(other.shardedNumber, i);
//            result[i] = a;
//        }
//
//        for (int i = 1; i < shardedNumber.length; i++){
//            if (result[i] < 0){
//                if (result[i - 1] <= 0){
//                    break;
//                }
//                result[i - 1] -= 1;
//                result[i] += base;
//            }
//        }
//
//        return new LongNumber(result);
//    }
//
//    public String toString() {
//        StringBuilder result = new StringBuilder("");
//        for (int i = 1; i < shardedNumber.length; i++){
//            result.append(String.format("%09d", shardedNumber[i]));
//        }
//        return result.toString().replaceFirst("-", "").replaceFirst("^0+(?!$)", "");
//    }
//}


//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int m = in.nextInt();
//        int[][] pairs = new int[m][2];
//
//        for (int i = 0; i < m; i++) {
//            pairs[i][0] = in.nextInt();
//            pairs[i][1] = in.nextInt();
//        }
//
//        var resultA = getAllComb(new byte[n], new ArrayList<byte[]>(), k, n, 0);
//
//        ArrayList<Integer> teamA = getBestTeam(resultA, n, k, pairs);
//
//        for (int i = 0; i < k; i++) {
//            System.out.print(teamA.get(i));
//            if (i != k - 1){
//                System.out.print(' ');
//            }
//        }
//
//    }
//
//    private static ArrayList<Integer> getBestTeam(ArrayList<byte[]> result, int n, int k, int[][] pairs) {
//        int max_k = 0;
//        byte[] max_team = new byte[k];
//
//        for (byte[] i : result) {
//            int currentA = 0;
//            int currentB = 0;
//            for (int[] j : pairs){
//                currentA++;
//                currentB++;
//                for (int l : j){
//                    if (i[l - 1] == 0){
//                        currentA--;
//                        break;
//                    }
//                }
//                for (int l : j){
//                    if (i[l - 1] == 1){
//                        currentB--;
//                        break;
//                    }
//                }
//            }
//            if (currentA + currentB > max_k){
//                max_k = currentA + currentB;
//                max_team = i;
//            }
//        }
//
//        var teamA = new ArrayList<Integer>();
//        for (int i = 0; i < n; i++){
//            if (max_team[i] == 1){
//                teamA.add(i + 1);
//            }
//        }
//        return teamA;
//    }
//
//
//    public static ArrayList<byte[]> getAllComb(byte[] array, ArrayList<byte[]> result, int k, int n, int index){
//        if (k == 0)
//        {
//            result.add(array);
//            return result;
//        }
//        if (index == n){
//            return result;
//        }
//        byte[] temp = array.clone();
//        temp[index] = 1;
//        getAllComb(temp, result, k - 1, n, index + 1);
//        getAllComb(array.clone(), result, k, n, index + 1);
//        return result;
//    }
//}

// import java.util.ArrayList;
// import java.util.Scanner;
//
// public class Main {
//     public static void main(String[] args) {
//         try {
//
//
//
//         Scanner in = new Scanner(System.in);
//         int n = in.nextInt();
//         int k = in.nextInt();
//         int m = in.nextInt();
//         int[][] pairs = new int[m][2];
//
//         for (int i = 0; i < m; i++) {
//             pairs[i][0] = in.nextInt();
//             pairs[i][1] = in.nextInt();
//         }
//         ArrayList<Long> resultA = null;
//         try {
//             resultA = getAllComb(0, new ArrayList<>(), k, n, 0);
//         } catch (Exception e){
//             for(int i = 0; true;i++){
//                 i++;
//             }
//         }
//
//
//         ArrayList<Integer> teamA;
//         try {
//             teamA = getBestTeam(resultA, n, pairs);
//         } catch (Exception e){
//             for(int i = 0; true;i++){
//                 i++;
//             }
//         }
//
//
//         for (int i: teamA) {
//             System.out.print(i);
//             if (i != k - 1){
//                 System.out.print(' ');
//             }
//         }
//
//         } catch (Exception e){
//             for(int i = 0; true;i++){
//                 i++;
//             }
//         }
//     }
//
//     private static ArrayList<Integer> getBestTeam(ArrayList<Long> result, int n, int[][] pairs) {
//         int max_k = 0;
//         long max_team = 0;
//
//         for (long i : result) {
//             int currentA = 0;
//             int currentB = 0;
//             for (int[] j : pairs){
//                 currentA++;
//                 currentB++;
//                 for (int l : j){
//                     var f = i / (int)Math.pow(2, l);
//                     if (f == 0){
//                         currentA--;
//                         break;
//                     }
//                 }
//                 for (int l : j){
//                     var f = i / (int)Math.pow(2, l);
//                     if (f != 0){
//                         currentB--;
//                         break;
//                     }
//                 }
//             }
//             if (currentA + currentB > max_k){
//                 max_k = currentA + currentB;
//                 max_team = i;
//             }
//         }
//
//         var teamA = new ArrayList<Integer>();
//
//         for (int i = 1; i <= n; i++){
//             if (max_team % 2 == 1){
//                 teamA.add(n - i + 1);
//             }
//             max_team /= 2;
//         }
//
//         return teamA;
//
//     }
//
//
//     public static ArrayList<Long> getAllComb(long array, ArrayList<Long> result, int k, int n, int index){
//         if (k == 0)
//         {
//             result.add(array);
//             return result;
//         }
//         if (index == n){
//             return result;
//         }
//         getAllComb((long) (array +  Math.pow(2, index)), result, k - 1, n, index + 1);
//         getAllComb(array, result, k, n, index + 1);
//         return result;
//
//     }
// }


//    public static ArrayList<int[]> getAllComb(int[] array, int k, int n, ArrayList<int[]> result){
//        if (k == 0)
//        {
//            result.add(array);
//            return result;
//        }
//        for (int i = k - 1; i < n; i++){
//            if (array[i] == 0) {
//                int[] temp = array.clone();
//                temp[i] = 1;
//                getAllComb(temp, k - 1, n - 1, result);
//            }
//        }
//        return result;
//    }

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] array = new int[n];
//
//        for (int i = 0; i < n; i++){
//            array[i] = in.nextInt();
//        }
//
//        System.out.println(getMinDifference(n - 1, 0, 0, array));
//    }
//
//    public static int getMinDifference(int i, int sum1, int sum2, int[] arr){
//        if (i == -1)
//            return Math.abs(sum1 - sum2);
//        return Math.min(
//                getMinDifference(i - 1, sum1 + arr[i], sum2, arr),
//                getMinDifference(i - 1, sum1, sum2 + arr[i], arr)
//        );
//    }
//}

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//import java.util.HashSet;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int a = in.nextInt();
//        var A = new HashSet<Integer>();
//        var B = new HashSet<Integer>();
//
//        while (a != 0) {
//            A.add(a);
//            a = in.nextInt();
//        }
//        a = in.nextInt();
//        while (a != 0) {
//            B.add(a);
//            a = in.nextInt();
//        }
//
//        ArrayList<Integer> output = symmetricDifference(A, B);
//        if (output.size() == 0){
//            System.out.println(0);
//        }
//        else {
//            System.out.println(output);
//        }
//    }
//
//    public static ArrayList<Integer> symmetricDifference(HashSet<Integer> setA, HashSet<Integer> setB){
//        var result = new ArrayList<Integer>();
//        var tempSet = new HashSet<Integer>();
//        tempSet.addAll(setA);
//        tempSet.addAll(setB);
//        for (int elem : tempSet) {
//            if (setA.contains(elem) && setB.contains(elem))
//                continue;
//            result.add(elem);
//        }
//        Collections.sort(result);
//        return result;
//    }
//}