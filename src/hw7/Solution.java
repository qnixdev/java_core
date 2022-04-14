package hw7;

public class Solution {
    public static int maxDepth(String s) {
        int answer = 0;
        int tmp = 0;

        for (char nextChar : s.toCharArray()) {
            if (nextChar == '(') {
                tmp++;
                answer = Math.max(answer, tmp);
            } else if (nextChar == ')') {
                tmp--;
                answer = Math.max(answer, tmp);
            }
        }

        return answer;
    }
}