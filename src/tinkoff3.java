import java.util.Scanner;

public class tinkoff3 {

    public static void main(String[] args) {
        division();
    }

    static void division() {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine().replaceAll("\\*", "");
        String result = "";
        int intNumber = Integer.parseInt(number);
        for (int i = 1; i <= 10; i++) {
            if (intNumber % i == 0) {
                result = result + " " + i;
            }
        }
        System.out.println(result.trim());
    }

}
