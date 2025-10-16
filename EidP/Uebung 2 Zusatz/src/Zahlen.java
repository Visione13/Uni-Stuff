import java.util.Scanner;

public class Zahlen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Geben Sie eine ganze Zahl ein:");
        int x = sc.nextInt();

        if(x%2==0){
            System.out.println("Die Zahl: " + x + " ist grade");
        }else{
            System.out.println("Die Zahl: " + x + " ist ungrade");
        }

        if(x%3==0){
            System.out.println("Die Zahl: " + x + " ist durch 3 teilbar");
        }else{
            System.out.println("Die Zahl: " + x + " ist nicht durch 3 teilbar");
        }

        if(x<0){
            System.out.println("Die Zahl: " + x + " ist negativ");
        }else{
            System.out.println("Die Zahl: " + x + " ist positiv");
        }

        if(istZweierpotenz(x)){
            System.out.println("Die Zahl: " + x + " ist eine Zweierpotenz");
        }else{
            System.out.println("Die Zahl: " + x + " ist keine Zweierpotenz");
        }
    }

    public static boolean istZweierpotenz(int x){
        boolean done = false;
        boolean ausgabe = false;
        int zahl = x;

        while(!done){
            if(zahl%2==1){
                ausgabe = false;
                done = true;
            }
            if(zahl==1){
                ausgabe = true;
                done = true;
            }
            if(zahl%2==0){
                zahl=zahl/2;
            }
        }
        return ausgabe;
    }
}