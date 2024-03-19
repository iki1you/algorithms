public class Deque {
    private int front, rear;
    private int[] dequeArray;

    public Deque(int N){
        dequeArray = new int[N];
        front = -1;
        rear = 0;
    }

    public  void  addFront(int value){
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            rear = dequeArray.length - 1;
        } else {
            front--;
        }
        dequeArray[front] = value;
    }

    public void addRear(int value){
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == dequeArray.length - 1){
            rear = 0;
        } else {
            rear++;
        }
        dequeArray[front] = value;
    }


}
