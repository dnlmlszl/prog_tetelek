package exercises;

import java.util.Random;
import java.util.Scanner;

public class Battleship {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        int[] tabla = new int[10];
        int hajoKezd = initShip(tabla);
        int lovesek = 0;
        int talalat = 0;
        while (lovesek < 10 && talalat < 3) {
            tablatMutat(tabla);
            int loves = tuzeles(scanner);
            lovesek++;

            if (betalalt(loves, hajoKezd)) {
                System.out.printf("Eltalaltad a hajot a %d pozicional!\n", loves + 1);
                tabla[loves] = 1;
                talalat++;
            } else {
                System.out.println("Nem talalt!");
                tabla[loves] = -1;
            }
        }
        System.out.printf("\nBattleship jatek veget ert! Elsullyesztetted a hajot %d lovesbol.\n", lovesek);
        System.out.printf("Szukseges lovesek szama: %d\n", lovesek);
        tablatMutat(tabla);


    }
    public static int initShip(int[] tabla) {
        int hajoKezd = random.nextInt(tabla.length - 2);
        for (int i = 0; i < 3; i++) {
            tabla[hajoKezd + i] = 0;
        }
        return hajoKezd;
    }

    public static void tablatMutat(int[] tabla) {
        System.out.println("Tabla: ");
        for (int cella: tabla) {
            if (cella == -1) {
                System.out.print("* ");
            } else if (cella == 1) {
                System.out.print("X ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println();
    }

    public static int tuzeles(Scanner scanner) {
        int loves;
        do {
            System.out.print("Add meg a loves poziciojat (1-10): ");
            loves = scanner.nextInt() - 1;
        } while (loves < 0 || loves >= 10);
        return loves;
    }

    public static boolean betalalt(int loves, int hajoKezd) {
        return loves >= hajoKezd && loves < hajoKezd + 3;
    }

}
