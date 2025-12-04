public class AusgabeTest {
    public static void main(String[] args){
        System.out.println("4*5"); //ist ein String
        System.out.println("Dies ist" + "ein Text"); // + fügt dinge an
        System.out.println("Dies ist ein \nText" ); // "\n" ist ein zeilenumbruch

        System.out.println("\u0065"); //"\u0065" ist der unicode für "e"
        System.out.println("\""); //"\"" mach das " nutzbar als zeichen

        System.out.println(2147483647); //ist halt ne Zahl
        System.out.println(2147483647+1); //ist halt ne Zahl aber plus 1. Hier sogar mit stackOverflow

        System.out.println(0xFF); //"0xFF" ist Hexa für 255
        System.out.println(0xFFFFFF);//"0xFFFFFF" ist Hexa für 16777215

        System.out.println("Zahl " + 0.12345678901234567890); //double
        System.out.println("Zahl " + 0.12345678901234567890f); //float
        System.out.println("Summe " + (5.6 + 5.8) ); //ausgabe mit float rechnung
        System.out.println("Summe " + (12345678.0f + 0.1f) );//ausgabe mit float rechnung overfloooow
        System.out.println("Differenz " + (0.123456789f - 0.123456788f) );//ausgabe mit float rechnung...aber minus (float checkt den unterschied nicht)
        System.out.println("Summe " + ((12345678.0f + 0.1f) + 0.41f) );//ausgabe aber mit doppel rechnung
        System.out.println("Summe " + (12345678.0f + (0.1f + 0.41f)) );//daring aren't we?
    }
}
