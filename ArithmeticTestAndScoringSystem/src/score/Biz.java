package score;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class Biz {
	File fTopic=new File("fTopic.txt"), fScore=new File("score.txt");
	int x1;
	int x2;

	// �����
	public void Ran() {
		Random random = new Random();
		x1 = random.nextInt(100);
		x2 = random.nextInt(100);
	}

	// �жϴ�
	public boolean TF(String answer) {
		int x = Integer.parseInt(answer); // �ַ���ת��Ϊ����
		if ((x1 + x2) == x) {
			return true;
		} else {
			return false;
		}
	}

	// ��Ŀ��¼
	public void topicSave(ArrayList<String> record) {
		try (BufferedWriter fw = new BufferedWriter(new FileWriter(fTopic))) {
			for (String str : record) {
				fw.write(str + "\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ������¼
	public void scoreSave(int score) {
		try (BufferedWriter fw = new BufferedWriter(new FileWriter(fScore,true))) {
			String str = score + "";
			fw.write(str + "\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ������ѯ��ʾ
	public ArrayList<String> scoreRead() {
		ArrayList<String> ss=new ArrayList<>();
		try(BufferedReader fr=new BufferedReader(new FileReader(fScore))) {
			String line=null;
			while((line=fr.readLine())!=null) {
				ss.add(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ss;
	}

}
