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
		fMenu=new JFrame("名片通信录");
		fMenu.setBounds(600, 450, 400, 350);
		
		fMenu.setLayout(new GridLayout(3, 1));
		
		bAdd=new JButton("添加");
		bAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fMenu.setVisible(false);
				new ShowAddCard();
				
			}
		});
		
		bFind=new JButton("查询");
		bFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fMenu.setVisible(false);
				new ShowFindCard();
				
			}
		});
		
		bShowAll=new JButton("显示所有名片");
		bShowAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fMenu.setVisible(false);
				new ShowSortByAge();
				
			}
		});
		
		bExit=new JButton("退出");
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
