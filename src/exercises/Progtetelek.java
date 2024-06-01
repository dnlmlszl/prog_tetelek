package exercises;

import java.util.Arrays;
import java.util.Random;
public class Progtetelek {
    static Random random = new Random();
    private static final int[] numbers = generateArray(8, -999, 999);
    public static void main(String[] args) {
        feladatok();
    }

    private static void feladatok() {

        osszegzesBemutatasa();

        megszamlalasBemutatasa();

        eldontesEgyBemutatasa();

        eldontesMindBemutatasa();

        kivalasztasBemutatasa();

        kivalasztasMaxBemutatasa();

        kivalasztasMinBemutatasa();

        keresesBemutatasa();

        masolasBemutatasa();
    }

    private static void masolasBemutatasa() {
        konzolrair("A másolt tömb: ");
        int[] copy = masolas(numbers);
        konzolrair(Arrays.toString(copy));
    }

    private static void keresesBemutatasa() {
        konzolrair("Az 9-es szám indexe: ");
        int index = kereses(numbers, 9);
        if (index != 0) {
            konzolrair(String.valueOf(index));
        } else {
            konzolrair("Nem található az 9-es szám a tömbben.");
        }
    }

    private static void kivalasztasMinBemutatasa() {
        konzolrair("A tömb legkisebb eleme: ");
        int min = kivalasztasMinimum(numbers);
        konzolrair(String.valueOf(min));
    }

    private static void kivalasztasMaxBemutatasa() {
        konzolrair("A tömb legnagyobb eleme: ");
        int max = kivalasztasMaximum(numbers);
        konzolrair(String.valueOf(max));
    }

    private static void kivalasztasBemutatasa() {
        konzolrair("Az első pozitív szám: ");
        int firstPositive = kivalasztas(numbers);
        konzolrair(String.valueOf(firstPositive));
    }

    private static void eldontesMindBemutatasa() {
        konzolrair("A tömb összes eleme pozitív: ");
        boolean allPositive = eldontesMind(numbers);
        konzolrair(String.valueOf(allPositive));
    }

    private static void eldontesEgyBemutatasa() {
        konzolrair("A tömb tartalmazza a 5-öt: ");
        boolean found = eldontesEgy(numbers, 5);
        konzolrair(String.valueOf(found));
    }

    private static void megszamlalasBemutatasa() {
        int count = megszamlalas(numbers);
        konzolrair("Pozitiv szamok szama: ");
        konzolrair(String.valueOf(count));
    }

    private static void osszegzesBemutatasa() {
        konzolrair("Sorozat osszege: ");
        int sum = osszegzes(numbers);
        konzolrair(String.valueOf(sum));
        konzolrair("Sorozat atlaga: ");
        double atlag = (double) osszegzes(numbers) / megszamlalas(numbers);
        konzolrair(String.valueOf(atlag));
    }

    private static int[] generateArray(int size, int min, int max) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min +1) + min;
        }
        return array;
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

    private static boolean eldontesMind(int[] array) {
        for (int num: array) {
            if (num <= 0) return false;
        }
        return true;
    }

    private static int kivalasztas(int[] array) {
        for (int num: array) {
            if (num > 0) {
                return num;
            }
        }
        return 0;
    }
    private static int kivalasztasMaximum(int[] array) {
        int max = array[0];
        for (int num: array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    private static int kivalasztasMinimum(int[] array) {
        int min = 0;
        for (int num: array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    private static int kereses(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return 0;
    }


    private static int[] masolas(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }
}
