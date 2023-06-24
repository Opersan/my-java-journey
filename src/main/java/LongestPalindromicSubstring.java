public class LongestPalindromicSubstring {
    public static void main(String[] args) {

    }

    public static String longestPalindrome(String s) {
        String str = "";
        for(int i = 0 ; i < s.length(); i++) {
            for(int j = i + str.length(); j <= s.length(); j++) {
                if(isPalindrome(s.substring(i, j))) {
                    if(s.substring(i, j).length() > str.length()) str = s.substring(i, j);
                }
            }
        }
        return str;
    }


    public static boolean isPalindrome(String s) {
        int index = s.length() - 1;
        for(int i = 0; i < index; i++) {
            if(s.charAt(i) != s.charAt(index)) return false;
            index--;
        }
        return true;
    }
}
