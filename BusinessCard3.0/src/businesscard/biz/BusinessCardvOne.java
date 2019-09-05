package businesscard.biz;

import java.util.Collections;
import java.util.Comparator;

import businesscard.date.Data;
import businesscard.entity.BusinessCard;

/**
 * ʵ��Biz�ӿ� ����д����
 * @author 
 *
 */
public class BusinessCardvOne implements Biz{

	@Override
	public boolean addCard(BusinessCard card) {
		if(null == card) {
			return false;                         //�������Ķ���Ϊ�գ�����false
		}
		Data.MyCards.add(card);
		return true;
	}
	
	//ͨ����������
	@Override
	public BusinessCard findByName(String name) {
		for(BusinessCard card:Data.MyCards) {     //forch����Data.MyCards
			if(card.getName().equals(name)) {     //ÿ��Card�����е�Name�봫���name�Ա�
				return card;                      //���ذ���name����������
			}
		}
		return null;
	}

	//ͨ���绰�������
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
		int index=Data.MyCards.indexOf(oldcard);    //����Ҫ�޸ĵ�Card,���ҵ��ڼ����е�λ��
		Data.MyCards.set(index, newcard);           //���µ�Card�����滻
		return true;
	}

	@Override
	public boolean delCard(BusinessCard card) {     //�ڼ�����ɾ��
		Data.MyCards.remove(card);
		return true;
	}

	@Override
	public void sortByAgeBig() {                    //�������ɴ�С����
		Collections.sort(Data.MyCards, Collections.reverseOrder(new CardComparator_age()));
	}
	
	@Override
	public void sortByAgeSmall() {                   //��������С��������
		Collections.sort(Data.MyCards, new CardComparator_age());
		
	}
	/**
	 * ��дCollections ��ʵ��Comparator<BusinessCard>�ӿ�
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
