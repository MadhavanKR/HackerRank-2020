import java.util.Scanner;

public class HighestValuePalindrome {

    static String highestValuePalindromeV2(String s, int n, int k) {
        int minNum = minNumToPalindrome(s, n);
        //System.out.println("minimum number of changes to make it a palindrome = " + minNum);
        if (minNum > k)
            return "-1";
        int half = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int i = 0;
        char[] palindrome = new char[n];
//        System.out.println("half = " + half);
        while (i < half) {
//            System.out.println("am i even looping?");
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                if (k - 2 >= minNum - 1) {
                    palindrome[i] = palindrome[n - i - 1] = '9';
                    k -= 2;
                    minNum -= 1;
                } else if (s.charAt(i) == '9' || s.charAt(n - i - 1) == '9') {
                    palindrome[i] = palindrome[n - i - 1] = '9';
                    k -= 1;
                    minNum -= 1;
                } else {
                    if (s.charAt(i) > s.charAt(n - i - 1)) {
                        palindrome[i] = palindrome[n - i - 1] = s.charAt(i);
                    } else {
                        palindrome[i] = palindrome[n - i - 1] = s.charAt(n - i - 1);
                    }
                    k--;
                    minNum--;
                }
            } else {
                //System.out.println("i = " + i + " here in else part");
                if (s.charAt(i) != '9') {
                    if(i==half-1) {
                        if(k-1 >= minNum)
                            palindrome[i] = '9';
                        else
                            palindrome[i] = s.charAt(i);
                    } else {
                        if(k-2 >= minNum) {
                            palindrome[i] = palindrome[n - i - 1] = '9';
                            k -= 2;
                        } else {
                            palindrome[i] = palindrome[n - i - 1] = s.charAt(i);
                        }
                    }
                } else {
                    palindrome[i] = palindrome[n - i - 1] = s.charAt(i);
                }
            }

            i++;
        }
        //System.out.println("while exiting k = " + k +" minNum = " + minNum);
        return new String(palindrome);
    }

    static int minNumToPalindrome(String s, int n) {
        int half = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int i = 0;
        int count = 0;
        while (i < half) {
            if (s.charAt(i) != s.charAt(n - i - 1))
                count++;
            i++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindromeV2(s, n, k);

        System.out.println(result);

        scanner.close();
    }

}
