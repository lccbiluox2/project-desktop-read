package comman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StateJFrame {

	
	 /**********存储状态栏***********************************************/
   /**
    * @param args
    */

   public static int setStateJFrame(String value) {
   	String key = "StateJFrame";
       Properties properties = new Properties(); // 定义Properties对象
       properties.setProperty(key, value); // 设置属性文件值
       try {
           FileOutputStream out = new FileOutputStream("mybook\\StateJFrame.properties");// 创建输出流对象
           properties.store(out, "StateJFrame"); // 将信息通过流写入到属性文件
           out.close(); // 关闭流
           return 1;
       } catch (Exception e) {
           e.printStackTrace();
           return -1;
       }
   }

   
   /***********读取状态栏**********************************************/
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



   /**********合并状态栏***********************************************/
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
   
   /**********拆分状态栏
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