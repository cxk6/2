package Talk;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TalkClient {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中.......");
		//1.使用DatagramSocket 指定端口 创建接收端;
		DatagramSocket client = new DatagramSocket(9999);
		// * 2.准备容器 封装成DatagramPacket包裹;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		String data = reader.readLine();
		byte[] datas = data.getBytes();
		// * 3.阻塞式接收包裹receive(DatagramPacket)
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
				new InetSocketAddress("localhost",5555));
		//发送包裹send(DatagramPacket);
		client.send(packet);
		if(datas.equals("bye")){
				break;
		}	
		}// * 5.释放资源
		client.close();
	}
}
