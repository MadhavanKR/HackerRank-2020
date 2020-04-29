import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DrawingBook {

    static int pageCount(int n, int p) {

        //number of pages to traverse from front is always page number / 2
        int front = p / 2;

        //number of pages to traverse from back will be (n-p)/2 if n is even, (n-p+1)/2 if n is odd
        int back;
        if (n % 2 == 0)
            back = (n - p + 1) / 2;
        else
            back = (n - p) / 2;
        return Math.min(front, back);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

        int n = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
