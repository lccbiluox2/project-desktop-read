package cn.biluo.showlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadContentTextSize {

	 /*********************************************************/
   /**
    * @param args
    */

   public static int setFontSize(String value) {
   	String key = "FontSize";
       Properties properties = new Properties(); // ����Properties����
       properties.setProperty(key, value); // ���������ļ�ֵ
       try {
           FileOutputStream out = new FileOutputStream("mybook\\ReadContentTextSize.properties");// �������������
           properties.store(out, "FontSize"); // ����Ϣͨ����д�뵽�����ļ�
           out.close(); // �ر���
           return 1;
       } catch (Exception e) {
           e.printStackTrace();
           return -1;
       }
   }

   
   /*********************************************************/
   /**
    * @throws IOException 
    * @throws FileNotFoundException ****************************************************************/
   public static String getFontSize() {
   	String key = "FontSize";
   	Properties pps = new Properties();
       try {
			pps.load(new FileInputStream("mybook\\ReadContentTextSize.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
       String fontsize = pps.getProperty(key);
	 return fontsize;
       
   }



   /*********************************************************/
}
