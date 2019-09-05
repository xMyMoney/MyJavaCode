package encryption.and.decryption;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View {
	JFrame f;
	JMenuBar bar;
	JMenu menu;
	JMenuItem mt1, mt2, mt3, mt4;
	JTextArea text;
	JScrollPane jsp;
	Biz biz = new Biz();

	// 窗口初始化
	View() {
		f = new JFrame("加解密");
		f.setSize(600, 500);
		f.setLocationRelativeTo(null);

		bar = new JMenuBar();
		menu = new JMenu("文件");
		mt1 = new JMenuItem("打开");
		mt2 = new JMenuItem("保存");
		mt3 = new JMenuItem("加密");
		mt4 = new JMenuItem("解密");
		menu.add(mt1);
		menu.add(mt2);
		menu.add(mt3);
		menu.add(mt4);
		bar.add(menu);

		f.add(bar, BorderLayout.NORTH);

		// 监听器
		Action();

		// 文本域
		text = new JTextArea();
		text.setEditable(false);
		jsp = new JScrollPane(text);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		f.add(jsp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	// 注册监听器
	void Action() {
		// 打开文件
		mt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("");
				ArrayList<String> list = biz.FileOpend(f);
				for (String str : list) {
					text.append(str);
				}
			}
		});

		// 保存文件
		mt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = text.getText();
				if (biz.FileSave(f, str)) {
					JOptionPane.showMessageDialog(null, "保存成功！");
					text.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "无法成功");
				}
			}
		});

		// 文件加密
		mt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> list = biz.Fileencryption(text.getText());
				text.setText("");
				for (String str : list) {
					text.append(str);
				}
			}
		});

		// 文件解密
		mt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> list = biz.Fileencryption(text.getText());
				text.setText("");
				for (String str : list) {
					text.append(str);
				}
			}
		});
	}

}
