package comman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class DaoruBookCount {

	
	
	
	 /*********************************************************/
    /**
     * @param args
     */

    public static int setCount(String value) {
    	String key = "count";
        Properties properties = new Properties(); // 定义Properties对象
        properties.setProperty(key, value); // 设置属性文件值
        try {
            FileOutputStream out = new FileOutputStream("mybook\\daorubookCount.properties");// 创建输出流对象
            properties.store(out, "bookcount"); // 将信息通过流写入到属性文件
            out.close(); // 关闭流
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
    public static String getCount() {
    	String key = "count";
    	Properties pps = new Properties();
        try {
			pps.load(new FileInputStream("mybook\\daorubookCount.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        String count = pps.getProperty(key);
		return count;
        
    }



    /*********************************************************/
}
