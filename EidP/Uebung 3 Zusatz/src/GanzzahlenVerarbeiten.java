import java.util.Scanner;

public class GanzzahlenVerarbeiten {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Eingabe Zahl 1: ");
        long i1 = sc.nextInt();
        System.out.print("Eingabe Zahl 2: ");
        long i2 = sc.nextInt();

        long and = i1 & i2;
        long or = i1 | i2;
        long exOr = i1 ^ i2;

        System.out.println();
        System.out.println("Ergebnisse der bitweisen Operationen: ");
        System.out.println("UND (&): " + Long.toBinaryString(and) + " (" + and + ")");
        System.out.println("ODER (|): " + Long.toBinaryString(or) + " (" + or + ")");
        System.out.println("EXOR (^): " + Long.toBinaryString(exOr) + " (" + exOr + ")");

        long i1Left = i1<<3;
        long i1Right = i1>>3;
        long i2Left = i2<<3;
        long i2Right = i2>>3;

        System.out.println();
        System.out.println("Bitverschiebungsergebnisse: ");
        System.out.println("Erste Zahl << 3: " + Long.toBinaryString(i1Left) + " (" + i1Left + ")");
        System.out.println("Erste Zahl >> 3: " + Long.toBinaryString(i1Right) + " (" + i1Right + ")");
        System.out.println("Erste Zahl << 3: " + Long.toBinaryString(i2Left) + " (" + i2Left + ")");
        System.out.println("Erste Zahl << 3: " + Long.toBinaryString(i2Right) + " (" + i2Right + ")");
    }
}
