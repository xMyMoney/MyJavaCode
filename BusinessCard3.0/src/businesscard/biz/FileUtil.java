package businesscard.biz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import businesscard.date.Data;

public class FileUtil {
	static File f=new File("D:\\BusinessCard.dat");    //在D盘创建f文件
	
	/**
	 * 使用对象流写入对象
	 */
	static public void saveFile() {
		try(ObjectOutputStream op=new ObjectOutputStream(new FileOutputStream(f))) {
			op.writeObject(Data.MyCards);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
