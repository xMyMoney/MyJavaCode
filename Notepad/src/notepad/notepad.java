package notepad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class notepad {
	static final int WIDTH = 500;
	static final int HEIGHT = 600;
	static boolean flag = false;
	JFrame f;
	JMenuBar bar;
	JMenu menu1, menu2, menu3, menu4;
	JMenuItem[] item;
	JPanel p1;
	JTextArea write;
	FileDialog dialog;

	void view() {
		f = new JFrame("���±�");
		f.setSize(WIDTH, HEIGHT);
		f.setLocationRelativeTo(null); // ������ʾ

		/* �˵����� */
		bar = new JMenuBar();

		JMenuItem[] item = new JMenuItem[10];
		menu1 = new JMenu("�ļ�"); // ��Ӳ˵�
		item[0] = new JMenuItem("�½�"); // ����Ӳ˵�
		item[1] = new JMenuItem("��");
		item[2] = new JMenuItem("����");
		item[3] = new JMenuItem("����");
		item[4] = new JMenuItem("ճ��");
		for (int i = 0; i < 5; i++) {
			menu1.add(item[i]);
		}
		bar.add(menu1);

		menu2 = new JMenu("����");

		menu3 = new JMenu("��С");
		item[5] = new JMenuItem("����");
		item[6] = new JMenuItem("�ĺ�");
		menu3.add(item[5]);
		menu3.add(item[6]);

		menu4 = new JMenu("��ɫ");
		item[7] = new JMenuItem("��ɫ");
		item[8] = new JMenuItem("��ɫ");
		item[9] = new JMenuItem("��ɫ");
		menu4.add(item[7]);
		menu4.add(item[8]);
		menu4.add(item[9]);
		menu2.add(menu3);
		menu2.add(menu4);

		bar.add(menu2);

		p1 = new JPanel();
		p1.setLayout(new GridLayout()); // ���񲼾�
		p1.add(bar);
		f.add(p1, BorderLayout.NORTH);

		/* �ı����� */

		write = new JTextArea();
		write.setSelectedTextColor(Color.BLUE);
		JScrollPane scroller = new JScrollPane(write);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		f.add(scroller);

		write.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				flag = true;

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		item[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					request();
				} else {
					write.setText("");
				}

			}
		});

		item[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					request();
				} else {
					fileRead();

				}

			}
		});

		item[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (write.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�ĵ�Ϊ�գ�", "����", JOptionPane.WARNING_MESSAGE);
				} else {
					fileSave();
				}
			}
		});

		item[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				write.copy();

			}
		});

		item[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				write.paste();

			}
		});

		/* Ϊ�ı���Сע������¼� */

		item[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				write.setFont(new Font(null, 0, 22));

			}
		});

		item[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				write.setFont(new Font(null, 0, 14));

			}
		});

		/* Ϊ�ı���ɫע������¼� */
		item[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				write.setForeground(Color.GREEN);

			}
		});

		item[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				write.setForeground(Color.BLUE);

			}
		});

		item[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				write.setForeground(Color.BLACK);

			}
		});

		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {

				if (write.getText().equals("")) {
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else if (flag) {
					request();
				}
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});

	}

	void request() {
		int option = JOptionPane.showConfirmDialog(f, "�ĵ������仯�Ƿ񱣴棿");
		if (JOptionPane.OK_OPTION == option) {
			fileSave();
		}
		if (JOptionPane.NO_OPTION == option) {
			write.setText("");
		}
	}

	void fileRead() {
		dialog = new FileDialog(f, "ѡ���ļ�", FileDialog.LOAD);
		dialog.setVisible(true);
		String fileName = dialog.getFile();
		String filePath = dialog.getDirectory() + fileName;
		File file = new File(filePath);
		try (BufferedReader red = new BufferedReader(new FileReader(file))) {
			String line = null;

			while ((line = red.readLine()) != null) {
				write.append(line + "\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void fileSave() {
		dialog = new FileDialog(f, "ѡ���ļ�", FileDialog.SAVE);
		dialog.setVisible(true);
		String fileName = dialog.getFile();
		String filePath = dialog.getDirectory() + fileName;
		File file = new File(filePath);
		try (BufferedWriter fw = new BufferedWriter(new FileWriter(file))) {
			String text = write.getText() + "\n";
			fw.write(text);

			// System.out.println(write.getText());

			// ������ʽ����

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		new notepad().view();
	}

}
