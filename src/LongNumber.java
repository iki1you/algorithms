import java.util.Objects;

public class LongNumber {
    int arraySize = 130;
    long base = 1000000000;
    int size = 9;
    long[] shardedNumber;
    LongNumber (String input) {
        int lengthString = input.length();
        int length = lengthString / size + (lengthString % size != 0 ? 1: 0);
        shardedNumber = new long[arraySize];
        for (int i = length - 1; i >= 0; i--){
            shardedNumber[arraySize - (length - i)] = Long.parseLong(
                    input.substring(Math.max(0, lengthString - (length - i) * size), lengthString - (length - i - 1) * size));
        }
    }
    LongNumber (long[] first) {
        shardedNumber = first;
    }
    static long get(long[] shardedNumber, int index){
        if (shardedNumber.length > index){
            return shardedNumber[index];
        }
        return 0;
    }
    LongNumber plus(LongNumber other){
        long[] result = new long[arraySize];
        for (int i = shardedNumber.length - 1; i >= 1; i--){
            long a = get(shardedNumber, i) + get(other.shardedNumber, i);
            result[i] = a;
        }
        for (int i = shardedNumber.length - 1; i >= 1; i--){
            if (result[i] > base){
                result[i - 1] += 1;
                result[i] -= base;
            }
        }
        return new LongNumber(result);
    }
    LongNumber minus(LongNumber other){
        long[] result = new long[arraySize];
        for (int i = shardedNumber.length - 1; i >= 1; i--){
            long a = get(shardedNumber, i) - get(other.shardedNumber, i);
            result[i] = a;
        }
        for (int i = 1; i < shardedNumber.length; i++){
            if (result[i] < 0){
                if (result[i - 1] <= 0){
                    break;
                }
                result[i - 1] -= 1;
                result[i] += base;
            }
        }
        return new LongNumber(result);
    }
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < shardedNumber.length; i++){
            result.append(String.format("%09d", shardedNumber[i]));
        }
        var sign = result.toString().contains("-");
        var out = result.toString().replaceFirst("-", "").replaceFirst("^0+(?!$)", "");
        if (sign) {
            return "-" + out;
        }
        return out;
    }
}
