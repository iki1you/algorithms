import java.io.*;
import java.util.*;

public class l2_5 {
    public static void main(String[] args) throws IOException {
        int len = fileLength();
        splitFile(1, len);
    }



    private static void splitFile(int n, int len) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            int count = 0;

            BufferedWriter bf_1 = new BufferedWriter(new FileWriter("buffer-1.txt"));
            BufferedWriter bf_2 = new BufferedWriter(new FileWriter("buffer-2.txt"));

            int a = 0;
            int b = 0;
            while ((line = reader.readLine()) != null) {
                if (count % (Math.pow(2, n)) >= Math.pow(2, n) / 2) {
                    if (a != 0){
                        bf_1.write("\n");
                    }
                    a++;
                    bf_1.write(line);
                    if (a!=0 && a % Math.pow(2, n - 1) == 0) {
                        bf_1.write("\n");
                    }
                } else {
                    if (b != 0){
                        bf_2.write("\n");
                    }
                    b++;
                    bf_2.write(line);
                    if (b!= 0 && b % Math.pow(2, n - 1) == 0) {
                        bf_2.write("\n");
                    }
                }

                count++;
            }

            bf_1.close();
            bf_2.close();
            reader.close();

            BufferedWriter input = new BufferedWriter(new FileWriter("input.txt"));
            BufferedReader bf_1_r = new BufferedReader(new FileReader("buffer-1.txt"));
            BufferedReader bf_2_r = new BufferedReader(new FileReader("buffer-2.txt"));

            int i = 0;
            int j = 0;
            var br_1 = bf_1_r.readLine();
            var br_2 = bf_2_r.readLine();
            while (i < a && j < b) {
                while (i < a && j < b && !br_1.isEmpty() && !br_2.isEmpty()) {
                    if (br_1.compareTo(br_2) < 0){
                        input.write(br_1);
                        br_1 = bf_1_r.readLine();
                        i++;
                    } else {
                        input.write(br_2);
                        br_2 = bf_2_r.readLine();
                        j++;
                    }
                    input.write("\n");
                }
                while (i < a && !br_1.isEmpty()){
                    input.write(br_1 + "\n");
                    br_1 = bf_1_r.readLine();
                    i++;
                }
                while (j < b && !br_2.isEmpty()){
                    input.write(br_2 + "\n");
                    br_2 = bf_2_r.readLine();
                    j++;
                }
                br_1 = bf_1_r.readLine();
                br_2 = bf_2_r.readLine();
            }
            while (i < a) {
                if (br_1.isEmpty()){
                    br_1 = bf_1_r.readLine();
                    continue;
                }
                input.write(br_1 + '\n');
                br_1 = bf_1_r.readLine();
                i++;
            }
            while (j < b) {
                if (br_2.isEmpty()){
                    br_2 = bf_2_r.readLine();
                    continue;
                }
                input.write(br_2 + '\n');
                br_2 = bf_2_r.readLine();
                j++;
            }
            input.close();
            bf_1_r.close();
            bf_2_r.close();

            if (len / 2 > n * 2) {
                splitFile(n + 1, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int fileLength(){
        String fileName = "input.txt";
        int lineCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.readLine() != null) {
                lineCount++;
            }
            reader.close();

            return lineCount;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
