public class ReverseInteger {
    public static void main(String[] args) {

    }

    public static int reverse(int x) {
        StringBuilder str = new StringBuilder("");
        String s = String.valueOf(x);
        try {
            if(x >= 0) {
                for(int i = s.length() - 1; i >= 0; i--) {
                    str.append(s.charAt(i));
                }
                return Integer.valueOf(str.toString());
            } else {
                for(int i = s.length() - 1; i >= 1; i--) {
                    str.append(s.charAt(i));
                }
                return 0 - Integer.valueOf(str.toString());
            }
        } catch(NumberFormatException e) {
            return 0;
        }

    }
}
