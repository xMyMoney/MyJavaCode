package english;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordSaving {

	public void wordSaving(String[] word) throws IOException {

		File file = new File("D://Message2.txt");
		String messagesum = "";
		for (int i = 0; i < 2; i++) // ����Ϣ��ʽ���洢
			messagesum +=word[i] + " ";
		if (!file.exists())
			file.createNewFile();
		FileOutputStream out = new FileOutputStream(file, true); // �����������true��ʾ׷��
		StringBuffer sb = new StringBuffer(); // �����ַ�����
		sb.append(messagesum + "\n"); // ���ַ������������Ϣ
		out.write(sb.toString().getBytes("gb2312")); // ���ַ������е���Ϣд���ı�
		out.close();

	}
}
