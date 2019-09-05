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
		f = new JFrame("ATMϵͳ��½");
		f.setSize(300, 200);
		f.setLocationRelativeTo(null);
		f.setLayout(new GridLayout(3, 2));

		l1 = new JLabel("����");
		l2 = new JLabel("����");
		t1 = new JTextField();
		t2 = new JTextField();
		b1 = new JButton("��½");
		b2 = new JButton("ȡ��");

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (biz.login(t1.getText(), t2.getText())) {
					f.setVisible(false);
					showMenu();
				} else {
					JOptionPane.showMessageDialog(f, "���Ż��������");
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

		l1 = new JLabel("��ӭʹ��ATM", JLabel.CENTER);
		l1.setFont(new Font(null, 0, 22));
		b1 = new JButton("��ʾ���");
		b2 = new JButton("���");
		b3 = new JButton("ȡ��");
		b4 = new JButton("�޸�����");
		b5 = new JButton("�˳�");

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
		JOptionPane.showMessageDialog(f, "��ǰ���:" + biz.myBalance());
	}

	void showAddMoney() {
		boolean flag = true;
		try {
			while (flag) {
				String money = JOptionPane.showInputDialog(f, "����������", "���", JOptionPane.PLAIN_MESSAGE);
				if (money.equals("")) {
					JOptionPane.showMessageDialog(f, "������Ϊ0��");
				} else {
					if (biz.addMoney(money)) {
						JOptionPane.showMessageDialog(f, "���ɹ���");
						flag = false;
					} else {
						JOptionPane.showMessageDialog(f, "��ȷ�ϴ���������");
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
				String money = JOptionPane.showInputDialog(f, "������ȡ����", "ȡ��", JOptionPane.PLAIN_MESSAGE);
				if (money.equals("")) {
					JOptionPane.showMessageDialog(f, "δ����ȡ���");
				} else {
					if (biz.delMoney(money)) {
						JOptionPane.showMessageDialog(f, "ȡ��ɹ���");
						flag = false;
					} else {
						JOptionPane.showMessageDialog(f, "��ȷ��ȡ������50��100�ı���");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void showUpdataPass() {
		f = new JFrame("�޸�����");
		f.setSize(300, 200);
		f.setLocationRelativeTo(null);
		f.setLayout(new GridLayout(4, 2));

		l1 = new JLabel("������");
		l2 = new JLabel("������");
		l3 = new JLabel("������");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		b1 = new JButton("�޸�");
		b2 = new JButton("ȡ��");

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (biz.flagOldPass(t1.getText())) {
					if (biz.flagPass(t2.getText(), t3.getText())) {
						if (biz.updataPass(t3.getText())) {
							JOptionPane.showMessageDialog(f, "�޸ĳɹ���");
							f.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(f, "���볤�ȱ��벻С��6�Ҳ���6λ��ͬ��");
						}
					} else {
						JOptionPane.showMessageDialog(f, "ݔ�����ܴa����ͬ��δ���������룡");
					}
				} else {
					JOptionPane.showMessageDialog(f, "��������������δ�������룡���������룡");
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
