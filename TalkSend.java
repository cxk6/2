package Talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{
private DatagramSocket client;
private BufferedReader reader;
private  String toIp;
private  int toPort;
public TalkSend(int port,String toIp,int toPort) {
	this.toIp= toIp;
	this.toPort = toPort;
	try {
		client= new DatagramSocket(port);
		reader = new BufferedReader(new InputStreamReader(System.in));
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	@Override
	public void run() {
		while(true) {
			String data;
			try {
				data = reader.readLine();
				byte[] datas = data.getBytes();
				// * 3.阻塞式接收包裹receive(DatagramPacket)
				DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
						new InetSocketAddress(this.toIp,this.toPort));
				//发送包裹send(DatagramPacket);
				client.send(packet);
				if(datas.equals("bye")){
						break;
				}	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}// * 5.释放资源
			client.close();
		}
	}


