public class SiebDesEratosthenes {

    private int[] prim;

    public SiebDesEratosthenes(int n){
        this.prim = new int[n];

        int x = 1;
        while(x<prim.length+1){
            hinschreiben(x);
            x++;
        }
    }

    private void hinschreiben(int Zahl){
        prim[Zahl-1] = Zahl;
    }

    private void durchstreichen(int Zahl){
        prim[Zahl-1] = 0;
    }

    private boolean isDurchgestrichen(int Zahl){
        if(Zahl - 1 == 0){
            return true;
        }else {
            return false;
        }
    }

    private void durchstreichenVielfache(int Zahl){
        int x = 2;
        while(Zahl*x<=prim.length){
            if(!isDurchgestrichen(Zahl * x)){
                durchstreichen(Zahl * x);
            }
            x++;
        }
    }

    public int[] berechnePrimzahlen(){
        durchstreichen(1);
        durchstreichenVielfache(2);
        int x = 2;
        while(prim.length > x){
            durchstreichenVielfache(x);
            x++;
        }
        return prim;
    }
}