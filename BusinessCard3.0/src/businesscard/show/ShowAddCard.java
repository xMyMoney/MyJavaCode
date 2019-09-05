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
		l[0]=new JLabel("姓名:");
		l[1]=new JLabel("性别:");
		l[2]=new JLabel("年龄:");
		l[3]=new JLabel("电话号码:");
		l[0].setPreferredSize(new Dimension(100, 50));   //建议标签大小
		
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
		
		bAdd=new JButton("添加");
		//为b1按钮添加监听事件
		bAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BusinessCard card=new BusinessCard(); //创建对象
				card.setName(t[0].getText());
				card.setSex(t[1].getText());
				card.setAge(Integer.parseInt(t[2].getText()));   //将得到到字符串转换为Int型
				card.setNum(t[3].getText());
	
				biz.addCard(card);                    //将对象添加到数据中
				JOptionPane.showMessageDialog(null, "添加成功！", "提示", JOptionPane.WARNING_MESSAGE);
				fAdd.setVisible(false);
				new ShowMenu();
			}
		});
		
		
		bCancel=new JButton("取消");	
		//为b2按钮添加监听事件
		bCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fAdd.setVisible(false);                  //当前窗口关闭
				new ShowMenu();                      // 返回到主菜单  
				
			}
		});
		
		bAdd.setPreferredSize(new Dimension(100, 50)); //建议按钮大小
		bCancel.setPreferredSize(new Dimension(100, 50));
		
		pFunction=new JPanel();
		pFunction.add(bAdd);
		pFunction.add(bCancel);
		fAdd.add(pFunction,BorderLayout.SOUTH);
		
		fAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fAdd.setVisible(true);
	}

}
