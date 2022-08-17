import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class tinkoff4 {

    public static void main(String[] args) {
        bank();
    }

    static void bank() {
        Scanner sc = new Scanner(System.in);

        String count = sc.nextLine();
        String accounts = sc.nextLine();

        int[] numArr = Arrays.stream(accounts.split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> arrayPrice = new ArrayList<Integer>();
        for (int i = 0; i < numArr.length; i++) {
            arrayPrice.add(numArr[i]);
        }

        //arrayPrice.stream().sorted().forEach(System.out::println);
        double result = 0;
        arrayPrice.stream().sorted();
        int sumMoney = arrayPrice.stream().mapToInt(x -> x).sum();
        for (int i = 1; i < arrayPrice.size(); i++) {
            result = (result + arrayPrice.get(i - 1)) * 0.95;
            //System.out.println(result);
        }
        result = result + arrayPrice.get(arrayPrice.size() - 1);
        double searchResult = result - sumMoney;
        System.out.printf("%.4f", Math.abs(searchResult));
    }
}
