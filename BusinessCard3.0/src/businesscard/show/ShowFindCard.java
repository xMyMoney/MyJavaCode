package businesscard.show;

import javax.swing.JOptionPane;

import businesscard.biz.BusinessCardvOne;

public class ShowFindCard {
	BusinessCardvOne biz = new BusinessCardvOne();

	public ShowFindCard() {
		try {
			String[] way = { "������", "���绰����" };
			String tips = null;
			tips = (String) JOptionPane.showInputDialog(null, "��ѡ����ҷ�ʽ", "��ʾ", JOptionPane.QUESTION_MESSAGE, null, way,
					way[0]);
			if (tips.equals("������")) {
				new ShowFindByName().FindByName();
			}
			if(tips.equals("���绰����")) {
				new ShowFindByNum().FindByNum();
			}
		} catch (Exception e) {    //��ʾ����ȡ�� �����ָ���쳣���д���
			new ShowMenu();
		}
	}
}
