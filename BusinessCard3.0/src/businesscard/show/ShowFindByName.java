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

public class ShowFindByName {
	BusinessCardvOne biz = new BusinessCardvOne();
	static BusinessCard oldCard=new BusinessCard();
	JFrame fByName;
	JPanel PFind, pShow, pFunction;
	JLabel lFindName, lProperty[];
	JTextField tFindName,t[];
	JButton bFind, bCancel, bUpdata, bDelete;
	public void FindByName() {
		fByName = new JFrame("��������");
		fByName.setBounds(600, 450, 400, 250);

		
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
		fByName.add(pShow, BorderLayout.CENTER);

		lFindName = new JLabel("����:");
		tFindName = new JTextField("");
		bFind = new JButton("����");
		bFind.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				oldCard = biz.findByName(tFindName.getText());
				if (null == oldCard) {
					JOptionPane.showMessageDialog(null, "δ�ҵ�������", "��ʾ", JOptionPane.WARNING_MESSAGE);
				} else {
					tFindName.setText("");
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
				fByName.setVisible(false);
				new ShowMenu();
			}
		});

		PFind = new JPanel();
		PFind.setLayout(new GridLayout(1, 4));
		PFind.add(lFindName);
		PFind.add(tFindName);
		PFind.add(bFind);
		PFind.add(bCancel);
		fByName.add(PFind, BorderLayout.NORTH);
		
		
		pFunction = new JPanel();
		bUpdata = new JButton("�޸�");
		bUpdata.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fByName.setVisible(false);
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
		fByName.add(pFunction, BorderLayout.SOUTH);

		fByName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fByName.setVisible(true);
	}
}
