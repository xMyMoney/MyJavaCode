package businesscard.show;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import businesscard.biz.FileUtil;

public class ShowMenu {
	JFrame fMenu;
	JButton bAdd,bFind,bShowAll,bExit;
	
	public ShowMenu() {
		fMenu=new JFrame("��Ƭͨ��¼");
		fMenu.setBounds(600, 450, 400, 350);
		
		fMenu.setLayout(new GridLayout(3, 1));
		
		bAdd=new JButton("���");
		bAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fMenu.setVisible(false);
				new ShowAddCard();
				
			}
		});
		
		bFind=new JButton("��ѯ");
		bFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fMenu.setVisible(false);
				new ShowFindCard();
				
			}
		});
		
		bShowAll=new JButton("��ʾ������Ƭ");
		bShowAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fMenu.setVisible(false);
				new ShowSortByAge();
				
			}
		});
		
		bExit=new JButton("�˳�");
		bExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileUtil.saveFile();
				System.exit(0);		
			}
		});
		
		fMenu.add(bAdd);
		fMenu.add(bFind);
		fMenu.add(bShowAll);
		fMenu.add(bExit);
		fMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fMenu.setVisible(true);
	}

}
