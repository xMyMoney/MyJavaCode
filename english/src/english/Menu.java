package english;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Menu {
	JFrame f;
	JPanel p1, p2;
	JButton b1, b2, b3, b4, b5;
	JLabel l1;

	public Menu() {
		f = new JFrame();
		f.setSize(640, 400);
		f.setLocation(600, 300);
		f.setLayout(null);
		f.setResizable(false);
		p1 = new JPanel();
		p1.setBackground(Color.white);

		b1 = new JButton("新单词录入");
		b1.setPreferredSize(new Dimension(100, 50));
		b2 = new JButton("旧单词复习");
		b2.setPreferredSize(new Dimension(100, 50));
		b3 = new JButton("单词检索");
		b3.setPreferredSize(new Dimension(100, 50));
		b4 = new JButton("单词一览");
		b4.setPreferredSize(new Dimension(100, 50));
		b5 = new JButton("合上单词本");
		b5.setPreferredSize(new Dimension(100, 50));

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);

		p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		p2.setLayout(new FlowLayout());

		l1 = new JLabel("万恶英语");
		l1.setPreferredSize(new Dimension(100, 300));
		p2.add(l1);

		JSplitPane s1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
		s1.setDividerLocation(150);

		f.setContentPane(s1);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddWord a1 = new AddWord();
				p2.add(a1.p1);
				a1.addWord();

			}
		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				WordReview r1 = new WordReview();
				p2.add(r1.p1);
				r1.review();
			}
		});

		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				WordRetrieval w1 = new WordRetrieval();
				p2.add(w1.p1);
				w1.Retrieval();

			}
		});

		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WordBrowsing().Browsing();

			}
		});

		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Exit().exit();

			}
		});
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
