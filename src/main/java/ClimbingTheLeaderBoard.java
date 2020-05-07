import java.util.*;

public class ClimbingTheLeaderBoard {
    /*
     https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
     */

    static int[] climbingLeaderboard(int[] scores1, int[] alice) {

        int[] ranks;
        int[] result = new int[alice.length];
        TreeMap<Integer, Integer> scoreCountMap = new TreeMap<Integer, Integer>();
        scoreCountMap.put(scores1[0], 1);
        for (int i = 1; i < scores1.length; i++) {
            if (scoreCountMap.containsKey(scores1[i])) {
                scoreCountMap.put(scores1[i], scoreCountMap.get(scores1[i]) + 1);
            } else {
                scoreCountMap.put(scores1[i], 1);
            }
        }

        for (int i = 0; i < alice.length; i++) {
            Integer[] scores = getScores(scoreCountMap);
            ranks = getRanks(scores);
            if (scoreCountMap.containsKey(alice[i])) {
                result[i] = getScoreFor(alice[i], scores, ranks);
            } else {
                int j = 0;
                while (j < scores.length && alice[i] <= scores[j]) {
                    j++;
                }
                if (j == scores.length)
                    result[i] = ranks[j - 1] + 1;
                else
                    result[i] = ranks[j];
            }
            if (scoreCountMap.containsKey(alice[i])) {
                scoreCountMap.put(alice[i], scoreCountMap.get(alice[i]) + 1);
            } else {
                scoreCountMap.put(alice[i], 1);
            }
            //System.out.println("alice score: " + alice[i] + " ranks at " + result[i]);
        }
        return result;
    }

    private static int getScoreFor(int score, Integer[] scores, int[] ranks) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == score)
                return ranks[i];
        }
        return -1;
    }

    static int[] getRanks(Integer[] scores) {
        int[] ranks = new int[scores.length];
        ranks[0] = 1;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] == scores[i - 1]) {
                ranks[i] = ranks[i - 1];
            } else {
                ranks[i] = ranks[i - 1] + 1;
            }
        }
        return ranks;
    }

    static Integer[] getScores(TreeMap<Integer, Integer> scoreCountMap) {
        ArrayList<Integer> scores = new ArrayList<>();
        for (Integer score : scoreCountMap.descendingKeySet()) {
            for (int i = 0; i < scoreCountMap.get(score); i++) {
                scores.add(score);
            }
        }
        return scores.toArray(new Integer[scores.size()]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int scoresCount = Integer.parseInt(scanner.nextLine());

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = Integer.parseInt(scanner.nextLine());

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            if (i != result.length - 1) {
                System.out.println();
            }
        }
        scanner.close();
    }

}