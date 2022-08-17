import java.util.Arrays;
import java.util.Scanner;

public class Main {
//
//    public static int[] array = new int[9];
//    public static String result = "";
//    String[] names[];
//

    public static void main(String[] args) {
    tinkoff();


    }

    public static void tinkoff() {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()) { // возвращает истину если с потока ввода можно считать целое число
            int i = sc.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
            int k = sc.nextInt();
            System.out.println(i + k);
        }
    }



}
