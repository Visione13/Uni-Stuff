import java.util.Scanner;

public class Dosenberechnung {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte gebe den Radius ein: ");
        int radius = sc.nextInt();
        System.out.print("Bitte gebe die Höhe ein: ");
        int höhe = sc.nextInt();

        System.out.println("Umfang: " + berechneUmfang(radius));
        System.out.println("Deckelfläche: " + berechneDeckelfläche(radius));
        System.out.println("Mantelfläche: " + berechneMantelfläche(höhe,radius));
        System.out.println("Oberfläche: " + berechneOberfläche(höhe,radius));
        System.out.println("Volumen: " + berechneVolumen(höhe,radius));
    }

    public static double berechneUmfang(int radius){
        return 2*Math.PI*radius;
    }

    public static double berechneDeckelfläche(int radius){
        return Math.PI*(radius*radius);
    }

    public static double berechneMantelfläche(int höhe, int radius){
        return berechneUmfang(radius) * höhe;
    }

    public static double berechneOberfläche(int höhe,int radius){
        return 2*berechneDeckelfläche(radius)+berechneMantelfläche(höhe, radius);
    }

    public static double berechneVolumen(int höhe, int radius){
        return berechneDeckelfläche(radius)*höhe;
    }
}
