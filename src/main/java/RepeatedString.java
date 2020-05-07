import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int[] charCount = {0};
        s.chars().forEach(ch -> {
            if(ch == 'a')
                charCount[0]++;
        });
        long numRepeats = n/s.length();
        long[] aCount = new long[1];
        aCount[0] = numRepeats*charCount[0];
        s.substring(0, (int) (n - s.length()*numRepeats)).chars().forEach(ch -> {
            if(ch == 'a') {
                aCount[0]++;
            }
        });
        return aCount[0];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(String.valueOf(result));

        scanner.close();
    }

}
