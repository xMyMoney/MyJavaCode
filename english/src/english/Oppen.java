package english;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Oppen {
	JFrame f;
	JButton b;
	JLabel l;

	public void oppen() {

		f = new JFrame();
		f.setSize(700, 400);
		f.setLocation(600, 300);
		f.setLayout(null);
		f.setResizable(false);

		l = new JLabel("万恶英语", JLabel.CENTER);
		l.setSize(640, 250);
		l.setFont(new Font("Dialog", 2, 70));
		l.setForeground(Color.BLUE);
		f.add(l);

		b = new JButton("打开单词本");
		b.setSize(100, 50);
		b.setLocation(520, 250);
		f.add(b);

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				new Login().login();
			}
		});
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
