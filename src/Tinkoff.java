import java.util.*;

public class Tinkoff {

    public static void main(String[] args) {
        candies();
    }

    static void candies() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int boxA = sc.nextInt();
            int boxB = sc.nextInt();
            int maxСandies = sc.nextInt();
            int result;
            if (boxA + boxB < maxСandies) {
                result = boxA + boxB;
            } else {
                result = maxСandies;
            }
            System.out.println(result);

        }
    }

}
