import java.util.Scanner;

public class Schaltjahr {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Geben Sie eine Jahreszahl ein: ");
        int eingabe = sc.nextInt();
        System.out.println(eingabe%4==0 && eingabe%100 != 0 ||eingabe%400== 0);
    }
}
