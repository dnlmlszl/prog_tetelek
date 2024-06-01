package exercises;

public class exercise1 {
    public static void main(String[] args) {
        feladatok();

    }

    private static void feladatok() {
        int sum = osszegzes();
        konzolrair("Osszeg:" + sum);
    }

    private static void konzolrair(String text) {
        System.out.println(text);
    }

    private static int osszegzes() {
        int[] numbers = {-3, 5, 8, 9, 11, 7};
        int sum = 0;

        for (int num: numbers) {
            sum += num;
        }
        return sum;
    }

    private static int megszamlalas() {
        return 0;
    }

    private static boolean eldontesEgy() {
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
