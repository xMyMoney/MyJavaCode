package businesscard.entity;

import java.io.Serializable;

/**
 * 定义实体类BusinessCard
 * @author 
 *
 */
public class BusinessCard implements Serializable{   //因为以对象流写入对象，要实现Serializable接口序列化
	/**
	 * 
	 */
	private static final long serialVersionUID = 1978007294623813616L;
	private String name;  //姓名
	private int age;      //年龄
	private String sex;   //性别
	private String num;   //电话号码

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
