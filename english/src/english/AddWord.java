package english;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddWord {
	JPanel p1 = new JPanel();

	JLabel l1, l2;
	JTextField t1, t2;
	JButton b1, b2;

	public void addWord() {
		p1.setSize(500, 370);
		p1.setLayout(null);
		p1.setBackground(Color.BLUE);

		l1 = new JLabel("English:");
		l1.setFont(new Font("Dialog", 1, 20));
		l1.setForeground(Color.YELLOW);
		l1.setSize(250, 100);
		p1.add(l1);

		t1 = new JTextField();
		t1.setSize(120, 40);
		t1.setLocation(80, 40);
		t1.setFont(new Font("Dialog", 1, 20));
		p1.add(t1);

		l2 = new JLabel("中文:");
		l2.setFont(new Font("Dialog", 1, 20));
		l2.setForeground(Color.YELLOW);
		l2.setSize(250, 100);
		l2.setLocation(30, 100);
		p1.add(l2);

		t2 = new JTextField();
		t2.setSize(120, 40);
		t2.setLocation(80, 145);
		t2.setFont(new Font("Dialog", 1, 20));
		p1.add(t2);

		b1 = new JButton("添加");
		b1.setBounds(220, 210, 70, 50);
		p1.add(b1);

		b2 = new JButton("退出");
		b2.setBounds(320, 210, 70, 50);
		p1.add(b2);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String English = t1.getText();
				String Chinese = t2.getText();
				String[] words = new String[2];
				words[0] = English;
				words[1] = Chinese;
				try {
					new WordSaving().wordSaving(words);
					JOptionPane.showMessageDialog(null, "添加成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
					t1.setText(null);
					t2.setText(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p1.setVisible(false);
			}
		});

		p1.setVisible(true);
	}

}
