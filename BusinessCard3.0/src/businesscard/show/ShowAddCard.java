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

public class ShowAddCard {
	BusinessCardvOne biz=new BusinessCardvOne();
	JFrame fAdd;
	JPanel pShow,pFunction;
	JLabel[] l;
	JTextField[] t;
	JButton bAdd,bCancel;
	public ShowAddCard() {
		fAdd=new JFrame();
		fAdd.setBounds(600, 450, 400, 250);
		
		l=new JLabel[4];
		l[0]=new JLabel("����:");
		l[1]=new JLabel("�Ա�:");
		l[2]=new JLabel("����:");
		l[3]=new JLabel("�绰����:");
		l[0].setPreferredSize(new Dimension(100, 50));   //�����ǩ��С
		
		t=new JTextField[4];
		t[0]=new JTextField("");
		t[1]=new JTextField("");
		t[2]=new JTextField("");
		t[3]=new JTextField("");
			
		pShow=new JPanel();
		pShow.setLayout(new GridLayout(2, 2));
		for(int i=0;i<4;i++) {
			pShow.add(l[i]);
			pShow.add(t[i]);
		}
		fAdd.add(pShow,BorderLayout.NORTH);
		
		bAdd=new JButton("���");
		//Ϊb1��ť��Ӽ����¼�
		bAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BusinessCard card=new BusinessCard(); //��������
				card.setName(t[0].getText());
				card.setSex(t[1].getText());
				card.setAge(Integer.parseInt(t[2].getText()));   //���õ����ַ���ת��ΪInt��
				card.setNum(t[3].getText());
	
				biz.addCard(card);                    //��������ӵ�������
				JOptionPane.showMessageDialog(null, "��ӳɹ���", "��ʾ", JOptionPane.WARNING_MESSAGE);
				fAdd.setVisible(false);
				new ShowMenu();
			}
		});
		
		
		bCancel=new JButton("ȡ��");	
		//Ϊb2��ť��Ӽ����¼�
		bCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fAdd.setVisible(false);                  //��ǰ���ڹر�
				new ShowMenu();                      // ���ص����˵�  
				
			}
		});
		
		bAdd.setPreferredSize(new Dimension(100, 50)); //���鰴ť��С
		bCancel.setPreferredSize(new Dimension(100, 50));
		
		pFunction=new JPanel();
		pFunction.add(bAdd);
		pFunction.add(bCancel);
		fAdd.add(pFunction,BorderLayout.SOUTH);
		
		fAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fAdd.setVisible(true);
	}

}
