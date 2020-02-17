package english;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WordReview {
	JPanel p1 = new JPanel();

	JLabel l1, l2;
	JTextField t1, t2;
	JButton b1, b2, b3;

	String line, s;
	ArrayList<String> list = new ArrayList<String>();

	public void review() {
		p1.setSize(500, 370);
		p1.setLayout(null);
		p1.setBackground(Color.BLUE);

		l1 = new JLabel("中文:");
		l1.setFont(new Font("Dialog", 1, 20));
		l1.setForeground(Color.YELLOW);
		l1.setSize(250, 100);
		l1.setLocation(30, 1);

		p1.add(l1);

		t1 = new JTextField();
		t1.setSize(120, 40);
		t1.setLocation(80, 45);
		t1.setFont(new Font("Dialog", 1, 20));
		p1.add(t1);

		l2 = new JLabel("English:");
		l2.setFont(new Font("Dialog", 1, 20));
		l2.setForeground(Color.YELLOW);
		l2.setSize(250, 100);
		l2.setLocation(1, 100);
		p1.add(l2);

		t2 = new JTextField();
		t2.setSize(120, 40);
		t2.setLocation(80, 145);
		t2.setFont(new Font("Dialog", 1, 20));
		p1.add(t2);

		b1 = new JButton("随机复习！");
		b1.setBounds(300, 100, 150, 50);
		p1.add(b1);

		b2 = new JButton("核对");
		b2.setBounds(220, 210, 70, 50);
		p1.add(b2);

		b3 = new JButton("退出");
		b3.setBounds(320, 210, 70, 50);
		p1.add(b3);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Cheak c1=new Cheak();
				s=c1.cheak2();
				String s1 = s.replaceAll("[^\\u4e00-\\u9fa5]", "");
				t1.setText(s1);
				t2.setText("");
			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s2 = s.replaceAll("[^a-z^A-Z]", "");
				if (s2.equals(t2.getText())) {
					int n=JOptionPane.showConfirmDialog(null,"正确！是否继续复习？","提示", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.OK_OPTION) {
						JOptionPane.showMessageDialog(null, "按随机复习继续！", "提示消息", JOptionPane.WARNING_MESSAGE);
					}
					if(n==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "按退出回到菜单！", "提示消息", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "错误！请重新填写", "提示消息", JOptionPane.WARNING_MESSAGE);
					t2.setText("");
				}
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p1.setVisible(false);
			}
		});
		p1.setVisible(true);
	}

}
