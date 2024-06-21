package comman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StateJFrame {

	
	 /**********�洢״̬��***********************************************/
   /**
    * @param args
    */

   public static int setStateJFrame(String value) {
   	String key = "StateJFrame";
       Properties properties = new Properties(); // ����Properties����
       properties.setProperty(key, value); // ���������ļ�ֵ
       try {
           FileOutputStream out = new FileOutputStream("mybook\\StateJFrame.properties");// �������������
           properties.store(out, "StateJFrame"); // ����Ϣͨ����д�뵽�����ļ�
           out.close(); // �ر���
           return 1;
       } catch (Exception e) {
           e.printStackTrace();
           return -1;
       }
   }

   
   /***********��ȡ״̬��**********************************************/
   /**
    * @throws IOException 
    * @throws FileNotFoundException ****************************************************************/
   public static String getStateJFrame() {
   	String key = "StateJFrame";
   	Properties pps = new Properties();
       try {
			pps.load(new FileInputStream("mybook\\StateJFrame.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
       String count = pps.getProperty(key);
	   return count;
       
   }



   /**********�ϲ�״̬��***********************************************/
   	public static String combineStateJFrame() {
	   	String key = "StateJFrame";
	   	Properties pps = new Properties();
	       try {
				pps.load(new FileInputStream("mybook\\StateJFrame.properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	       String count = pps.getProperty(key);
		   return count;
	       
	   }
   
   /**********���״̬��
 * @return ***********************************************/
	public static  String[] splitStateJFrame(String str) {
		String[] arr = new String[3];
		String[] first = str.split("~~");
		String[]   second = first[2].split("##");
		int ids = Integer.parseInt(second[0])+1;
		arr[0] = first[1]+"\\"+(ids+"")+".txt";
		arr[1] = first[0];
		arr[2] = first[2];
		return arr;
	   }
   /*********************************************************/
   /*********************************************************/
}