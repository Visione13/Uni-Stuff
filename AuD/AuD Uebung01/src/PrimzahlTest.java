public class PrimzahlTest {
    public static void main(String[] args) {
        SiebDesEratosthenes sde = new SiebDesEratosthenes(25);
        int[] test = sde.berechnePrimzahlen();
        int x = 0;
        while(test.length > x) {
            if(test[x] != 0){
                System.out.print(test[x] + " ");
            }
            x++;
        }
    }
}