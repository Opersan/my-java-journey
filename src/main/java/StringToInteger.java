public class StringToInteger {

    public static void main(String[] args) {

    }

    public static int myAtoi(String s) {
        int sign = 1;
        try {
            StringBuilder str = new StringBuilder("0");
            int state = 0;
            boolean onlyDigits = false;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == ' ') {
                    if(onlyDigits) return sign * Integer.valueOf(str.toString());
                    continue;
                }
                else if(!onlyDigits && s.charAt(i) == '-') {
                    sign = -1;
                    state = 1;
                    onlyDigits = true;
                }
                else if(!onlyDigits && s.charAt(i) == '+') {
                    sign = 1;
                    state = 1;
                    onlyDigits = true;
                }
                else if(Character.isDigit(s.charAt(i))) {
                    str.append(s.charAt(i));
                    state = 1;
                    onlyDigits = true;
                } else if(Character.isAlphabetic(s.charAt(i)) ||  (!Character.isDigit(s.charAt(i)) &&
                        s.charAt(i) != '+' && s.charAt(i) != '-')) {
                    return sign * Integer.valueOf(str.toString());
                }
                else if (state == 1) {
                    return sign * Integer.valueOf(str.toString());
                }
            }

            return sign * Integer.valueOf(str.toString());
        } catch(IllegalArgumentException e) {
            if(sign == -1) return -2147483648;
            return 2147483647;
        }
    }
}
