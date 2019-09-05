package businesscard.biz;

import java.util.Collections;
import java.util.Comparator;

import businesscard.date.Data;
import businesscard.entity.BusinessCard;

/**
 * 实现Biz接口 ，重写方法
 * @author 
 *
 */
public class BusinessCardvOne implements Biz{

	@Override
	public boolean addCard(BusinessCard card) {
		if(null == card) {
			return false;                         //如果传入的对象为空，返回false
		}
		Data.MyCards.add(card);
		return true;
	}
	
	//通过姓名查找
	@Override
	public BusinessCard findByName(String name) {
		for(BusinessCard card:Data.MyCards) {     //forch遍历Data.MyCards
			if(card.getName().equals(name)) {     //每个Card对象中的Name与传入的name对比
				return card;                      //返回包含name的整个对象
			}
		}
		return null;
	}

	//通过电话号码查找
	@Override
	public BusinessCard findByNum(String num) {   
		for(BusinessCard card:Data.MyCards) {
			if(card.getNum().equals(num)) {
				return card;
			}
		}
		return null;
	}
	
	@Override
	public boolean updataCard(BusinessCard oldcard, BusinessCard newcard) {  
		int index=Data.MyCards.indexOf(oldcard);    //传入要修改的Card,并找到在集合中的位置
		Data.MyCards.set(index, newcard);           //将新的Card进行替换
		return true;
	}

	@Override
	public boolean delCard(BusinessCard card) {     //在集合中删除
		Data.MyCards.remove(card);
		return true;
	}

	@Override
	public void sortByAgeBig() {                    //按年龄由大到小排序
		Collections.sort(Data.MyCards, Collections.reverseOrder(new CardComparator_age()));
	}
	
	@Override
	public void sortByAgeSmall() {                   //按年龄由小到大排序
		Collections.sort(Data.MyCards, new CardComparator_age());
		
	}
	/**
	 * 重写Collections ，实现Comparator<BusinessCard>接口
	 * @author  
	 *
	 */
	class CardComparator_age implements Comparator<BusinessCard>{

		@Override
		public int compare(BusinessCard card1, BusinessCard card2) {
			if(card1.getAge()>card2.getAge())
				return 1;
			if(card1.getAge()<card2.getAge())
				return -1;
			return 0;
		}
		
	}

	
}
