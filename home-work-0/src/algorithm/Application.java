package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        Fibonacci fibonacci = new FibonacciRecursive();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int member = 0;
        System.out.println("Please, enter index number of member:");
        for (int i = 0; i < 3; i++) {
            try {
                member = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                if (i==2)break;
                System.out.println("Please, enter integer value");
            }
        }

        System.out.println(fibonacci.getMemberValue(member));
    }
}

