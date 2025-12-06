import java.util.Scanner;

public class BonuspunkteMathe4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int vorrechnen = 0;
        int bonustest1 = 0;
        int bonustest2 = 0;

        System.out.println("Wie viele Aufgaben haben Sie vorgerechnet?");
        vorrechnen = sc.nextInt();
        System.out.println("Wie viele Punkte haben Sie beim 1. Bonustest erreicht?");
        bonustest1 = sc.nextInt();
        System.out.println("Wie viele Punkte haben Sie beim 2. Bonustest erreicht?");
        bonustest2 = sc.nextInt();

        System.out.println("In der Klausur werden Ihnen " + getBonuspunkteGesamt(vorrechnen,bonustest1,bonustest2) + " Bonuspunkte angerechnet.");
    }

    public static int getBonuspunkteGesamt(int vorrechnen, int bonustest1, int bonustest2){
        return vorrechnen + getBonuspunkteTest(bonustest1) + getBonuspunkteTest(bonustest2);
    }

    public static int getBonuspunkteTest(int bonustest){
        return (int)(bonustest/10.0+0.5);
    }
}
