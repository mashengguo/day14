package cn.itcast.Excise.test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("127.0.0.1", 8888);
		OutputStream os = s.getOutputStream();
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("������Ҫ�ϴ�����Ϣ��");
			String line = sc.nextLine();

			// �ͻ����������
			os.write(line.getBytes());
		}

//		os.close();
//		s.close();

	}
}
