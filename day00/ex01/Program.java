import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        int iteration = 0;
        boolean isPrime = true;

        input = scanner.nextInt();

        if (input <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        for (int i = 2; i * i <= input; i++) {
            if (input % i == 0) {
                isPrime = false;
                break;
            }
            iteration++;
        }
        iteration++;
        System.out.println(isPrime + " " + iteration);
        scanner.close();
    }

}
