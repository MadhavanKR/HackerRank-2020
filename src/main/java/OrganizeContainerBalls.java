import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrganizeContainerBalls {

    /*
        solution:
        1) Make a table of box totals (capacity of each box)
        2) Make a table of ball totals (total quantity of each ball type)
        3) Sort both tables
        4) If they are identical print Possible, otherwise print Impossible
     */

    static String organizingContainers(long[][] a) {
        ArrayList<Long> rowSum = new ArrayList<>();
        ArrayList<Long> colSum = new ArrayList<>();
        for(int row = 0; row < a.length; row++) {
            long tmpSum = 0;
            for(int col=0; col < a.length; col++) {
                tmpSum+=a[row][col];
            }
            rowSum.add(tmpSum);
        }
        for(int col = 0; col < a.length; col++) {
            long tmpSum = 0;
            for(int row=0; row < a.length; row++) {
                tmpSum+=a[row][col];
            }
            colSum.add(tmpSum);
        }
        Collections.sort(rowSum);
        Collections.sort(colSum);
        System.out.println("rowSum = " + rowSum);
        System.out.println("colSum = " + colSum);
        for(int i=0; i<rowSum.size(); i++) {
            if(!rowSum.get(i).equals(colSum.get(i))) {
                System.out.println("a = " + rowSum.get(i) + " and b = " + colSum.get(i));
                return "Impossible";
            }
        }
        return "Possible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long[][] container = new long[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);
            System.out.println("result = " + result);
        }
        scanner.close();
    }

}
