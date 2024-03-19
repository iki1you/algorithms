import java.util.Scanner;
import java.util.Stack;

public class l3_3 {
        //      10
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

        //  1. "(()()()()()()()()()()[]]" - неправильно, последняя скобка не закрыта
        //  2. "[[][][][][][][][][][][][]]" - правильно
        //  3. "([()([()([()([()([()]])])])])" - правильно
        //  4. "([][][][][][][][][][][][][]" - неправильно, первая скобка не открыта
        //  5. "([()()()()()()()()()()())]" - правильно
        //  6. "(([[]])()(()))((()))" - неправильно, не все скобки закрыты
        //  7. "([(()())])([()])([()])" - правильно
        //  8. "([()])([()])([()])([()]" - неправильно, последняя скобка не закрыта
        //  9. "([[]])([[]])([[]])([[])" - неправильно, последняя скобка не закрыта
        //  10. "([(([]))])((()))((()))" - правильно
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String bracket = in.nextLine();
            if (CheckBrackets(bracket)){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
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
