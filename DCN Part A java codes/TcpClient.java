import java.net.*;
import java.io.*;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        try (Socket sock = new Socket("127.0.0.1", 4000);
             BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pwriter = new PrintWriter(sock.getOutputStream(), true);
             BufferedReader socketRead = new BufferedReader(new InputStreamReader(sock.getInputStream()))) {

            System.out.println("Enter the fileName");
            String fName = keyRead.readLine();
            pwriter.println(fName);

            String str;
            while ((str = socketRead.readLine()) != null) {
                System.out.println(str);
            }
        }
    }
}