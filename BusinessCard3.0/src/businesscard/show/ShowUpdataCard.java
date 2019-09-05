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
		lProperty[0]=new JLabel("姓名:");
		lProperty[1]=new JLabel("性别:");
		lProperty[2]=new JLabel("年龄:");
		lProperty[3]=new JLabel("电话号码:");
		lProperty[0].setPreferredSize(new Dimension(100, 50));   //建议标签大小
		
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
		
		bUpdata=new JButton("修改");
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
					JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.WARNING_MESSAGE);
					fUpdata.setVisible(false);
					new ShowMenu();
				}else {
					fUpdata.setVisible(false);
					new ShowMenu();
				}
				
			}
		});
	
		
		bCancel=new JButton("取消");	
		bCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fUpdata.setVisible(false);
				new ShowMenu();
				
			}
		});
		
		bUpdata.setPreferredSize(new Dimension(100, 50)); //建议按钮大小
		bCancel.setPreferredSize(new Dimension(100, 50));
		
		pFunction=new JPanel();
		pFunction.add(bUpdata);
		pFunction.add(bCancel);
		fUpdata.add(pFunction,BorderLayout.SOUTH);
		
		fUpdata.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fUpdata.setVisible(true);
	}

}
