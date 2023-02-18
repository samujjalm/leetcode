package algorithms1;

public class Reverse {
    public static void main(String[] args) {
        reverse(54321);
        System.out.println();
        reverse(10011);
        System.out.println();
        reverse(1);

    }
    public static void reverse(int N) {
        int enable_print = N%10;
        while (N > 0) {
            if(enable_print == 0 && N%10 != 0) {
                return;
            } else {
                System.out.print(enable_print);
            }
            N = N/10;
            enable_print = N%10;
        }
    }
}

