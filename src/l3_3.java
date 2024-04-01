import java.util.Scanner;
import java.util.Stack;

public class l3_3 {
        //      (()()()()()()()()()()[]]
        //      [[][][][][][][][][][][][]]
        //      ([()([()([()([()([()]])])])])
        //      ([][][][][][][][][][][][][]
        //      ([()()()()()()()()()()())]
        //      (([[]])()(()))((()))
        //      ([(()())])([()])([()])
        //      ([()])([()])([()])([()]
        //      ([[]])([[]])([[]])([[])
        //      ([(([]))])((()))((()))

        //  1. "(()()()()()()()()()()[]]" - неправильно
        //  2. "[[][][][][][][][][][][][]]" - правильно
        //  3. "([()([()([()([()([()]])])])])" - неправильно
        //  4. "([][][][][][][][][][][][][]" - неправильно
        //  5. "([()()()()()()()()()()())]" - правильно
        //  6. "(([[]])()(()))((()))" - правильно
        //  7. "([(()())])([()])([()])" - правильно
        //  8. "([()])([()])([()])([()]" - неправильно
        //  9. "([[]])([[]])([[]])([[])" - неправильно
        //  10. "([(([]))])((()))((()))" - правильно
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] array = new String[10];
        for (int i = 0; i < 10; i++) {
            array[i] = in.nextLine();
            if (CheckBrackets(array[i])){
                array[i] = "YES";
            }
            else {
                array[i] = "NO";
            }
        }
        for (String i: array) {
            System.out.println(i);
        }
    }

    public static boolean CheckBrackets(String line) {
        var stack_rect = new Stack<Character>();
        var stack_round = new Stack<Character>();
        for (int i = 0; i < line.length(); i++) {
            switch (line.charAt(i)) {
                case '(' -> stack_round.add('(');
                case ')' -> {
                    if (stack_round.isEmpty()) {
                        return false;
                    }
                    stack_round.pop();
                }
                case '[' -> stack_rect.add('[');
                case ']' -> {
                    if (stack_rect.isEmpty()) {
                        return false;
                    }
                    stack_rect.pop();
                }
            }
        }
        return stack_round.isEmpty() && stack_rect.isEmpty();
    }
}
