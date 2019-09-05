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
		fByName = new JFrame("姓名查找");
		fByName.setBounds(600, 450, 400, 250);

		
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
		fByName.add(pShow, BorderLayout.CENTER);

		lFindName = new JLabel("姓名:");
		tFindName = new JTextField("");
		bFind = new JButton("查找");
		bFind.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				oldCard = biz.findByName(tFindName.getText());
				if (null == oldCard) {
					JOptionPane.showMessageDialog(null, "未找到！！！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					tFindName.setText("");
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
		bUpdata = new JButton("修改");
		bUpdata.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fByName.setVisible(false);
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
		fByName.add(pFunction, BorderLayout.SOUTH);

		fByName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fByName.setVisible(true);
	}
}
