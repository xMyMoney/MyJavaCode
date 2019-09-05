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

public class ShowUpdataCard {
	BusinessCardvOne biz=new BusinessCardvOne(); 
	JFrame fUpdata;
	JPanel pShow,pFunction;
	JLabel[] lProperty;
	JTextField[] tProperty;
	JButton bUpdata,bCancel;
	public ShowUpdataCard(BusinessCard oldCard) {
		fUpdata=new JFrame();
		fUpdata.setBounds(600, 450, 400, 250);
		
		lProperty=new JLabel[4];
		lProperty[0]=new JLabel("����:");
		lProperty[1]=new JLabel("�Ա�:");
		lProperty[2]=new JLabel("����:");
		lProperty[3]=new JLabel("�绰����:");
		lProperty[0].setPreferredSize(new Dimension(100, 50));   //�����ǩ��С
		
		tProperty=new JTextField[4];
		tProperty[0]=new JTextField(oldCard.getName());
		tProperty[1]=new JTextField(oldCard.getSex());
		tProperty[2]=new JTextField(""+oldCard.getAge());
		tProperty[3]=new JTextField(oldCard.getNum());
			
		pShow=new JPanel();
		pShow.setLayout(new GridLayout(2, 2));
		for(int i=0;i<4;i++) {
			pShow.add(lProperty[i]);
			pShow.add(tProperty[i]);
		}
		fUpdata.add(pShow,BorderLayout.NORTH);
		
		bUpdata=new JButton("�޸�");
		bUpdata.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BusinessCard newCard=new BusinessCard();
				newCard.setName(tProperty[0].getText());
				newCard.setSex(tProperty[1].getText());
				newCard.setAge(Integer.parseInt(tProperty[2].getText()));
				newCard.setNum(tProperty[3].getText());
				boolean judge=biz.updataCard(oldCard,newCard);
				if(judge) {
					JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ", JOptionPane.WARNING_MESSAGE);
					fUpdata.setVisible(false);
					new ShowMenu();
				}else {
					fUpdata.setVisible(false);
					new ShowMenu();
				}
				
			}
		});
	
		
		bCancel=new JButton("ȡ��");	
		bCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fUpdata.setVisible(false);
				new ShowMenu();
				
			}
		});
		
		bUpdata.setPreferredSize(new Dimension(100, 50)); //���鰴ť��С
		bCancel.setPreferredSize(new Dimension(100, 50));
		
		pFunction=new JPanel();
		pFunction.add(bUpdata);
		pFunction.add(bCancel);
		fUpdata.add(pFunction,BorderLayout.SOUTH);
		
		fUpdata.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fUpdata.setVisible(true);
	}

}
