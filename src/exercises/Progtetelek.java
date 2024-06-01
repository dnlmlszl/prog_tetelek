package exercises;

import java.util.Arrays;

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

        boolean allPositive = eldontesMind(numbers);
        konzolrair("A tömb összes eleme pozitív: " + allPositive);

        int firstPositive = kivalasztas(numbers);
        konzolrair("Az első pozitív szám: " + firstPositive);

        int max = kivalasztasMaximum(numbers);
        konzolrair("A tömb legnagyobb eleme: " + max);

        int min = kivalasztasMinimum(numbers);
        konzolrair("A tömb legkisebb eleme: " + min);

        int index = kereses(numbers, 9);
        konzolrair("Az 9-es szám indexe: " + index);

        int[] copy = masolas(numbers);
        konzolrair("A másolt tömb: " + Arrays.toString(copy));
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
            if (num > 0) {return num;}
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
