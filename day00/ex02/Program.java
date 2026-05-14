import java.util.Scanner;

public class Program {

    public static int SumNumber(int number) {

        int tmp = number > 0 ? number : -number;
        int sum = 0;

        while (tmp / 10 > 0) {
            sum += tmp % 10;
            tmp = tmp / 10;
        }
        sum += tmp;
        return sum;
    }

    public static boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input;
        int count = 0;

        while ((input = scanner.nextInt()) != 42) {
            if (isPrime(SumNumber(input))) {
                count++;
            }
        }

        System.out.println("Count of coffee-request : " + count);
        scanner.close();
    }
}
