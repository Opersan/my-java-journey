public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        StringBuilder str = new StringBuilder("");
        if(s.isEmpty()) return 0;
        else if(s.isBlank()) return 1;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(str.indexOf(Character.toString(s.charAt(j))) == -1) {
                    str.append(Character.toString(s.charAt(j)));
                } else {
                    str.setLength(0);
                    break;
                }
                if(str.length() > max) max = str.length();
            }
        }
        return max;
    }
}
