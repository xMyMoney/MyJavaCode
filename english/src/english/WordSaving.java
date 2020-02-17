package english;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordSaving {

	public void wordSaving(String[] word) throws IOException {

		File file = new File("D://Message2.txt");
		String messagesum = "";
		for (int i = 0; i < 2; i++) // 将信息格式化存储
			messagesum +=word[i] + " ";
		if (!file.exists())
			file.createNewFile();
		FileOutputStream out = new FileOutputStream(file, true); // 建立输出对象，true表示追加
		StringBuffer sb = new StringBuffer(); // 创建字符串流
		sb.append(messagesum + "\n"); // 向字符串流中添加信息
		out.write(sb.toString().getBytes("gb2312")); // 将字符串流中的信息写入文本
		out.close();

	}
}
