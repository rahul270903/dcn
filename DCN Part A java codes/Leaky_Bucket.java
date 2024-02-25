import java.util.*;

public class Leaky_Bucket {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter bucket size, output rate, and number of seconds: ");
        int b_size = in.nextInt(), o_rate = in.nextInt(), nsec = in.nextInt();
        
        Random rand = new Random();
        int[] packet = new int[nsec];
        
        for (int i = 0; i < nsec; i++)
            packet[i] = rand.nextInt(1000);

        System.out.println("Second\tPacket Received\tPacket Sent\tPacket Left\tPacket Dropped\n" +
                           "_____________________________________________________________");

        for (int i = 0, p_remain = 0, drop; i < nsec; i++) {
            p_remain += packet[i];
            drop = Math.max(0, p_remain - b_size);
            p_remain = Math.min(b_size, p_remain);
            int mini = Math.min(p_remain, o_rate);

            System.out.printf("%d\t%d\t\t%d\t\t%d\t\t%d\n", i + 1, packet[i], mini, p_remain -= mini, drop);
        }

        for (int p_remain = b_size, drop; p_remain > 0; ) {
            drop = Math.max(0, p_remain - b_size);
            p_remain = Math.min(b_size, p_remain);
            int mini = Math.min(p_remain, o_rate);

            System.out.printf("\t\t\t%d\t\t%d\t\t%d\t\t%d\n", p_remain -= mini, mini, drop);
        }
    }
}
