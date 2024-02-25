import java.util.*;

public class CRC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the data");
        int n = sc.nextInt();
        int d[] = new int[n];

        System.out.println("Enter the data bit by bit");
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        System.out.println("Enter the size of the divisor");
        n = sc.nextInt();
        int r[] = new int[n];

        System.out.println("Enter the divisor bit by bit");
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }

        int rem[] = divide(d, r);
        System.out.println("\nThe CRC code generated is");

        for (int i : d) {
            System.out.print(i);
        }

        for (int i = 0; i < rem.length - 1; i++) {
            System.out.print(rem[i]);
        }

        System.out.println();
        int sd[] = new int[d.length + rem.length - 1];

        System.out.println("Enter the data to be sent:");
        for (int i = 0; i < sd.length; i++) {
            sd[i] = sc.nextInt();
        }

        receive(sd, r);
    }

    static int[] divide(int od[], int r[]) {
        int rem[], i;
        int d[] = new int[od.length + r.length];
        
        System.arraycopy(od, 0, d, 0, od.length);
        System.out.println("Message bits after appending divisor length-1");

        for (i = 0; i < d.length - 1; i++) {
            System.out.println(d[i]);
        }

        rem = new int[r.length];
        System.arraycopy(d, 0, rem, 0, r.length);

        for (i = 0; i < od.length; i++) {
            if (rem[0] == 1) {
                for (int j = 1; j < r.length; j++) {
                    rem[j - 1] = exor(rem[j], r[j]);
                }
            } else {
                for (int j = 1; j < r.length; j++) {
                    rem[j - 1] = exor(rem[j], 0);
                }
            }
            rem[r.length - 1] = d[i + r.length];
        }

        return rem;
    }

    static int exor(int a, int b) {
        return a == b ? 0 : 1;
    }

    static void receive(int d[], int r[]) {
        int rem[] = divide(d, r);

        for (int i : rem) {
            if (i != 0) {
                System.out.println("There is an error in the received data");
                return;
            }
        }

        System.out.println("Data was received without any error");
    }
}
