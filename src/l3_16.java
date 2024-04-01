import java.util.ArrayList;
import java.util.Scanner;


public class l3_16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        double sumPrice = getMinPrice(array);
        System.out.println(sumPrice);
    }

    private static double getMinPrice(int[] array) {
        var heap = new BinaryHeap(array);

        int sumPrice = 0;
        while (heap.heapSize > 1) {
            int merge = heap.getMax() + heap.getMax();
            sumPrice += merge;
            heap.add(merge);
        }
        return sumPrice / 100.0;
    }
}

class BinaryHeap {
    ArrayList<Integer> body;
    int heapSize;


    public BinaryHeap(int[] array) {
        body = new ArrayList<Integer>();
        heapSize = array.length;
        for (int j : array) {
            body.add(j);
        }
        for (int i = heapSize / 2; i >= 0; i--)
        {
            heapify(i);
        }
    }

    public int getMax() {
        int result = body.get(0);
        body.set(0, body.get(heapSize - 1));
        body.remove(heapSize - 1);
        heapSize--;
        heapify(0);
        return result;
    }


    public void add(int value)
    {
        body.add(value);
        int i = heapSize;
        int parent = (i - 1) / 2;

        while (i > 0 && body.get(parent) > body.get(i))
        {
            int temp = body.get(i);
            body.set(i, body.get(parent));
            body.set(parent, temp);

            i = parent;
            parent = (i - 1) / 2;
        }
        heapSize ++;
    }

    public void heapify(int i)
    {
        int leftChild;
        int rightChild;
        int largestChild;

        for (; ; )
        {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if (leftChild < heapSize && body.get(leftChild) < body.get(largestChild))
            {
                largestChild = leftChild;
            }

            if (rightChild < heapSize && body.get(rightChild) < body.get(largestChild))
            {
                largestChild = rightChild;
            }

            if (largestChild == i)
            {
                break;
            }

            int temp = body.get(i);
            body.set(i, body.get(largestChild));
            body.set(largestChild, temp);
            i = largestChild;
        }
    }
}
