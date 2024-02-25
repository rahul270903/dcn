import java.net.*;
import java.io.*;

public class TcpServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4000);
        System.out.println("Server is ready for connection");

        try (Socket socket = serverSocket.accept();
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)) {

            String fileName = fileReader.readLine();
            BufferedReader contentReader = new BufferedReader(new FileReader(fileName));

            String str;
            while ((str = contentReader.readLine()) != null) {
                printWriter.println(str);
            }
        }
    }
}   
