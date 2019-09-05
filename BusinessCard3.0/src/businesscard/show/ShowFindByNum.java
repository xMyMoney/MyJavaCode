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
		fByNum = new JFrame("电话号码查找");
		fByNum.setBounds(600, 450, 400, 250);

		lProperty = new JLabel[4];
		lProperty[0] = new JLabel("姓名:");
		lProperty[1] = new JLabel("性别:");
		lProperty[2] = new JLabel("年龄:");
		lProperty[3] = new JLabel("电话号码:");
		lProperty[0].setPreferredSize(new Dimension(100, 50)); // 建议标签大小

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

		lFindNum = new JLabel("电话号码:");
		tFindNum = new JTextField("");
		bFind = new JButton("查找");
		bFind.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				oldCard = biz.findByNum(tFindNum.getText());
				if (null == oldCard) {
					JOptionPane.showMessageDialog(null, "未找到！！！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					tFindNum.setText("");
					t[0].setText(oldCard.getName());
					t[1].setText(oldCard.getSex());
					t[2].setText("" + oldCard.getAge());
					t[3].setText(oldCard.getNum());
				}

			}
		});
		bCancel = new JButton("取消");
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
		bUpdata = new JButton("修改");
		bUpdata.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fByNum.setVisible(false);
				new ShowUpdataCard(oldCard);
			}
		});
		bDelete = new JButton("删除");
		bDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String answer = JOptionPane.showInputDialog(null, "请慎重考虑，删除请输入yes");
		        if ("yes".equals(answer)) {// equals字符串对比
		        	biz.delCard(oldCard);
		            JOptionPane.showMessageDialog(null, "删除成功");
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
