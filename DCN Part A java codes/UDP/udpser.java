package UDP;
import java.io.*;
import java.net.*;
class udpser{
public static void main(String[]args) throws Exception{
	DatagramSocket serversocket = new DatagramSocket(9876);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	byte[] recieveData = new byte[1024];
	byte[] sendData = new byte[1024];
	DatagramPacket recievePacket = new DatagramPacket(recieveData,recieveData.length);
	serversocket.receive(recievePacket);
	String sentence=new String(recievePacket.getData());
	System.out.println("RECIEVED:"+sentence);
	InetAddress IPaddress = recievePacket.getAddress();
	int port=recievePacket.getPort();
	System.out.println("ENTER THE MESSAGE:");
	String data=br.readLine();
	sendData=data.getBytes();
	DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPaddress,port);
	serversocket.send(sendPacket);
	serversocket.close();
	}
}