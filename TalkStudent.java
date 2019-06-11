package Talk;

public class TalkStudent {
public static void main(String[] args) {
	new Thread(new TalkSend(7777,"localhost",11111)).start();//发送;
	
	new Thread(new TalkReceive(8888,"老师")).start();//接收;
}
}
