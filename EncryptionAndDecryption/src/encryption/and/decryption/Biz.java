package encryption.and.decryption;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Biz {
	FileDialog dialog;
	File decodingFile, decodedFile;
	String fileName, filePath;

	// �ļ���
	public ArrayList<String> FileOpend(JFrame f) {
		dialog = new FileDialog(f, "ѡ���ļ�", FileDialog.LOAD);
		dialog.setVisible(true);
		fileName = dialog.getFile();
		filePath = dialog.getDirectory() + fileName;
		decodingFile = new File(filePath);
		ArrayList<String> list = new ArrayList<>();
		try (BufferedReader red = new BufferedReader(new FileReader(decodingFile))) {
			String line = null;
			while ((line = red.readLine()) != null) {
				list.add(line + "\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	// �ļ�����
	public boolean FileSave(JFrame f, String str) {
		dialog = new FileDialog(f, "�ļ�����", FileDialog.SAVE);
		dialog.setVisible(true);
		fileName = dialog.getFile();
		filePath = dialog.getDirectory() + fileName;
		decodedFile = new File(filePath);
		try (BufferedWriter fw = new BufferedWriter(new FileWriter(decodedFile))) {
			fw.write(str);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
	
	//�ļ��ӽ���
	public ArrayList<String> Fileencryption(String text) {
		ArrayList<String> list=new ArrayList<>();
		char a[]=text.toCharArray();
		char secret=' ';
		for(int i=0;i<a.length;i++) {
			char c=(char)(secret^a[i]);
			list.add(c+"");
		}
		return list;
	}

}
