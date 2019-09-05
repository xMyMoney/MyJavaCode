package businesscard.show;

import javax.swing.JOptionPane;

import businesscard.biz.BusinessCardvOne;
import businesscard.entity.BusinessCard;

public class ShowDelCard {
	BusinessCardvOne biz = new BusinessCardvOne();
	public ShowDelCard(BusinessCard card) {
		String answer = JOptionPane.showInputDialog(null, "请慎重考虑，删除请输入yes");
        if ("yes".equals(answer))// equals字符串对比
        	biz.delCard(card);
            JOptionPane.showMessageDialog(null, "删除成功");
    }

}
