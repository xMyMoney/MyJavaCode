package businesscard.biz;

import businesscard.entity.BusinessCard;

/**
 * ����ӿ�
 * ����ͨ�÷���
 * @author 
 *
 */
public interface Biz{
	
	//��ӷ���
	public boolean addCard(BusinessCard card);
	
	//���ҷ���
	public BusinessCard findByName(String name);
	public BusinessCard findByNum(String num);
	
	//�޸ķ���
	public boolean updataCard(BusinessCard oldt,BusinessCard newt);
	
	//ɾ������
	public boolean delCard(BusinessCard card);
	
	//���򷽷��ɴ�С
	public void sortByAgeBig();
	
	//���򷽷���С����
	public void sortByAgeSmall();
	

}
