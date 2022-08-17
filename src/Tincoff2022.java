import java.util.*;
import java.util.stream.*;

public class Tincoff2022 {

    public static void main(String[] args) {
        tinkoff2();
    }

    static void tinkoff1() {

        Scanner input = new Scanner(System.in);

        int[] numbers1 = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers2 = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        x.add(numbers1[0]);
        x.add(numbers1[2]);
        x.add(numbers2[0]);
        x.add(numbers2[2]);

        y.add(numbers1[1]);
        y.add(numbers1[3]);
        y.add(numbers2[1]);
        y.add(numbers2[3]);

        int widthX = Collections.max(x) - Collections.min(x);
        int widthY = Collections.max(y) - Collections.min(y);

        if (widthX > widthY) {
            System.out.println(widthX * widthX);
        } else {
            System.out.println(widthY * widthY);
        }
    }

    static void tinkoff2() {

        Scanner input = new Scanner(System.in);
        int countVariations = Integer.parseInt(input.nextLine());

        List<String> names = new ArrayList();
        List<String> namesSorted = new ArrayList();
        List<Integer> countRepeat = new ArrayList();

        for (int i = 0; i < countVariations; i++) {
            names.add(input.nextLine());
        }
        for (int i = 0; i < countVariations; i++) {
            char[] chars = names.get(i).toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            namesSorted.add(sorted);
        }
        for (int i = 0; i < countVariations; i++) {
            countRepeat.add(Collections.frequency(namesSorted, namesSorted.get(i)));
        }

        System.out.println(Collections.max(countRepeat));
    }

    static void tinkoff3() {

        Scanner input = new Scanner(System.in);
        int days = Integer.parseInt(input.nextLine());
        String numbersChar = input.nextLine();

        int[] numArr = Arrays.stream(numbersChar.split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxProfit = 0;
        for (int i = 0; i < days - 1; i = i + 2) {
            if (numArr[i + 1] > numArr[i] && numArr[i + 1] - numArr[i] > maxProfit) {
                maxProfit = numArr[i + 1] - numArr[i];
            } else {
                maxProfit = numArr[i + 1];
            }
        }

        System.out.println(maxProfit);

    }

    static void tinkoff5() {

        Scanner input = new Scanner(System.in);
        int[] numbers = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<String> names = new ArrayList();
        List<String> request = new ArrayList();


        for (int i = 0; i < numbers[0]; i++) {
            names.add(input.nextLine());
        }

        for (int i = 0; i < numbers[1]; i++) {
            request.add(input.nextLine());
        }

        List<String> namesSort = new ArrayList(names);
        Collections.sort(namesSort);

        List<Integer> lexigNumber = new ArrayList<>();
        List<String> prefix = new ArrayList<>();
        for (int i = 0; i < request.size(); i++) {
            lexigNumber.add(Integer.parseInt(request.get(i).replaceAll("[^0-9]", "")));
            prefix.add(request.get(i).replaceAll("[^a-zA-Z]", ""));
        }

        for (int i = 0; i < lexigNumber.size(); i++) {
            String pref = prefix.get(i);
            int countPref = lexigNumber.get(i) - 1;

            List<String> findSortedNames = namesSort.stream()
                    .filter(p -> p.length() >= pref.length())
                    .filter(p -> p.substring(0, pref.length()).equals(pref))
                    .collect(Collectors.toList());

            String findSortedName = findSortedNames.get(countPref);
            for (int k = 0; k < names.size(); k++) {
                if (names.get(k).equals(findSortedName)) {
                    System.out.println(k + 1);
                }
            }

        }

    }

    static void tinkoff6() {

        Scanner input = new Scanner(System.in);
        int countElevators = Integer.parseInt(input.nextLine());
        TreeMap<Integer, Integer> numbresMap = new TreeMap<>();

        for (int i = 0; i < countElevators; i++) {
            int[] numbers = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            numbresMap.put(numbers[0], numbers[1]);
        }

        int depth = countElevators - numbresMap.size();

        ArrayList<Integer> dataArray = new ArrayList<>();
        numbresMap.entrySet().forEach(entry -> {
//            System.out.println(entry.getKey() + " " + entry.getValue());
            dataArray.add(entry.getKey());
            dataArray.add(entry.getValue());
        });

        for (int i = 0; i < dataArray.size() - 2; i++) {
            if (dataArray.get(i + 1) == dataArray.get(i + 2)) {
                depth++;
            } else {
                i++;
            }
        }
        System.out.println(depth);

    }

    static void tinkoff7() {

        Scanner input = new Scanner(System.in);
        char[] dataChars = input.nextLine().toCharArray();
        List<Character> listDataChars = new ArrayList<>();
        for (int i = 0; i < dataChars.length; i++) {
            listDataChars.add(dataChars[i]);
        }

        int countVariations = Integer.parseInt(input.nextLine());

        List<int[]> variations = new ArrayList<>();
        for (int i = 0; i < countVariations; i++) {
            variations.add(Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        for (int i = 0; i < countVariations; i++) {

            List<Character> cutListDataChars = new ArrayList<>(listDataChars.subList(variations.get(i)[0] - 1, variations.get(i)[1]));
            List<Character> sortListDataChars = new ArrayList<>(listDataChars.subList(variations.get(i)[0] - 1, variations.get(i)[1]));
            Collections.sort(sortListDataChars);

            List<Character> copySortList = new ArrayList<>(sortListDataChars);
            List<Integer> indexList = new ArrayList<>();

            while (copySortList.size() > 0) {
                for (int j = 0; j < cutListDataChars.size(); j++) {
                    if (copySortList.size() > 0) {
                        if (copySortList.get(0) == cutListDataChars.get(j)) {
                            copySortList.remove(0);
                            indexList.add(j);
                        }
                    }

                }

            }

            int countSearch = indexList.get(0);
            for (int k = 0; k < indexList.size() - 1; k++) {
                if (indexList.get(k) > indexList.get(k + 1)) {
                    countSearch = countSearch + indexList.size() - indexList.get(k);
                } else {
                    countSearch = countSearch + indexList.get(k + 1) - indexList.get(k);

                }
            }
            System.out.println(countSearch);
        }


    }

    static void tinkoff8() {

        Scanner input = new Scanner(System.in);
        int[] numbers = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<String> domens = new ArrayList();
        List<String> requestDomens = new ArrayList();

        for (int i = 0; i < numbers[0]; i++) {
            domens.add(input.nextLine());
        }

        for (int i = 0; i < numbers[1]; i++) {
            requestDomens.add(input.nextLine());
        }

        int countCorrectDomain = 0;

        for (int i = 0; i < requestDomens.size(); i++) {
            for (int j = 0; j < domens.size(); j++) {
                String requestString = requestDomens.get(i);
                String beginRequest = requestString.substring(0, requestString.indexOf(" "));
                String endRequest = requestString.substring(requestString.indexOf(" ") + 1, requestString.length());

                String domainString = domens.get(j);
                String beginDomain = domainString.substring(0, beginRequest.length());
                String endDomain = domainString.substring((domainString.length() - endRequest.length()), domainString.length());

                if (beginRequest.equals(beginDomain) && endRequest.equals(endDomain)) {
                    countCorrectDomain++;
                }

            }
            System.out.println(countCorrectDomain);
            countCorrectDomain = 0;
        }

    }

}
