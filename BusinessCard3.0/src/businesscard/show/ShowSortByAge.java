package businesscard.show;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import businesscard.biz.BusinessCardvOne;
import businesscard.date.Data;
import businesscard.entity.BusinessCard;

public class ShowSortByAge {
	BusinessCardvOne biz=new BusinessCardvOne();
	JFrame fSort;
	JPanel pProperty,pFunction,pShowAll;
	JLabel lSort,l[];
	JButton bBig,bSmall,bExit;
	JTextArea tShowAll;
	
	public ShowSortByAge() {
		fSort=new JFrame("����");
		fSort.setBounds(600, 450, 400, 250);
		
		pProperty=new JPanel();
		pProperty.setLayout(new GridLayout(1, 4));
		JLabel[] l=new JLabel[4];
		l[0]=new JLabel("����");
		l[1]=new JLabel("�Ա�");
		l[2]=new JLabel("����");
		l[3]=new JLabel("�绰����");
		for(int i=0;i<4;i++) {
			pProperty.add(l[i]);
		}
		fSort.add(pProperty,BorderLayout.NORTH);
		
		
		pFunction=new JPanel();
		pFunction.setLayout(new GridLayout(1, 4));
		lSort=new JLabel("����",JLabel.CENTER);
		bBig=new JButton("��С");
		bBig.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tShowAll.setText("");
				biz.sortByAgeBig();
				showAll();
				
			}
		});
		
		bSmall=new JButton("С����");
		bSmall.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tShowAll.setText("");
				biz.sortByAgeSmall();
				showAll();
				
			}
		});
		
		bExit=new JButton("ȡ��");
		bExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fSort.setVisible(false);
				new ShowMenu();
				
			}
		});
		
		pFunction.add(lSort);
		pFunction.add(bBig);
		pFunction.add(bSmall);
		pFunction.add(bExit);
		fSort.add(pFunction,BorderLayout.SOUTH);
		
		pShowAll=new JPanel();
		pShowAll.setLayout(new BorderLayout());
		tShowAll=new JTextArea();
		tShowAll.setEditable(false);
		JScrollPane jp=new JScrollPane(tShowAll);
		pShowAll.add(jp);
		showAll();
		pShowAll.add(tShowAll);
		fSort.add(pShowAll);
		fSort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fSort.setVisible(true);
	}
	
	public void showAll() {
		for(BusinessCard card:Data.MyCards) {
			tShowAll.append(card.getName()+"\t     "+card.getSex()+"\t      "+card.getAge()+"\t         "+card.getNum()+"\n");
		}
	}
	

}
