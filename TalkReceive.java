package Talk;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
	private DatagramSocket server;
	private int port;
	private String from;
	public TalkReceive(int port,String from) {
		this.from = from;
		try {
			
			server= new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	@Override
	public void run() {
		while(true) {// * 2.准备容器 封装成DatagramPacket包裹;
			byte[] container = new byte[1024*60];
			
			DatagramPacket packet = new DatagramPacket(container,0,container.length);
			// * 3.阻塞式接收包裹receive(DatagramPacket)
			try {
				server.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// * 4.分析数据
			// * byte[] getData()
			 //* 			getLength()
			byte[] datas = packet.getData();
			int len = packet.getLength();
			String data = new String(datas,0,len);
			System.out.println(from+":"+data);
			if(data.equals("bye")) {
				break;}
			}
			server.close();
		
	}

}
