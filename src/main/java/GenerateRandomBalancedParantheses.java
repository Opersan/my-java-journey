import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomBalancedParantheses {

    static final char[] arr = {'(', ')'};
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(generateParentheses(8, 1, 0, 0, new StringBuilder()));
        }
    }

    public static StringBuilder generateParentheses(int length, int opening, int openCount, int closeCount, StringBuilder result)
    {
        StringBuilder sb = result;

        if (openCount == length / 2) {
            opening = 0;
        }
        if (openCount + closeCount == length){
            return result;
        }
        if (openCount == closeCount) {
            opening = 1;
        }

        if (opening == 1) {
            sb.append('(');
            openCount++;
        }
        else if (opening == 0) {
            sb.append(')');
            closeCount++;
        }

        generateParentheses(length, new Random().nextInt(2), openCount, closeCount, sb);

        return result;
    }
}
/// ()() (())