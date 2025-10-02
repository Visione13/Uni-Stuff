public class Main {
    public static void main (String[] args){
        int x = 7;
        if ((x / 16) >= 1) {
            System.out.print("1");
            x = x - 16;
        } else {
            System.out.print("0");
        }
        if ((x / 8) >= 1) {
            System.out.print("1");
            x = x - 8;
        } else {
            System.out.print("0");
        }
        if ((x / 4) >= 1) {
            System.out.print("1");
            x = x - 4;
        } else {
            System.out.print("0");
        }
        if ((x / 2) >= 1) {
            System.out.print("1");
            x = x - 2;
        } else {
            System.out.print("0");
        }
        if ((x / 1) >= 1) {
            System.out.print("1");
            x = x - 1;
        } else {
            System.out.print("0");
        }
    }
}