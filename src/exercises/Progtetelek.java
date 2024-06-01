package exercises;

public class Progtetelek {
    private static int[] numbers = new int[6];
    public static void main(String[] args) {
        feladatok();

    }

    private static void feladatok() {
        numbers = new int[]{-3, 5, 8, 9, 11, -7};

        int sum = osszegzes(numbers);
        konzolrair("Osszeg:" + sum);

        int count = megszamlalas(numbers);
        konzolrair("Pozitiv szamok szama: " + count);

        boolean found = eldontesEgy(numbers, 5);
        konzolrair("A tömb tartalmazza a 5-öt: " + found);
    }

    private static void konzolrair(String text) {
        System.out.println(text);
    }

    private static int osszegzes(int[] array) {
        int sum = 0;

        for (int num: array) {
            sum += num;
        }
        return sum;
    }

    private static int megszamlalas(int[] array) {
        int count = 0;
        for (int num: array) {
            if (num > 0) count++;
        }
        return count;
    }

    private static boolean eldontesEgy(int[] array, int value) {
        for (int num: array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    private static boolean eldontesMind() {
        return false;
    }

    private static int kivalasztas() {
        return 0;
    }
    private static int kivalasztasMaximum() {
        return 0;
    }
    private static int kivalasztasMinimum() {
        return 0;
    }

    private static int kereses() {
        return 0;
    }


    private static int[] masolas(int[] array) {
        return array;
    }
}
