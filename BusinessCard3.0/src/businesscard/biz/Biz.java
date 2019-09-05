package businesscard.biz;

import businesscard.entity.BusinessCard;

/**
 * 定义接口
 * 定义通用方法
 * @author 
 *
 */
public interface Biz{
	
	//添加方法
	public boolean addCard(BusinessCard card);
	
	//查找方法
	public BusinessCard findByName(String name);
	public BusinessCard findByNum(String num);
	
	//修改方法
	public boolean updataCard(BusinessCard oldt,BusinessCard newt);
	
	//删除方法
	public boolean delCard(BusinessCard card);
	
	//排序方法由大到小
	public void sortByAgeBig();
	
	//排序方法有小到大
	public void sortByAgeSmall();
	

}
