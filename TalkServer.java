package Talk;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TalkServer {
public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中......");
		//1.使用DatagramSocket 指定端口 创建接收端;
		DatagramSocket server = new DatagramSocket(5555);
		while(true) {// * 2.准备容器 封装成DatagramPacket包裹;
		byte[] container = new byte[1024*60];
		
		DatagramPacket packet = new DatagramPacket(container,0,container.length);
		// * 3.阻塞式接收包裹receive(DatagramPacket)
		server.receive(packet);
		// * 4.分析数据
		// * byte[] getData()
		 //* 			getLength()
		byte[] datas = packet.getData();
		int len = packet.getLength();
		String data = new String(datas,0,len);
		System.out.println(data);
		if(data.equals("bye")) {
			break;}
		}
		server.close();
	}
		 //* 5.释放资源
		
	
}
