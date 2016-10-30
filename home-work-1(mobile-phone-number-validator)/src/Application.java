import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static void validateWithRegExp() {
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String phone = "";
        boolean valid;
        do {
            System.out.println("Please, enter the phone number:");
            try {
                phone += bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            valid = RegExpValidation.isValid(phone);
            if (valid) {
                System.out.println("Phone number is correct!!!");
            } else {
                System.out.println("Phone number is incorrect");
                phone = "";
            }
        } while (!valid);

        int sum = getSum(phone);

        printSum(sum);
    }

    private static void printSum(int sum) {
        String prefix = "The result is: ";
        switch (sum) {
            case 1:
                System.out.println(prefix + "One");
                break;
            case 2:
                System.out.println(prefix + "Two");
                break;
            case 3:
                System.out.println(prefix + "Three");
                break;
            case 4:
                System.out.println(prefix + "Four");
                break;
            default:
                System.out.println(prefix + sum);
        }
    }

    static int round = 1;

    private static int getSum(String phone) {
        int sum = 0;
        for (int i = 0; i < phone.length(); i++) {
            sum += Character.getNumericValue(phone.charAt(i));
        }
        System.out.println(round + "st round of calculation, sum is " + sum);
        if (sum > 9) {
            round++;
            String sumRow = Integer.toString(sum);
            sum = getSum(sumRow);
        }
        return sum;
    }
}
