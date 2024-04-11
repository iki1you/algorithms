import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class l4_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        var table = new MyHashTable();
        for (int i = 0; i < n; i++) {
            var input = in.readLine().split(" ");
            ResolveCommand(table, input);
        }
    }

    public static void ResolveCommand(MyHashTable table, String[] command) throws Exception {
        switch (command[0]) {
            case "ADD":
                if (table.Contains(command[1])) {
                    System.out.println("ERROR");
                } else {
                    table.Put(command[1], command[2]);
                }
                break;
            case "PRINT":
                if (!table.Contains(command[1])) {
                    System.out.println("ERROR");
                } else {
                    System.out.println(command[1] + " " + table.Get(command[1]));
                }
                break;
            case "EDITPHONE":
                if (!table.Contains(command[1])) {
                    System.out.println("ERROR");
                } else {
                    table.Set(command[1], command[2]);
                }
                break;
            case "DELETE":
                if (!table.Contains(command[1])) {
                    System.out.println("ERROR");
                } else {
                    table.Delete(command[1]);
                }
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }
}


class MyHashTable {
    public int size = 1000007;
    private String[] array;


    MyHashTable() {
        array = new String[size];
    }

    public void Put(String string, String value) throws Exception {
        int key = getHash(string);
        if (array[key] == null) {
            array[key] = value;
        } else {
            throw new Exception("el consists");
        }
    }

    public void Set(String string, String value) throws Exception {
        int key = getHash(string);
        if (array[key] != null) {
            array[key] = value;
        } else {
            throw new Exception("el not consists");
        }
    }

    public String Get(String string) {
        int hash = getHash(string);
        if (array[hash] == null || hash > size) {
            throw new KeyAlreadyExistsException();
        }
        return array[hash];
    }

    public boolean Contains(String string) {
        int hash = getHash(string);
        return array[hash] != null;
    }

    public void Delete(String key) throws Exception {
        int hash = getHash(key);
        if (array[hash] == null) {
            throw new Exception();
        }
        array[hash] = null;
    }

    int getHash(String s) {
        s = s.toLowerCase();
        int k = 31;
        int mod = size;
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a' + 1;
            h = (h * k + x) % mod;
        }
        return h;
    }
}