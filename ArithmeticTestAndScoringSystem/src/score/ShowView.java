package score;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ShowView {
	JFrame f;
	JLabel l1, l2, l3, l4;
	JButton b1, b2, b3, b4, b5;
	JPanel p1, p2, p3;
	JTextField t1, t2, t3;

	Biz biz = new Biz();
	static int count = 0;
	int score=0;
	public void login() {
		f = new JFrame();
		f.setSize(350, 200);
		f.setLocationRelativeTo(null);

		l1 = new JLabel("算术运算测试与评分系统", JLabel.CENTER);
		l1.setFont(new Font(null, 0, 20));
		l1.setForeground(Color.BLUE);
		f.add(l1, BorderLayout.CENTER);

		b1 = new JButton("点击登陆");
		f.add(b1, BorderLayout.SOUTH);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				ShowTopic();
			}
		});

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void ShowTopic() {
		f = new JFrame("算术运算测试与评分系统");
		f.setSize(400, 200);
		f.setLocationRelativeTo(null);

		p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		b1 = new JButton("开始");

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				biz.Ran();
				t1.setText(Integer.toString(biz.x1));
				t2.setText(Integer.toString(biz.x2));
				b1.setEnabled(false);
				count++;
			}
		});

		b2 = new JButton("继续");
		b2.setPreferredSize(new Dimension(50, 10));
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				biz.Ran();
				t1.setText(Integer.toString(biz.x1));
				t2.setText(Integer.toString(biz.x2));
				count++;
				t3.setText("");

			}
		});

		b3 = new JButton("退出");
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		b5 = new JButton("查询");
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ShowScore();

			}
		});

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b5);
		f.add(p1, BorderLayout.WEST);

		p2 = new JPanel();
		p2.setLayout(new GridLayout(2, 3));
		t1 = new JTextField("");
		t1.setHorizontalAlignment(JTextField.CENTER);
		t1.setEditable(false);
		t1.setBorder(null);
		t1.setFont(new Font(null, 0, 40));
		t1.setPreferredSize(new Dimension(50, 50));
		t2 = new JTextField("");
		t2.setHorizontalAlignment(JTextField.CENTER);
		t2.setEditable(false);
		t2.setBorder(null);
		t2.setFont(new Font(null, 0, 40));
		t2.setPreferredSize(new Dimension(50, 50));
		t3 = new JTextField("");
		t3.setHorizontalAlignment(JTextField.CENTER);
		t3.setFont(new Font(null, 0, 40));
		t3.setPreferredSize(new Dimension(50, 50));
		l1 = new JLabel("+", JLabel.CENTER);
		l1.setFont(new Font(null, 0, 40));

		b4 = new JButton("确认");

		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (biz.TF(t3.getText())) {
					score++;
					l3.setText("√");
					l4.setText(score + "");
				} else {
					l3.setText("×");
				}
				if (count == 10) {
					Ask();
				}

			}
		});

		l3 = new JLabel("", JLabel.CENTER);
		l3.setFont(new Font(null, 0, 40));
		l3.setForeground(Color.RED);

		p2.add(t1);
		p2.add(l1);
		p2.add(t2);
		p2.add(t3);
		p2.add(b4);
		p2.add(l3);
		f.add(p2, BorderLayout.CENTER);

		p3 = new JPanel();
		p3.setLayout(new GridLayout(2, 1));
		l2 = new JLabel("记分板");
		l4 = new JLabel("" + JLabel.CENTER);
		l4.setForeground(Color.BLUE);
		l4.setFont(new Font(null, 0, 40));
		l4.setBorder(null);
		p3.add(l2);
		p3.add(l4);

		f.add(p3, BorderLayout.EAST);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void Ask() {
		biz.scoreSave(score);
		JOptionPane.showMessageDialog(null, "本次得分:" + score, "恭喜", JOptionPane.PLAIN_MESSAGE);
		int op = JOptionPane.showConfirmDialog(null, "再来十道题？？？", "提示", JOptionPane.YES_NO_OPTION);
		if (JOptionPane.OK_OPTION == op) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			l3.setText("");
			l4.setText("");
			score=0;
			b1.setEnabled(true);
		}else {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			l3.setText("");
			l4.setText("");
		}
	}

	public void ShowScore() {
		f = new JFrame("历史");
		f.setSize(150, 250);
		f.setLocationRelativeTo(null);

		JTextArea text = new JTextArea();
		text.setEditable(false);
		JScrollPane jsp = new JScrollPane(text);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		for (String str : biz.scoreRead()) {
			text.append(str + "\n");
		}

		f.add(jsp);
		f.setVisible(true);
	}
}
