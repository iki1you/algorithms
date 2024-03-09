import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.*;


public class test_1 {

    @Tag("1")
    @Test
    void TestN1()
    {
        System.out.println("======TEST 1 EXECUTED=======");
        // input: 1 2 6 8 7 3 0 4 1 6 2 3 9 0      out: 4 7 8 9
        var A = new HashSet<>(Arrays.asList(1, 2, 6, 8, 7, 3));
        var B = new HashSet<>(Arrays.asList(4, 1, 6, 2, 3, 9));
        var C = new ArrayList<>(Arrays.asList(4, 7, 8, 9));
        Assertions.assertEquals(l1_1.symmetricDifference(A, B), C);
    }

    @Tag("3")
    @Test
    void TestN3()
    {
        System.out.println("======TEST 3 EXECUTED=======");
        // 232
        // +         out:   132
        // -100

        // -100
        // -         out:  -299
        // 199

        var n = "232";
        var k = "+";
        var m = "-100";
        String out = null;
        LongNumber first = new LongNumber(n);
        LongNumber second = new LongNumber(m);
        if (Objects.equals(k, "+")) {
            out = first.plus(second).toString();
        } else if (Objects.equals(k, "-")) {
            out = first.minus(second).toString();
        }
        Assertions.assertEquals(out, "132");

        n = "-100";
        k = "-";
        m = "199";
        out = null;
        first = new LongNumber(n);
        second = new LongNumber(m);
        if (Objects.equals(k, "+")) {
            out = first.plus(second).toString();
        } else if (Objects.equals(k, "-")) {
            out = first.minus(second).toString();
        }
        Assertions.assertEquals(out, "-299");
    }

    @Tag("6")
    @Test
    void TestN6()
    {
        System.out.println("======TEST 6 EXECUTED=======");
        //  5                     4
        //  8 9 6 9 8

        //  6                     2
        //  14 2 12 9 9 8

        int n = 5;
        int[] array = new int[] {8, 9, 6, 9, 8};
        Assertions.assertEquals(l1_6.getMinDifference(n - 1, 0, 0, array), 4);

        n = 6;
        array = new int[] {14, 2, 12, 9, 9, 8};
        Assertions.assertEquals(l1_6.getMinDifference(n - 1, 0, 0, array), 2);
    }


    @Tag("9")
    @Test
    void TestN9()
    {
        System.out.println("======TEST 9 EXECUTED=======");
        //  5 3 3
        //  1 3
        //  2 5
        //  5 4

        int n = 5;
        int[] array = new int[] {8, 9, 6, 9, 8};
        Assertions.assertEquals(l1_6.getMinDifference(n - 1, 0, 0, array), 4);

        n = 6;
        array = new int[] {14, 2, 12, 9, 9, 8};
        Assertions.assertEquals(l1_6.getMinDifference(n - 1, 0, 0, array), 2);
    }
}