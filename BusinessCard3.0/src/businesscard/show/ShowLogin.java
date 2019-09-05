package businesscard.show;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShowLogin {
	JFrame fCard;
	JButton bExperience,bExit;
	JLabel l;
	public ShowLogin() {
		fCard=new JFrame("名片通信录");
		fCard.setBounds(600, 450, 350, 300);
		
		fCard.setLayout(null);
		
		bExperience=new JButton("体验一下");
		bExperience.setBounds(50, 150, 100, 50);
		bExperience.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fCard.setVisible(false);
				new ShowMenu();	
			}
		});	
		
		bExit=new JButton("特别嫌弃");
		bExit.setBounds(200, 150, 100, 50);
		bExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
		fCard.add(bExperience);
		fCard.add(bExit);
		
		fCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fCard.setVisible(true);
	}
}
