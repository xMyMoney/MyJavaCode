package sensitive.words;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Show {
	JFrame f;
	JMenuBar b;
	JPanel p1, p2, p3, p4;
	JTabbedPane tab;
	JTextArea text,t2;
	ArrayList<String> list;
	public void showOpend() {
		f = new JFrame("敏感词汇分析");
		f.setSize(400, 470);
		f.setLocationRelativeTo(null); //窗口居中于屏幕
		f.setResizable(false);//窗口大小不可变

		// 面板展示
		tab = new JTabbedPane();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		tab.add(p1);
		tab.add(p2);
		tab.add(p3);
		tab.add(p4);
		tab.setTitleAt(0, "打开");
		tab.setTitleAt(1, "分析");
		tab.setTitleAt(2, "浏览");
		tab.setTitleAt(3, "查询");
		f.add(tab);

		// 添加鼠标事件
		tab.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // 响应鼠标点击事件
				for (int i = 0; i < tab.getTabCount(); i++) {
					Rectangle rect = tab.getBoundsAt(i); // 拿到标签的边界
					if (rect.contains(e.getX(), e.getY())) { // 判断是否点在边界内
						switch (i) {
						case 0:
							fileRead();
							break;
						case 1:
							showAnalysis();
							break;
						case 2:
							
							break;
						case 3:
							
							break;
						}
					}
				}
			}
		});
		
		//面板一
		text=new JTextArea();
		text.setEditable(false);
		JScrollPane jsp=new JScrollPane(text);  //添加滾動條
		jsp.setPreferredSize(new Dimension(380, 400));
		jsp.setSize(50, 100);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p1.add(jsp);
		
		//面板二
		t2=new JTextArea();
		t2.setEditable(false);
		t2.setFont(new Font(null, 0, 22));
		t2.setForeground(Color.BLUE);
		JScrollPane jp=new JScrollPane(t2);  //添加滾動條
		jp.setPreferredSize(new Dimension(380, 400));
		jp.setSize(50, 100);
		jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p2.add(jp);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	void fileRead() {
		FileDialog fRead;
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
	
	void showAnalysis() {
		list=new ArrayList<>();
		String str=text.getText();
		File file=new File("sentive.txt");
		try(BufferedReader fr=new BufferedReader(new FileReader(file))) {
			String line=null;
			while((line=fr.readLine())!=null) {
				int count=0;
				count=(str.length()-str.replace(line,"").length())/2;
				if(count!=0) {
					list.add(line+"\t\t"+count+"次");
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		for(String st:list) {
			t2.append(st+"\n");
		}
	}
}
