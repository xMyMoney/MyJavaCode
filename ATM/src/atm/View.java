package atm;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class View {

	Biz biz = new Biz();

	JFrame f;
	JLabel l1, l2, l3;
	JTextField t1, t2, t3;
	JButton b1, b2, b3, b4, b5;

	void showLogin() {
		f = new JFrame("ATM系统登陆");
		f.setSize(300, 200);
		f.setLocationRelativeTo(null);
		f.setLayout(new GridLayout(3, 2));

		l1 = new JLabel("卡号");
		l2 = new JLabel("密码");
		t1 = new JTextField();
		t2 = new JTextField();
		b1 = new JButton("登陆");
		b2 = new JButton("取消");

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (biz.login(t1.getText(), t2.getText())) {
					f.setVisible(false);
					showMenu();
				} else {
					JOptionPane.showMessageDialog(f, "卡号或密码错误！");
				}
			}
		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(b1);
		f.add(b2);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	void showMenu() {
		f = new JFrame("ATM");
		f.setSize(350, 350);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setResizable(false);

		l1 = new JLabel("欢迎使用ATM", JLabel.CENTER);
		l1.setFont(new Font(null, 0, 22));
		b1 = new JButton("显示余额");
		b2 = new JButton("存款");
		b3 = new JButton("取款");
		b4 = new JButton("修改密码");
		b5 = new JButton("退出");

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showBalance();

			}
		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showAddMoney();

			}
		});

		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showDelMoney();

			}
		});

		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showUpdataPass();

			}
		});

		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		l1.setBounds(1, 1, 335, 120);
		b1.setBounds(1, 120, 100, 50);
		b2.setBounds(1, 180, 100, 50);
		b3.setBounds(1, 240, 100, 50);
		b4.setBounds(233, 120, 100, 50);
		b5.setBounds(233, 240, 100, 50);
		f.add(l1);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	void showBalance() {
		JOptionPane.showMessageDialog(f, "当前余额:" + biz.myBalance());
	}

	void showAddMoney() {
		boolean flag = true;
		try {
			while (flag) {
				String money = JOptionPane.showInputDialog(f, "请输入存款金额", "存款", JOptionPane.PLAIN_MESSAGE);
				if (money.equals("")) {
					JOptionPane.showMessageDialog(f, "存款金额不能为0！");
				} else {
					if (biz.addMoney(money)) {
						JOptionPane.showMessageDialog(f, "存款成功！");
						flag = false;
					} else {
						JOptionPane.showMessageDialog(f, "请确认存款金额大于零");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void showDelMoney() {
		boolean flag = true;
		try {
			while (flag) {
				String money = JOptionPane.showInputDialog(f, "请输入取款金额", "取款", JOptionPane.PLAIN_MESSAGE);
				if (money.equals("")) {
					JOptionPane.showMessageDialog(f, "未输入取款金额！");
				} else {
					if (biz.delMoney(money)) {
						JOptionPane.showMessageDialog(f, "取款成功！");
						flag = false;
					} else {
						JOptionPane.showMessageDialog(f, "请确认取款金额是50或100的倍数");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void showUpdataPass() {
		f = new JFrame("修改密码");
		f.setSize(300, 200);
		f.setLocationRelativeTo(null);
		f.setLayout(new GridLayout(4, 2));

		l1 = new JLabel("旧密码");
		l2 = new JLabel("新密码");
		l3 = new JLabel("新密码");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		b1 = new JButton("修改");
		b2 = new JButton("取消");

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (biz.flagOldPass(t1.getText())) {
					if (biz.flagPass(t2.getText(), t3.getText())) {
						if (biz.updataPass(t3.getText())) {
							JOptionPane.showMessageDialog(f, "修改成功！");
							f.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(f, "密码长度必须不小于6且不能6位相同！");
						}
					} else {
						JOptionPane.showMessageDialog(f, "輸入新密碼不相同或未输入新密码！");
					}
				} else {
					JOptionPane.showMessageDialog(f, "旧密码输入错误或未输入密码！请重新输入！");
				}
			}
		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
			}
		});

		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(b1);
		f.add(b2);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
