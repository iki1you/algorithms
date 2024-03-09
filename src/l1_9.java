import java.util.ArrayList;
import java.util.Scanner;

public class l1_9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        int[][] pairs = new int[m][2];

        for (int i = 0; i < m; i++) {
            pairs[i][0] = in.nextInt();
            pairs[i][1] = in.nextInt();
        }
        ArrayList<Long> resultA = getAllComb(0, new ArrayList<>(), k, n, 0);
        ArrayList<Integer> teamA = getBestTeam(resultA, n, pairs);

        for (int i: teamA) {
            System.out.print(i);
            if (i != k - 1){
                System.out.print(' ');
            }
        }

    }

    private static ArrayList<Integer> getBestTeam(ArrayList<Long> result, int n, int[][] pairs) {
        int max_k = 0;
        long max_team = 0;

        for (long i : result) {
            int currentA = 0;
            int currentB = 0;
            for (int[] j : pairs){
                currentA++;
                currentB++;
                for (int l : j){
                    var f = i / (int)Math.pow(2, l);
                    if (f == 0){
                        currentA--;
                        break;
                    }
                }
                for (int l : j){
                    var f = i / (int)Math.pow(2, l);
                    if (f != 0){
                        currentB--;
                        break;
                    }
                }
            }
            if (currentA + currentB > max_k){
                max_k = currentA + currentB;
                max_team = i;
            }
        }

        var teamA = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++){
            if (max_team % 2 == 1){
                teamA.add(n - i + 1);
            }
            max_team /= 2;
        }

        return teamA;

    }


    public static ArrayList<Long> getAllComb(long array, ArrayList<Long> result, int k, int n, int index){
        if (k == 0)
        {
            result.add(array);
            return result;
        }
        if (index == n){
            return result;
        }
        getAllComb((long) (array +  Math.pow(2, index)), result, k - 1, n, index + 1);
        getAllComb(array, result, k, n, index + 1);
        return result;

    }
}


 //  public static ArrayList<int[]> getAllComb(int[] array, int k, int n, ArrayList<int[]> result){
 //      if (k == 0)
 //      {
 //          result.add(array);
 //          return result;
 //      }
 //      for (int i = k - 1; i < n; i++){
 //          if (array[i] == 0) {
 //              int[] temp = array.clone();
 //              temp[i] = 1;
 //              getAllComb(temp, k - 1, n - 1, result);
 //          }
 //      }
 //      return result;
 //  }
