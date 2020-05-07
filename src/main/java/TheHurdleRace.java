import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;

public class TheHurdleRace {

    /*
    https://www.hackerrank.com/challenges/the-hurdle-race/problem
     */
    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
        OptionalInt max = Arrays.stream(height).max();
        if (!max.isPresent())
            return 0;
        else
            return max.getAsInt() > k ? max.getAsInt() - k : 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] height = new int[n];

        String[] heightItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightItems[i]);
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);

        System.out.println(String.valueOf(result));

        scanner.close();
    }

}
