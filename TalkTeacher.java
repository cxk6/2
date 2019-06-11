package Talk;

public class TalkTeacher {
public static void main(String[] args) {
	new Thread(new TalkReceive(11111,"学生")).start();//接收;
	
	new Thread(new TalkSend(11112,"localhost",8888)).start();//发送;
}
}
