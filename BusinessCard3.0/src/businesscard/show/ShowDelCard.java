package businesscard.show;

import javax.swing.JOptionPane;

import businesscard.biz.BusinessCardvOne;
import businesscard.entity.BusinessCard;

public class ShowDelCard {
	BusinessCardvOne biz = new BusinessCardvOne();
	public ShowDelCard(BusinessCard card) {
		String answer = JOptionPane.showInputDialog(null, "�����ؿ��ǣ�ɾ��������yes");
        if ("yes".equals(answer))// equals�ַ����Ա�
        	biz.delCard(card);
            JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
    }

}
