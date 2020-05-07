import java.io.IOException;
import java.util.Scanner;

public class DesignerPdfViewer {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        int[] maxHeight={1};
        word.chars().forEach(ch -> {
            int pos = ch - 'a';
            if(maxHeight[0] < h[pos]) {
                maxHeight[0] = h[pos];
            }
        });
        return word.length()*maxHeight[0];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        System.out.println(String.valueOf(result));
        scanner.close();
    }

}
