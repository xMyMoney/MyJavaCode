package file.manager;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class manager {
	JFrame f;
	JButton read,write;
	FileDialog fRead,fWrite;
	JPanel p1;
	JTextArea text;
	JSplitPane sp;
	manager(){
		f=new JFrame("文件管理器");
		f.setSize(600,300);
		f.setLocationRelativeTo(null);
		
		read=new JButton("读文件");
		write=new JButton("写文件");
		
		read.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileRead();
				
			}
		});
		
		write.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileSave();
				
			}
		});
		
		
		p1=new JPanel();
		p1.setBackground(Color.yellow);
		p1.add(read);
		p1.add(write);
		
		text=new JTextArea();
		JScrollPane p2=new JScrollPane(text);
		p2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		p2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//text.setEditable(false);
		
		
		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
		sp.setDividerLocation(80);
		sp.setEnabled(false);
		f.add(sp);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	void fileRead() {
		fRead = new FileDialog(f, "选择文件", FileDialog.LOAD);
		fRead.setVisible(true);
		String fileName = fRead.getFile();
		String filePath = fRead.getDirectory() + fileName;
		File file = new File(filePath);
		try (BufferedReader red = new BufferedReader(new FileReader(file))) {
			String line = null;

			while ((line = red.readLine()) != null) {
				text.append(line + "\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void fileSave() {
		fWrite = new FileDialog(f, "选择文件", FileDialog.SAVE);
		fWrite.setVisible(true);
		String fileName = fWrite.getFile();
		String filePath = fWrite.getDirectory() + fileName;
		File file = new File(filePath);
		try (BufferedWriter fw = new BufferedWriter(new FileWriter(file))) {
			String t= text.getText() + "\n";
			fw.write(t);
			
			// 保存后格式错乱

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public static void main(String[] args) {
		new manager();
	}

}
