import java.util.*;

public class tinkoff2 {

    public static void main(String[] args) {
        table();
    }

    static void table() {

        int count = 0;

        Scanner sc = new Scanner(System.in);
        int countVariations = Integer.parseInt(sc.nextLine());

        String tableSize = sc.nextLine().trim();
        int endIndex = tableSize.indexOf(" ");
        int width = Integer.parseInt(tableSize.substring(0, endIndex));
        int hight = Integer.parseInt(tableSize.substring(endIndex + 1, tableSize.length()));


        List<Integer> arrayPrice = new ArrayList<Integer>();

        while (countVariations > count) {

            String clothSize = sc.nextLine().trim();
            int endIndexWidth = clothSize.indexOf(" ");
            int beginIndexSize = clothSize.lastIndexOf(" ");
            int widthCloth = Integer.parseInt(clothSize.substring(0, endIndexWidth));
            int hightCloth = Integer.parseInt(clothSize.substring(endIndexWidth + 1, beginIndexSize));
            int priceCloth = Integer.parseInt(clothSize.substring(beginIndexSize + 1, clothSize.length()));

            if ((widthCloth >= width && hightCloth >= hight) || (widthCloth >= hight && hightCloth >= width)) {
                arrayPrice.add(priceCloth);
            }
            count = count + 1;
        }

        System.out.println(arrayPrice.stream().min(Integer::min).get());

    }


}