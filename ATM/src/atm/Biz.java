package atm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Biz {

	Account account = new Account();

	//��ȡ�˻���Ϣ
	File data = new File("MyData.txt");
	Biz() {
		try (BufferedReader fr = new BufferedReader(new FileReader(data))) {
			String line = null;
			while ((line = fr.readLine()) != null) {
				String[] str = line.split(" ");
				account.setNum(str[0]);
				account.setPass(str[1]);
				account.setMoney(str[2]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// ��½
	public boolean login(String num, String pass) {
		if (num.equals(account.getNum()) && pass.equals(account.getPass())) {
			return true;
		} else {
			return false;
		}
	}

	// ��ѯ���
	public String myBalance() {
		return account.getMoney();
	}

	// ���
	public boolean addMoney(String money) {
		if (Integer.parseInt(money) > 0) {
			String MyMoney = Integer.parseInt(money) + Integer.parseInt(account.getMoney()) + "";
			account.setMoney(MyMoney);
			writeFileMoney(MyMoney);
			return true;
		} else {
			return false;
		}
	}

	// ȡ��
	public boolean delMoney(String money) {
		if (Integer.parseInt(money) % 100 == 0 || Integer.parseInt(money) % 50 == 0) {
			String MyMoney = Integer.parseInt(account.getMoney()) - Integer.parseInt(money) + "";
			account.setMoney(MyMoney);
			writeFileMoney(MyMoney);
			return true;
		} else {
			return false;
		}
	}

	// �жϾ�����
	public boolean flagOldPass(String pass) {
		if(pass==null) {
			return false;
		}
		if (pass.equals(account.getPass())) {
			return true;
		} else {
			return false;
		}
	}

	// �ж��������������Ƿ���ͬ
	public boolean flagPass(String pass1, String pass2) {
		if(pass1==null||pass2==null) {
			return false;
		}
		if (pass1.equals(pass2)) {
			return true;
		}
		return false;
	}

	// �޸�����
	public boolean updataPass(String newPass) {
		if (newPass.length() >= 6) {
			for (int i = 0; i < newPass.length(); i++) {
				if (newPass.charAt(0) != newPass.charAt(i)) {
					account.setPass(newPass);
					writeFilePass(newPass);
					return true;
				}
			}
		}
		return false;
	}
	
	//���ļ���������
	public void writeFilePass(String pass) {
		try(BufferedWriter fw=new BufferedWriter(new FileWriter("MyData.txt"))) {
			String str=account.getNum()+" "+pass+" "+account.getMoney();
			fw.write(str);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//���ļ��������
	public void writeFileMoney(String money) {
		try(BufferedWriter fw=new BufferedWriter(new FileWriter("MyData.txt"))) {
			String str=account.getNum()+" "+account.getPass()+" "+money;
			fw.write(str);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
