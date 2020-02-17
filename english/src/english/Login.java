package english;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Login {
	public int time = 10;
	public int progressvalue = 1;

	public void login() {
		JFrame f = new JFrame();
		f.setSize(400, 250);
		f.setLocation(650, 250);
		f.setLayout(null);

		JLabel b = new JLabel("正在打开......", JLabel.CENTER);
		b.setFont(new Font("Dialog", 2, 20));
		b.setBounds(40, 60, 150, 30);
		f.add(b);

		JProgressBar pbar = new JProgressBar();
		pbar.setBounds(200, 100, 150, 30);
		pbar.setMaximum(100);
		pbar.setValue(0);
		pbar.setStringPainted(true);
		f.setVisible(true);
		f.add(pbar);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Thread thread = new Thread() {
			public void run() {
				boolean flag = true;
				while (flag) {
					if (progressvalue <= 100) {
						try {
							Thread.sleep(time);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pbar.setValue(progressvalue);
						progressvalue++;
						time += 0.8;
					}
					if (progressvalue > 100) {
						flag = false;
						f.setVisible(false);
						new Menu();
					}

				}

			}
		};

		thread.start();

	}

}
