package english;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Cheak {

	public String cheak1(String ss) throws FileNotFoundException, IOException {
		File f = new File("D:\\Message2.txt");
		// 创建文件字符流
		// 缓存流必须建立在一个存在的流的基础上
		try (FileReader f1 = new FileReader(f); BufferedReader f2 = new BufferedReader(f1);) {
			String line;
			int k = 0;
			boolean ff = true;
			while (ff)

			{
				line = f2.readLine();
				String s = line.replaceAll("[^\\u4e00-\\u9fa5]", "");
				if (s.equals(ss)) {
					k++;
					return line;
				}
			}
			if (k != 0)
				ff = false;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	String line, s;
	ArrayList<String> list = new ArrayList<String>();

	public String cheak2() {

		File f2 = new File("D://Message2.txt");

		try (FileReader fr = new FileReader(f2); BufferedReader fb = new BufferedReader(fr)) {

			while (true) {
				line = fb.readLine();
				list.add(line);

				if (line == null)
					break;

			}
			int n = list.size() - 1;
			Random r = new Random();
			int i = r.nextInt(n);
			s = list.get(i);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return s;

	}

}
