package businesscard.show;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesscard.biz.BusinessCardvOne;
import businesscard.entity.BusinessCard;

public class ShowFindByNum {
	BusinessCardvOne biz = new BusinessCardvOne();
	static BusinessCard oldCard=new BusinessCard();
	JFrame fByNum;
	JPanel pFind, pShow, pFunction;
	JLabel lFindNum, lProperty[];
	JTextField tFindNum, t[];
	JButton bFind, bCancel, bUpdata, bDelete;
	public void FindByNum() {
		fByNum = new JFrame("�绰�������");
		fByNum.setBounds(600, 450, 400, 250);

		lProperty = new JLabel[4];
		lProperty[0] = new JLabel("����:");
		lProperty[1] = new JLabel("�Ա�:");
		lProperty[2] = new JLabel("����:");
		lProperty[3] = new JLabel("�绰����:");
		lProperty[0].setPreferredSize(new Dimension(100, 50)); // �����ǩ��С

		t = new JTextField[4];
		t[0] = new JTextField("");
		t[1] = new JTextField("");
		t[2] = new JTextField("");
		t[3] = new JTextField("");

		pShow = new JPanel();
		pShow.setLayout(new GridLayout(2, 2));
		for (int i = 0; i < 4; i++) {
			pShow.add(lProperty[i]);
			t[i].setEditable(false);
			pShow.add(t[i]);

		}
		fByNum.add(pShow, BorderLayout.CENTER);

		lFindNum = new JLabel("�绰����:");
		tFindNum = new JTextField("");
		bFind = new JButton("����");
		bFind.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				oldCard = biz.findByNum(tFindNum.getText());
				if (null == oldCard) {
					JOptionPane.showMessageDialog(null, "δ�ҵ�������", "��ʾ", JOptionPane.WARNING_MESSAGE);
				} else {
					tFindNum.setText("");
					t[0].setText(oldCard.getName());
					t[1].setText(oldCard.getSex());
					t[2].setText("" + oldCard.getAge());
					t[3].setText(oldCard.getNum());
				}

			}
		});
		bCancel = new JButton("ȡ��");
		bCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fByNum.setVisible(false);
				new ShowMenu();
			}
		});

		pFind = new JPanel();
		pFind.setLayout(new GridLayout(1, 4));
		pFind.add(lFindNum);
		pFind.add(tFindNum);
		pFind.add(bFind);
		pFind.add(bCancel);
		fByNum.add(pFind, BorderLayout.NORTH);
		
		
		pFunction = new JPanel();
		bUpdata = new JButton("�޸�");
		bUpdata.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fByNum.setVisible(false);
				new ShowUpdataCard(oldCard);
			}
		});
		bDelete = new JButton("ɾ��");
		bDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String answer = JOptionPane.showInputDialog(null, "�����ؿ��ǣ�ɾ��������yes");
		        if ("yes".equals(answer)) {// equals�ַ����Ա�
		        	biz.delCard(oldCard);
		            JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
		            for(int i=0;i<4;i++) {
					t[i].setText("");
				}		
		    }
				
			}
		});
		bUpdata.setPreferredSize(new Dimension(130, 50));
		bDelete.setPreferredSize(new Dimension(130, 50));
		pFunction.add(bUpdata);
		pFunction.add(bDelete);
		fByNum.add(pFunction, BorderLayout.SOUTH);

		fByNum.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fByNum.setVisible(true);
	}

}
