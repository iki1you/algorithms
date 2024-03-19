import java.io.*;
import java.util.*;

public class l3_7 {
    public static void main(String[] args) throws IOException {
        var Compiler = new Compiler("quackProgram.txt");
        Compiler.runProgram();
        for (var line: Compiler.result) {
            System.out.println(line);
        }
    }
}


class Compiler {
    ArrayList<String> program;
    ArrayDeque<Integer> queue;
    Hashtable<Character, Integer> registers;
    Hashtable<String, Integer> labels;
    int progress;
    boolean inProgress;
    ArrayList<String> result;
    boolean isNextLine;


    Compiler(String input) throws IOException {
        labels = new Hashtable<>();
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line;
        program = new ArrayList<>();
        int i = 0;
        while ((line = reader.readLine()) != null) {
            program.add(line);
            if (line.charAt(0) == ':') {
                setLabel(line.substring(1), i);
            }
            i++;
        }
        reader.close();
        queue = new ArrayDeque<>();
        registers = new Hashtable<>();
        for (int j = 97; j <= 122; j++){
            registers.put((char) j, 0);
        }
        result = new ArrayList<>();
    }

    public void runProgram() {
        progress = 0;
        isNextLine = true;
        inProgress = true;
        while (progress < program.size() && inProgress) {
            workCommand(program.get(progress));
        }
        inProgress = false;
    }

    public void workCommand(String command) {
        switch (command.charAt(0)) {
            case '+' -> plus();
            case '-' -> minus();
            case '*' -> multi();
            case '/' -> div();
            case '%' -> mod();
            case '>' -> putRegister(command.charAt(1));
            case '<' -> getRegister(command.charAt(1));
            case 'P' -> {
                if (command.length() == 1) {
                    P();
                } else {
                    P(command.charAt(1));
                }
            }
            case 'C' -> {
                if (command.length() == 1) {
                    C();
                } else {
                    C(command.charAt(1));
                }
            }
            case ':' -> {}
            case 'J' -> jumpLabel(command.substring(1));
            case 'Z' -> jumpIfZeroRegister(command.charAt(1), command.substring(2));
            case 'E' -> jumpIfEquals(command.charAt(1), command.charAt(2), command.substring(3));
            case 'G' -> jumpIfBigger(command.charAt(1), command.charAt(2), command.substring(3));
            case 'Q' -> quit();
            default -> putNumber(Integer.parseInt(command));
        }
        progress++;
    }

    public void P() {
        if (isNextLine) {
            result.add(String.valueOf(queue.pop()));
        } else {
            result.set(result.size() - 1, result.get(result.size() - 1) + queue.pop());
        }
        isNextLine = true;
    }

    public void P(char register) {
        if (isNextLine) {
            result.add(String.valueOf(registers.get(register)));
        } else {
            result.set(result.size() - 1, result.get(result.size() - 1) + registers.get(register));
        }
        isNextLine = true;
    }

    public void C() {
        if (isNextLine) {
            result.add(String.valueOf((char)(queue.pop() % 256)));
        } else {
            result.set(result.size() - 1, result.get(result.size() - 1) + (char)(queue.pop() % 256));
        }
        isNextLine = false;
    }

    public void C(char register) {
        if (isNextLine) {
            result.add(String.valueOf((char)(registers.get(register) % 256)));
        } else {
            result.set(result.size() - 1, result.get(result.size() - 1) + (char)(registers.get(register) % 256));
        }
        isNextLine = false;
    }

    public void jumpIfZeroRegister(char register, String label) {
        if (registers.get(register) == 0) {
            jumpLabel(label);
        }
    }

    public void jumpIfEquals(char register1, char register2, String label) {
        if (registers.get(register1).equals(registers.get(register2))) {
            jumpLabel(label);
        }
    }

    public void jumpIfBigger(char register1, char register2, String label) {
        if (registers.get(register1) >= registers.get(register2)) {
            jumpLabel(label);
        }
    }

    public void quit() {
        inProgress = false;
    }

    public void putNumber(int number) {
        queue.add(number);
    }

    public void setLabel(String label, int index) {
        labels.put(label, index);
    }

    public void jumpLabel(String label) {
        progress = labels.get(label);
    }

    public void putRegister(char register) {
        registers.put(register, queue.pop());
    }

    public void getRegister(char register) {
        queue.add(registers.get(register));
    }

    public void plus() {
        queue.add((queue.pop() + queue.pop()) % 65536);
    }

    public void minus() {
        queue.add((queue.pop() - queue.pop()) % 65536);
    }

    public void multi() {
        queue.add((queue.pop() * queue.pop()) % 65536);
    }

    public void div() {
        int a = queue.pop();
        int b = queue.pop();
        if (b == 0){
            queue.add(0);
        } else {
            queue.add((a / b) % 65536);
        }
    }

    public void mod() {
        int a = queue.pop();
        int b = queue.pop();
        if (b == 0){
            queue.add(0);
        } else {
            queue.add(a % b);
        }
    }
}