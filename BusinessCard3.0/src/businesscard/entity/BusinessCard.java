package businesscard.entity;

import java.io.Serializable;

/**
 * ����ʵ����BusinessCard
 * @author 
 *
 */
public class BusinessCard implements Serializable{   //��Ϊ�Զ�����д�����Ҫʵ��Serializable�ӿ����л�
	/**
	 * 
	 */
	private static final long serialVersionUID = 1978007294623813616L;
	private String name;  //����
	private int age;      //����
	private String sex;   //�Ա�
	private String num;   //�绰����

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

}
