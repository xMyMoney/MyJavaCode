package businesscard.show;

import javax.swing.JOptionPane;

import businesscard.biz.BusinessCardvOne;

public class ShowFindCard {
	BusinessCardvOne biz = new BusinessCardvOne();

	public ShowFindCard() {
		try {
			String[] way = { "按姓名", "按电话号码" };
			String tips = null;
			tips = (String) JOptionPane.showInputDialog(null, "请选择查找方式", "提示", JOptionPane.QUESTION_MESSAGE, null, way,
					way[0]);
			if (tips.equals("按姓名")) {
				new ShowFindByName().FindByName();
			}
			if(tips.equals("按电话号码")) {
				new ShowFindByNum().FindByNum();
			}
		} catch (Exception e) {    //提示框点击取消 捕获空指针异常进行处理
			new ShowMenu();
		}
	}
}
