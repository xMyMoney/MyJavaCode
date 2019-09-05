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

	// ���ڳ�ʼ��
	View() {
		f = new JFrame("�ӽ���");
		f.setSize(600, 500);
		f.setLocationRelativeTo(null);

		bar = new JMenuBar();
		menu = new JMenu("�ļ�");
		mt1 = new JMenuItem("��");
		mt2 = new JMenuItem("����");
		mt3 = new JMenuItem("����");
		mt4 = new JMenuItem("����");
		menu.add(mt1);
		menu.add(mt2);
		menu.add(mt3);
		menu.add(mt4);
		bar.add(menu);

		f.add(bar, BorderLayout.NORTH);

		// ������
		Action();

		// �ı���
		text = new JTextArea();
		text.setEditable(false);
		jsp = new JScrollPane(text);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		f.add(jsp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	// ע�������
	void Action() {
		// ���ļ�
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

		// �����ļ�
		mt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = text.getText();
				if (biz.FileSave(f, str)) {
					JOptionPane.showMessageDialog(null, "����ɹ���");
					text.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "�޷��ɹ�");
				}
			}
		});

		// �ļ�����
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

		// �ļ�����
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
