package UDP;
import java.io.*;
import java.net.*;
class udpcl{
	public static void main(String[]args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientsocket=new DatagramSocket();
		InetAddress IPaddress=InetAddress.getByName("localhost");
		byte[] sendData=new byte[1024];
		byte[] recieveData=new byte[1024];
		String sentence="HELLO SERVER";
		sendData=sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPaddress,9876);
		clientsocket.send(sendPacket);
		DatagramPacket recievePacket=new DatagramPacket(recieveData,recieveData.length);
		clientsocket.receive(recievePacket);
		String modifiedsentence=new String(recievePacket.getData());
		System.out.println("FROM SERVER: "+modifiedsentence);
		clientsocket.close();
	}
}