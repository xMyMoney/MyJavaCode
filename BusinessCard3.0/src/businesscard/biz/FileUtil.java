package businesscard.biz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import businesscard.date.Data;

public class FileUtil {
	static File f=new File("D:\\BusinessCard.dat");    //��D�̴���f�ļ�
	
	/**
	 * ʹ�ö�����д�����
	 */
	static public void saveFile() {
		try(ObjectOutputStream op=new ObjectOutputStream(new FileOutputStream(f))) {
			op.writeObject(Data.MyCards);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
