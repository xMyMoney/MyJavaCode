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

public class WordRetrieval {
	JPanel p1 = new JPanel();

	JLabel l1, l2;
	JTextField t1, t2;
	JButton b1, b2;

	public void Retrieval() {
		p1.setSize(500, 370);
		p1.setLayout(null);
		p1.setBackground(Color.BLUE);

		l1 = new JLabel("输入中文:");
		l1.setFont(new Font("Dialog", 1, 20));
		l1.setForeground(Color.YELLOW);
		l1.setSize(270, 100);
		p1.add(l1);

		t1 = new JTextField();
		t1.setSize(100, 30);
		t1.setLocation(90, 60);
		t1.setFont(new Font("Dialog", 1, 20));
		p1.add(t1);

		b1 = new JButton("检索");
		b1.setBounds(280, 100, 70, 30);
		p1.add(b1);

		b2 = new JButton("退出");
		b2.setBounds(360, 100, 70, 30);
		p1.add(b2);

		t2 = new JTextField();
		t2.setBounds(1, 100, 150, 100);
		t2.setFont(new Font("Dialog", 1, 20));
		p1.add(t2);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String ss = new Cheak().cheak1(t1.getText());
					if (ss != null) {

						JOptionPane.showMessageDialog(null, "找到了！", "提示消息", JOptionPane.WARNING_MESSAGE);
						t2.setText(ss);
					} else {
						JOptionPane.showMessageDialog(null, "没有！", "提示消息", JOptionPane.WARNING_MESSAGE);
					}
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
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
