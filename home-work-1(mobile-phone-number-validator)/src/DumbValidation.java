
public class DumbValidation {
    private static String[] operatorCodes =
            {"39", "50", "63", "66", "67", "68", "91", "92", "93", "94", "95", "96", "97", "98", "99"};

    public static boolean isValid(String phone) {
        if (phone.substring(0, 2).equals("00")) {
            if (phone.substring(2, 5).equals("380")) {
                if (isCorrectCode(phone.substring(5, 7)) && phone.length() == 14) {
                    return true;
                }
            }
        } else if (phone.charAt(0) == '0' && phone.charAt(1) != 0) {
            if (isCorrectCode(phone.substring(1, 3)) && phone.length() == 10) {
                return true;
            }
        } else if (phone.charAt(0) == '+' && phone.substring(1, 4).equals("380")) {
            if (isCorrectCode(phone.substring(4, 6)) && phone.length() == 13) {
                return true;
            }
        } else if (phone.charAt(0) == '8' && phone.charAt(1) == '0') {
            if (isCorrectCode(phone.substring(2, 4)) && phone.length() == 11) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCorrectCode(String enteredCode) {
        for (String code : operatorCodes) {
            if (code.equals(enteredCode)) {
                return true;
            }
        }
        return false;
    }
}
