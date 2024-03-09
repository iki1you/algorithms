import java.util.Objects;
import java.util.Scanner;
public class l1_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var n = in.nextLine();
        var k = in.nextLine();
        var m = in.nextLine();
        LongNumber first = new LongNumber(n);
        LongNumber second = new LongNumber(m);
        if (Objects.equals(k, "+")) {
            System.out.println(first.plus(second).toString());
        } else if (Objects.equals(k, "-")) {
            System.out.println(first.minus(second).toString());
        }
    }
}

