public class Program {
    static int input = 479598;
    static int sum = 0;

    public static void main(String[] args) {

        int tmp = input > 0 ? input : -input;

        if (String.valueOf(tmp).length() != 6)
            return;

        while (tmp / 10 > 0) {
            sum += tmp % 10;
            tmp = tmp / 10;
        }
        sum += tmp;
        System.out.println(sum);
    }
}