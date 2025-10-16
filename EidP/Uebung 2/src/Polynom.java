import java.util.Scanner;

public class Polynom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int x = sc.nextInt();
        int mon1 = 5 * x;
        int mon2 = mon1 + 3 * x * x;
        mon1 = mon2 + x * x * x;
        System.out.println(mon1);
    }
}